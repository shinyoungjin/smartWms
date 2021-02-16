package smartwms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderPageRepository extends CrudRepository<OrderPage, Long> {

    List<OrderPage> findByOrderId(String orderId);
    // List<> findBy( );

}