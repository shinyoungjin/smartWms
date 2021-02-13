package smartwms;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Product_table")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String productId;
    private String productName;
    private String productStatus;
    private Date createDate;
    private Date updateDate;

    @PostPersist
    public void onPostPersist(){
        ProductInfoRegisterd productInfoRegisterd = new ProductInfoRegisterd();
        BeanUtils.copyProperties(this, productInfoRegisterd);
        productInfoRegisterd.publishAfterCommit();


        ProductInfoChanged productInfoChanged = new ProductInfoChanged();
        BeanUtils.copyProperties(this, productInfoChanged);
        productInfoChanged.publishAfterCommit();


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
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }




}
