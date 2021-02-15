package smartwms;

public class Ordered extends AbstractEvent {

    private Long id;
    private String orderId;
    private String orderStatus;
    private Integer orderQty;
    private String productId;
    private String productName;
    private String deliveryOrderStatus;

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
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getDeliveryOrderStatus() {
        return deliveryOrderStatus;
    }

    public void setDeliveryOrderStatus(String deliveryOrderStatus) {
        this.deliveryOrderStatus = deliveryOrderStatus;
    }
}