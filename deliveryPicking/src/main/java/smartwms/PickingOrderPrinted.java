package smartwms;

public class PickingOrderPrinted extends AbstractEvent {

    private Long id;
    private String deliveryOrderId;
    private String pickingOrderPrintYn;
    private String pickingStatus;
    private String orderConfirmPrintYn;
    private String invoicePrintYn;
    private String invoiceNo;
    private String productId;

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
    public String getOrderConfirmPrintYn() {
        return orderConfirmPrintYn;
    }

    public void setOrderConfirmPrintYn(String orderConfirmPrintYn) {
        this.orderConfirmPrintYn = orderConfirmPrintYn;
    }
    public String getInvoicePrintYn() {
        return invoicePrintYn;
    }

    public void setInvoicePrintYn(String invoicePrintYn) {
        this.invoicePrintYn = invoicePrintYn;
    }
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}