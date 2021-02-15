package smartwms;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="DeliveryPacking_table")
public class DeliveryPacking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String deliveryOrderId;
    private String packingStatus;
    private String logisticsInterfaceStatus;
    private String logisticsInterfaceDate;
    private String productId;

    @PostPersist
    public void onPostPersist(){
        LogisticsInterfaced logisticsInterfaced = new LogisticsInterfaced();
        BeanUtils.copyProperties(this, logisticsInterfaced);
        logisticsInterfaced.publishAfterCommit();


        PackingConfirmed packingConfirmed = new PackingConfirmed();
        BeanUtils.copyProperties(this, packingConfirmed);
        packingConfirmed.publishAfterCommit();


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




}
