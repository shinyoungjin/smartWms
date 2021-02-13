package smartwms;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DeliveryMgrPage_table")
public class DeliveryMgrPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String deliveryOrderId;
        private String deliveryOrderStatus;
        private String pickingStatus;
        private String packingStatus;


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
        public String getDeliveryOrderStatus() {
            return deliveryOrderStatus;
        }

        public void setDeliveryOrderStatus(String deliveryOrderStatus) {
            this.deliveryOrderStatus = deliveryOrderStatus;
        }
        public String getPickingStatus() {
            return pickingStatus;
        }

        public void setPickingStatus(String pickingStatus) {
            this.pickingStatus = pickingStatus;
        }
        public String getPackingStatus() {
            return packingStatus;
        }

        public void setPackingStatus(String packingStatus) {
            this.packingStatus = packingStatus;
        }

}
