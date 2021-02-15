package smartwms;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="DeliveryOrder_table")
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String orderId;
    private String deliveryOrderId;
    private String deliveryOrderStatus;
    private String productId;
    private Integer orderQty;
    private Integer deliveryOrderQty;
    private String productName;

    @PostPersist
    public void onPostPersist(){
        DeliveryOrdered deliveryOrdered = new DeliveryOrdered();
        BeanUtils.copyProperties(this, deliveryOrdered);
        deliveryOrdered.publishAfterCommit();


        DeliveryOrderCanceled deliveryOrderCanceled = new DeliveryOrderCanceled();
        BeanUtils.copyProperties(this, deliveryOrderCanceled);
        deliveryOrderCanceled.publishAfterCommit();


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
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }




}
