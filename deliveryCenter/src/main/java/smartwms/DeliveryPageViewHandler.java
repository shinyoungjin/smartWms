package smartwms;

import smartwms.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryPageViewHandler {


    @Autowired
    private DeliveryPageRepository deliveryPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryOrdered_then_CREATE_1 (@Payload DeliveryOrdered deliveryOrdered) {
        try {
            if (deliveryOrdered.isMe()) {
                // view 객체 생성
                  = new ();
                // view 객체에 이벤트의 Value 를 set 함
                .setDeliveryOrderId(.getDeliveryOrderId());
                .setDeliveryOrderStatus(.getDeliveryOrderStatus());
                .setProductId(.getProductId());
                // view 레파지 토리에 save
                Repository.save();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPickingOrdered_then_UPDATE_1(@Payload PickingOrdered pickingOrdered) {
        try {
            if (pickingOrdered.isMe()) {
                // view 객체 조회
                List<> List = Repository.findByDeliveryOrderId(.getDeliveryOrderId());
                for(  : List){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPackingConfirmed_then_UPDATE_2(@Payload PackingConfirmed packingConfirmed) {
        try {
            if (packingConfirmed.isMe()) {
                // view 객체 조회
                List<> List = Repository.findByDeliveryOrderId(.getDeliveryOrderId());
                for(  : List){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryOrderCanceled_then_UPDATE_3(@Payload DeliveryOrderCanceled deliveryOrderCanceled) {
        try {
            if (deliveryOrderCanceled.isMe()) {
                // view 객체 조회
                List<> List = Repository.findByDeliveryOrderId(.getDeliveryOrderId());
                for(  : List){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}