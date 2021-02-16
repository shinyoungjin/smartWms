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
public class OrderPageViewHandler {


    @Autowired
    private OrderPageRepository repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 생성
                OrderPage oPage = new OrderPage();
                // view 객체에 이벤트의 Value 를 set 함
                oPage.setOrderId    (ordered.getOrderId());
                oPage.setOrderStatus(ordered.getOrderStatus());
                oPage.setOrderQty   (ordered.getOrderQty());
                oPage.setProductId  (ordered.getProductId());
                // view 레파지 토리에 save
                repository.save(oPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryOrdered_then_UPDATE_1(@Payload DeliveryOrdered deliveryOrdered) {
        try {
            if (deliveryOrdered.isMe()) {
                // view 객체 조회
                List<OrderPage> List = repository.findByOrderId(deliveryOrdered.getOrderId());
                for(OrderPage oPage : List){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    oPage.setOrderId        (deliveryOrdered.getOrderId());
                    oPage.setDeliveryOrderId(deliveryOrdered.getDeliveryOrderId());
                    oPage.setDeliveryStatus (deliveryOrdered.getDeliveryOrderStatus());

                    repository.save(oPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_2(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 조회
                List<OrderPage> List = repository.findByOrderId(orderCanceled.getOrderId());
                for(OrderPage oPage : List){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    oPage.setOrderId    (orderCanceled.getOrderId());
                    oPage.setOrderStatus(orderCanceled.getOrderStatus());
                    repository.save(oPage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}