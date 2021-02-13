package SMARTWMS;

public class LogisticsInterfaced extends AbstractEvent {

    private Long id;
    private String deliveryOrderId;
    private String packingStatus;
    private String logisticsInterfaceStatus;
    private Date logisticsInterfaceDate;

    public LogisticsInterfaced(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(String deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }
    public String getPackingStatus() {
        return packingStatus;
    }

    public void setPackingStatus(String packingStatus) {
        this.packingStatus = packingStatus;
    }
    public String getLogisticsInterfaceStatus() {
        return logisticsInterfaceStatus;
    }

    public void setLogisticsInterfaceStatus(String logisticsInterfaceStatus) {
        this.logisticsInterfaceStatus = logisticsInterfaceStatus;
    }
    public Date getLogisticsInterfaceDate() {
        return logisticsInterfaceDate;
    }

    public void setLogisticsInterfaceDate(Date logisticsInterfaceDate) {
        this.logisticsInterfaceDate = logisticsInterfaceDate;
    }
}