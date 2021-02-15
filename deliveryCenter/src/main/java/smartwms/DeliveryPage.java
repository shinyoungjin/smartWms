package smartwms;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DeliveryPage_table")
public class DeliveryPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String deliveryOrderId;
        private String deliveryOrderStatus;
        private String pickingStatus;
        private String packingStatus;
        private String productId;


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
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

}
