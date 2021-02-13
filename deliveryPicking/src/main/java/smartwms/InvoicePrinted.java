
package smartwms;

public class InvoicePrinted extends AbstractEvent {

    private Long id;
    private String deliveryOrderId;
    private String invoicePrintYn;
    private String pickingStatus;
    private String invoidNo;

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
    public String getInvoicePrintYn() {
        return invoicePrintYn;
    }

    public void setInvoicePrintYn(String invoicePrintYn) {
        this.invoicePrintYn = invoicePrintYn;
    }
    public String getPickingStatus() {
        return pickingStatus;
    }

    public void setPickingStatus(String pickingStatus) {
        this.pickingStatus = pickingStatus;
    }
    public String getInvoidNo() {
        return invoidNo;
    }

    public void setInvoidNo(String invoidNo) {
        this.invoidNo = invoidNo;
    }
}
