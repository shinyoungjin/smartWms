package SMARTWMS;

public class PickingOrderPrinted extends AbstractEvent {

    private Long id;
    private String deliveryOrderId;
    private String pickingOrderPrintYn;
    private String pickingStatus;

    public PickingOrderPrinted(){
        super();
    }

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
    public String getPickingOrderPrintYn() {
        return pickingOrderPrintYn;
    }

    public void setPickingOrderPrintYn(String pickingOrderPrintYn) {
        this.pickingOrderPrintYn = pickingOrderPrintYn;
    }
    public String getPickingStatus() {
        return pickingStatus;
    }

    public void setPickingStatus(String pickingStatus) {
        this.pickingStatus = pickingStatus;
    }
}