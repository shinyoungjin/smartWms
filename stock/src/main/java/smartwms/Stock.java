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
    private Integer stockIncreaseQty;
    private String productWhsDate;
    private String createDate;
    private String updateDate;

    @PostPersist
    public void onPostPersist(){
        StockAssigned stockAssigned = new StockAssigned();
        BeanUtils.copyProperties(this, stockAssigned);
        stockAssigned.publishAfterCommit();


        StockDecreased stockDecreased = new StockDecreased();
        BeanUtils.copyProperties(this, stockDecreased);
        stockDecreased.publishAfterCommit();


        StockIncreased stockIncreased = new StockIncreased();
        BeanUtils.copyProperties(this, stockIncreased);
        stockIncreased.publishAfterCommit();

    }

    @PrePersist
    public void onPrePersist(){
        StockRegistered stockRegistered = new StockRegistered();
        BeanUtils.copyProperties(this, stockRegistered);
        stockRegistered.publishAfterCommit();

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
    public Integer getStockIncreaseQty() {
        return stockIncreaseQty;
    }

    public void setStockIncreaseQty(Integer stockIncreaseQty) {
        this.stockIncreaseQty = stockIncreaseQty;
    }
    public String getProductWhsDate() {
        return productWhsDate;
    }

    public void setProductWhsDate(String productWhsDate) {
        this.productWhsDate = productWhsDate;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
