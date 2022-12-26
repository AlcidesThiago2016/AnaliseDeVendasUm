package devsuperior.com.entities;

public class Sale {
    private Integer month;
    private Integer year;
    private String seller;
    private Integer items;
    private Double total;

    public Sale() {
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double averagePrice(){
        return total / items;
    }

    @Override
    public String toString() {
        return month + "/" + year + ", " + items  + ", " + total + "pm = " + String.format("%.2f",averagePrice());
    }
}
