package smartwms;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="DeliveryPicking_table")
public class DeliveryPicking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String deliveryOrderId;
    private String pickingOrderPrintYn;
    private String orderConfirmPrintYn;
    private String invoicePrintYn;
    private String pickingStatus;
    private String invoiceNo;
    private String productId;
    private Integer deliveryOrderQty;

    @PostPersist
    public void onPostPersist(){
        OrderConfirmPrinted orderConfirmPrinted = new OrderConfirmPrinted();
        BeanUtils.copyProperties(this, orderConfirmPrinted);
        orderConfirmPrinted.publishAfterCommit();


        InvoicePrinted invoicePrinted = new InvoicePrinted();
        BeanUtils.copyProperties(this, invoicePrinted);
        invoicePrinted.publishAfterCommit();


        PickingOrdered pickingOrdered = new PickingOrdered();
        BeanUtils.copyProperties(this, pickingOrdered);
        pickingOrdered.publishAfterCommit();


        PickingOrderPrinted pickingOrderPrinted = new PickingOrderPrinted();
        BeanUtils.copyProperties(this, pickingOrderPrinted);
        pickingOrderPrinted.publishAfterCommit();


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
    public String getPickingStatus() {
        return pickingStatus;
    }

    public void setPickingStatus(String pickingStatus) {
        this.pickingStatus = pickingStatus;
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

    public Integer getDeliveryOrderQty() {
        return deliveryOrderQty;
    }
    public void setDeliveryOrderQty(Integer deliveryOrderQty) {
        this.deliveryOrderQty = deliveryOrderQty;
    }

}
