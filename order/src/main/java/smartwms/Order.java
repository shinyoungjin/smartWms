package smartwms;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String orderId;
    private String productId;
    private String productName;
    private String orderStatus;
    private Integer orderQty;
    private String deliveryOrderStatus;

    @PostPersist
    public void onPostPersist(){
        // 초기 주문 orderStatus : Ordered
        Ordered ordered = new Ordered();
        BeanUtils.copyProperties(this, ordered);
        ordered.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove(){

        // 주문 취소 orderStatus : OrderCanceled
        OrderCanceled orderCanceled = new OrderCanceled();
        BeanUtils.copyProperties(this, orderCanceled);
        orderCanceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        smartwms.external.DeliveryOrder deliveryOrder = new smartwms.external.DeliveryOrder();
        deliveryOrder.setOrderId            (this.getOrderId());
        deliveryOrder.setDeliveryOrderStatus("DeliveryOrderCanceled");
        
        // mappings goes here
        OrderApplication.applicationContext.getBean(smartwms.external.DeliveryOrderService.class)
            .deliveryCancel(deliveryOrder);

    }

    @PrePersist
    public void onPrePersist(){ 
        try {
            Thread.currentThread().sleep((long) (800 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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
    public String getDeliveryOrderStatus() {
        return deliveryOrderStatus;
    }

    public void setDeliveryOrderStatus(String deliveryOrderStatus) {
        this.deliveryOrderStatus = deliveryOrderStatus;
    }




}
