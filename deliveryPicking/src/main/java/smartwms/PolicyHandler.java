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
    DeliveryPickingRepository repository;    

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryOrdered_(@Payload DeliveryOrdered deliveryOrdered){

        if(deliveryOrdered.isMe()){

            DeliveryPicking deliveryPicking = new DeliveryPicking();
            deliveryPicking.setDeliveryOrderId (deliveryOrdered.getDeliveryOrderId());
            deliveryPicking.setDeliveryOrderQty(deliveryOrdered.getDeliveryOrderQty());
            deliveryPicking.setPickingStatus   ("DeliveryPicking Started/Step2");
            repository.save(deliveryPicking);

            System.out.println("##### listener  : " + deliveryOrdered.toJson());
        }
    }

}
