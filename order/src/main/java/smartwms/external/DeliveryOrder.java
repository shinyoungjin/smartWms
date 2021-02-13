package smartwms.external;

public class DeliveryOrder {

    private Long id;
    private String orderId;
    private String deliveryOrderId;
    private String deliveryOrderStatus;
    private String productId;
    private Integer orderQty;
    private Integer deliveryOrderQty;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }
    public void setDeliveryOrderId(String deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }
    public String getDeliveryOrderStatus() {
        return deliveryOrderStatus;
    }
    public void setDeliveryOrderStatus(String deliveryOrderStatus) {
        this.deliveryOrderStatus = deliveryOrderStatus;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public Integer getOrderQty() {
        return orderQty;
    }
    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
    public Integer getDeliveryOrderQty() {
        return deliveryOrderQty;
    }
    public void setDeliveryOrderQty(Integer deliveryOrderQty) {
        this.deliveryOrderQty = deliveryOrderQty;
    }

}
