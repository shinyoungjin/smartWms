package smartwms;

public class PackingConfirmed extends AbstractEvent {

    private Long id;
    private String deliveryOrderId;
    private String packingStatus;
    private String logisticsInterfaceStatus;
    private String logisticsInterfaceDate;
    private String productId;
    private Integer deliveryOrderQty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(String deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }
    public String getPackingStatus() {
        return packingStatus;
    }

    public void setPackingStatus(String packingStatus) {
        this.packingStatus = packingStatus;
    }
    public String getLogisticsInterfaceStatus() {
        return logisticsInterfaceStatus;
    }

    public void setLogisticsInterfaceStatus(String logisticsInterfaceStatus) {
        this.logisticsInterfaceStatus = logisticsInterfaceStatus;
    }
    public String getLogisticsInterfaceDate() {
        return logisticsInterfaceDate;
    }

    public void setLogisticsInterfaceDate(String logisticsInterfaceDate) {
        this.logisticsInterfaceDate = logisticsInterfaceDate;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getDeliveryOrderQty() {
        return deliveryOrderQty;
    }
    public void setDeliveryOrderQty(Integer deliveryOrderQty) {
        this.deliveryOrderQty = deliveryOrderQty;
    }
    
}