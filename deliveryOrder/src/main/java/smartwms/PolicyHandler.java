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
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setOrderId  (ordered.getOrderId());
            deliveryOrder.setProductId(ordered.getProductId());
            deliveryOrder.setOrderQty (ordered.getOrderQty());

            deliveryOrder.setDeliveryOrderQty   (ordered.getOrderQty());
            deliveryOrder.setDeliveryOrderStatus("Delivery Order Started/Step1");
            
            System.out.println("##### listener  : " + ordered.toJson());
        }
    }

}
