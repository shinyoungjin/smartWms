package SMARTWMS;

public class InvoicePrinted extends AbstractEvent {

    private Long id;
    private String deliveryOrderId;
    private String invoicePrintYn;
    private String pickingStatus;
    private String pickingPrintYn;
    private String orderConfirmPrintYn;
    private String invoiceNo;
    private String productId;

    public InvoicePrinted(){
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
    public String getPickingPrintYn() {
        return pickingPrintYn;
    }

    public void setPickingPrintYn(String pickingPrintYn) {
        this.pickingPrintYn = pickingPrintYn;
    }
    public String getOrderConfirmPrintYn() {
        return orderConfirmPrintYn;
    }

    public void setOrderConfirmPrintYn(String orderConfirmPrintYn) {
        this.orderConfirmPrintYn = orderConfirmPrintYn;
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