package smartwms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryMgrPageRepository extends CrudRepository<DeliveryMgrPage, Long> {

    List<> findByDeliveryOrderId(String deliveryOrderId);
    List<> findByDeliveryOrderId(String deliveryOrderId);

}