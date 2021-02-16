package smartwms;

import smartwms.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PolicyHandler{

    String timestamp;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){
        SimpleDateFormat defaultSimpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        this.timestamp = defaultSimpleDateFormat.format(new Date());
    }

    @Autowired
    StockRepository repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverProductRegistered_(@Payload ProductRegistered productRegistered){

        if(productRegistered.isMe()){

            SimpleDateFormat defaultSimpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
            this.timestamp = defaultSimpleDateFormat.format(new Date());
            
            Stock stock = new Stock();
            stock.setId        (Long.parseLong(productRegistered.getProductId()));
            stock.setProductId (productRegistered.getProductId());
            stock.setStockQty  (1000); //임의로 1000으로 세팅
            stock.setCreateDate(this.timestamp);
            stock.setUpdateDate(this.timestamp);
            repository.save(stock); //저장

            System.out.println("##### listener  : " + productRegistered.toJson());
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryOrdered_(@Payload DeliveryOrdered deliveryOrdered){

        if(deliveryOrdered.isMe()){

            SimpleDateFormat defaultSimpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
            this.timestamp = defaultSimpleDateFormat.format(new Date());
            
            Stock stock = new Stock();
            // stock.setId(Long.parseLong(deliveryOrdered.getProductId()));
            stock.setProductId     (deliveryOrdered.getProductId());
            stock.setStockAssignQty(deliveryOrdered.getDeliveryOrderQty());
            stock.setUpdateDate    (this.timestamp);
            repository.save(stock); //저장
            
            System.out.println("##### listener  : " + deliveryOrdered.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPackingConfirmed_(@Payload PackingConfirmed packingConfirmed){

        if(packingConfirmed.isMe()){

            SimpleDateFormat defaultSimpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
            this.timestamp = defaultSimpleDateFormat.format(new Date());
            
            Stock stock = new Stock();
            // stock.setId(Long.parseLong(deliveryOrdered.getProductId()));
            stock.setProductId (packingConfirmed.getProductId());
            stock.setStockQty  (packingConfirmed.getDeliveryOrderQty()); // 원래 재고건수에서 출고지시건수를 빼야하는데, 일단 로직 제외
            stock.setUpdateDate(this.timestamp);
            repository.save(stock); //저장
            
            System.out.println("##### listener  : " + packingConfirmed.toJson());
        }
    }


}
