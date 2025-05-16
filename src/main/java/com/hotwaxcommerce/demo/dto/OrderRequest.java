package com.hotwaxcommerce.demo.dto;

import java.util.List;

public class OrderRequest {

    private Integer customer_id;
    private Integer shipping_contact_mech_id;
    private Integer billing_contact_mech_id;
    private List<OrderItemDTO> order_items;

    // ✅ Getters and Setters
    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getShipping_contact_mech_id() {
        return shipping_contact_mech_id;
    }

    public void setShipping_contact_mech_id(Integer shipping_contact_mech_id) {
        this.shipping_contact_mech_id = shipping_contact_mech_id;
    }

    public Integer getBilling_contact_mech_id() {
        return billing_contact_mech_id;
    }

    public void setBilling_contact_mech_id(Integer billing_contact_mech_id) {
        this.billing_contact_mech_id = billing_contact_mech_id;
    }

    public List<OrderItemDTO> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<OrderItemDTO> order_items) {
        this.order_items = order_items;
    }

    // ✅ Inner class for order items
    public static class OrderItemDTO {

        private Integer product_id;
        private Integer quantity;
        private String status;

        public Integer getProduct_id() {
            return product_id;
        }

        public void setProduct_id(Integer product_id) {
            this.product_id = product_id;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
