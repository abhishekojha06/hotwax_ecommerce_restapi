package com.hotwaxcommerce.demo.controller;

import com.hotwaxcommerce.demo.dto.OrderRequest;
import com.hotwaxcommerce.demo.model.*;
import com.hotwaxcommerce.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderHeaderRepository orderHeaderRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ContactMechRepository contactRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    // ✅ POST: Create a new order
    @PostMapping("/ojha")
    public OrderHeader createOrder(@RequestBody OrderRequest request) {
        System.out.println("✅ Received OrderRequest for customer_id: " + request.getCustomer_id());

        // Validate customer and contacts
        Customer customer = customerRepo.findById(request.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        ContactMech shipping = contactRepo.findById(request.getShipping_contact_mech_id())
                .orElseThrow(() -> new RuntimeException("Shipping contact not found"));

        ContactMech billing = contactRepo.findById(request.getBilling_contact_mech_id())
                .orElseThrow(() -> new RuntimeException("Billing contact not found"));

        OrderHeader order = new OrderHeader();
        order.setOrderDate(new Date());
        order.setCustomer(customer);
        order.setShippingContact(shipping);
        order.setBillingContact(billing);

        OrderHeader savedOrder = orderHeaderRepo.save(order);

        // Save items
        for (OrderRequest.OrderItemDTO item : request.getOrder_items()) {
            Product product = productRepo.findById(item.getProduct_id())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + item.getProduct_id()));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(product);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setStatus(item.getStatus());

            orderItemRepo.save(orderItem);
        }

        return savedOrder;
    }

    // ✅ GET: Get specific order by ID
    @GetMapping("/{orderId}")
    public Map<String, Object> getOrder(@PathVariable Integer orderId) {
        OrderHeader order = orderHeaderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        List<OrderItem> items = orderItemRepo.findAll();

        Map<String, Object> response = new HashMap<>();
        response.put("order_id", order.getOrderId());
        response.put("order_date", order.getOrderDate());
        response.put("customer", order.getCustomer());
        response.put("shipping_contact", order.getShippingContact());
        response.put("billing_contact", order.getBillingContact());

        // Filter only items for this order
        List<OrderItem> orderItems = items.stream()
                .filter(i -> i.getOrder().getOrderId().equals(orderId))
                .toList();

        response.put("order_items", orderItems);

        return response;
    }

    // ✅ Optional: GET all orders
    @GetMapping
    public List<OrderHeader> getAllOrders() {
        return orderHeaderRepo.findAll();
    }
}
