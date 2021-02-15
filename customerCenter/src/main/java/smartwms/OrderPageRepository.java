package smartwms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderPageRepository extends CrudRepository<OrderPage, Long> {

    List<> findByOrderId(String orderId);
    List<> findByOrderId(String orderId);
    List<> findByOrderId(String orderId);
    List<> findBy( );

}