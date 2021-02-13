package smartwms;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Stock_table")
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String productId;
    private Integer stockQty;
    private Integer stockAssignQty;
    private Integer stockWhsQty;
    private Date stockWhsDate;

    @PostPersist
    public void onPostPersist(){
        ProductWarehoused productWarehoused = new ProductWarehoused();
        BeanUtils.copyProperties(this, productWarehoused);
        productWarehoused.publishAfterCommit();


        StockAssigned stockAssigned = new StockAssigned();
        BeanUtils.copyProperties(this, stockAssigned);
        stockAssigned.publishAfterCommit();


        StockSubstracted stockSubstracted = new StockSubstracted();
        BeanUtils.copyProperties(this, stockSubstracted);
        stockSubstracted.publishAfterCommit();


        StockIncreased stockIncreased = new StockIncreased();
        BeanUtils.copyProperties(this, stockIncreased);
        stockIncreased.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }
    public Integer getStockAssignQty() {
        return stockAssignQty;
    }

    public void setStockAssignQty(Integer stockAssignQty) {
        this.stockAssignQty = stockAssignQty;
    }
    public Integer getStockWhsQty() {
        return stockWhsQty;
    }

    public void setStockWhsQty(Integer stockWhsQty) {
        this.stockWhsQty = stockWhsQty;
    }
    public Date getStockWhsDate() {
        return stockWhsDate;
    }

    public void setStockWhsDate(Date stockWhsDate) {
        this.stockWhsDate = stockWhsDate;
    }




}
