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

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryOrdered_(@Payload DeliveryOrdered deliveryOrdered){

        if(deliveryOrdered.isMe()){
            System.out.println("##### listener  : " + deliveryOrdered.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPackingConfirmed_(@Payload PackingConfirmed packingConfirmed){

        if(packingConfirmed.isMe()){
            System.out.println("##### listener  : " + packingConfirmed.toJson());
        }
    }

}
