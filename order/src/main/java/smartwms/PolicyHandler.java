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
    OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryOrdered_(@Payload DeliveryOrdered deliveryOrdered){

        if(deliveryOrdered.isMe()){

            java.util.Optional<Order> orderOptional 
                = orderRepository.findById(Long.parseLong(deliveryOrdered.getOrderId())); //주문ID를 Long Type으로 변경후 Find

            Order order = orderOptional.get();
            order.setDeliveryOrderStatus(deliveryOrdered.getDeliveryOrderStatus()); //배송상태를 업데이트

            orderRepository.save(order);
            System.out.println("##### listener  : " + deliveryOrdered.toJson());
        }
    }

}
