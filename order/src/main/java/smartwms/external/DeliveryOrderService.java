
package smartwms.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="deliveryOrder", url="http://deliveryOrder:8080")
public interface DeliveryOrderService {
    // ${api.deliveryorder.url}
    // http://deliveryOrder:8080
    @RequestMapping(method= RequestMethod.POST, path="/deliveryOrders")
    public void deliveryCancel(@RequestBody DeliveryOrder deliveryOrder);

}