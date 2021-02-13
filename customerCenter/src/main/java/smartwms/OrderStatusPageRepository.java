package smartwms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderStatusPageRepository extends CrudRepository<OrderStatusPage, Long> {

    List<> findByOrderId(String orderId);
    List<> findByOrderId(String orderId);
    List<> findByOrderId(String orderId);

}