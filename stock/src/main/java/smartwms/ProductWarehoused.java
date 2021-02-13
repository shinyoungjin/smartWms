package SMARTWMS;

public class ProductWarehoused extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer stockQty;
    private Integer stockAssignQty;
    private Integer stockWhsQty;
    private Date stockWhsData;

    public ProductWarehoused(){
        super();
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
    public Date getStockWhsData() {
        return stockWhsData;
    }

    public void setStockWhsData(Date stockWhsData) {
        this.stockWhsData = stockWhsData;
    }
}