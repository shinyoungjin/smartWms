package smartwms;

import smartwms.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    DeliveryOrderRepository repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrdered_(@Payload Ordered ordered){

        if(ordered.isMe()){

            System.out.println("##### listener  : " + ordered.toJson());

            // 처음 주문이 들어 올 경우 저장
            // OrderStatus : Ordered
            // DeliveryOrderStatus : null
            if( ordered.getOrderStatus() != null && 
                ordered.getOrderStatus().equals("Ordered") &&
                ordered.getDeliveryOrderStatus() == null )
            {
                DeliveryOrder deliveryOrder = new DeliveryOrder();
                deliveryOrder.setDeliveryOrderId(ordered.getOrderId()); //출고지시 번호를 주문번호로 매핑
                deliveryOrder.setOrderId  (ordered.getOrderId()  );
                deliveryOrder.setProductId(ordered.getProductId());
                deliveryOrder.setOrderQty (ordered.getOrderQty() );

                deliveryOrder.setDeliveryOrderQty   (ordered.getOrderQty());
                deliveryOrder.setDeliveryOrderStatus("DeliveryOrdered"); //출고지시 상태로 변경

                repository.save(deliveryOrder); //저장
            }
            
        }
    }

}
