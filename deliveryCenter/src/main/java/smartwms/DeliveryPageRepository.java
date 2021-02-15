package smartwms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryPageRepository extends CrudRepository<DeliveryPage, Long> {

    List<> findByDeliveryOrderId(String deliveryOrderId);
    List<> findByDeliveryOrderId(String deliveryOrderId);
    List<> findByDeliveryOrderId(String deliveryOrderId);

}