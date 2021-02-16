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
    DeliveryPackingRepository repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPickingOrdered_(@Payload PickingOrdered pickingOrdered){

        DeliveryPacking deliveryPacking = new DeliveryPacking();
        deliveryPacking.setDeliveryOrderId(pickingOrdered.getDeliveryOrderId());
        deliveryPacking.setPackingStatus  ("DeliveryPacking Started/Step3");
        deliveryPacking.setLogisticsInterfaceStatus("Logistincs Sended!");
        repository.save(deliveryPacking);

        if(pickingOrdered.isMe()){
            System.out.println("##### listener  : " + pickingOrdered.toJson());
        }
    }

}
