package input;

import enums.Category;

import java.util.Comparator;

public class Gift {
    private String productName;
    private Double price;
    private Category category;
    private int quantity;

    public Gift() {
    }

    public Gift(final String productName, final Double price,
                final Category category, final int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    private static Comparator<Gift> ascPrice = (o1, o2) -> {
        Double gift1 = o1.getPrice();
        Double gift2 = o2.getPrice();
        return Double.compare(gift1, gift2);
    };
    /**
     * @return
     */
    public String getProductName() {
        return productName;
    }
    /**
     * @param productName
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }
    /**
     * @return
     */
    public Double getPrice() {
        return price;
    }
    /**
     * @param price
     */
    public void setPrice(final Double price) {
        this.price = price;
    }
    /**
     * @return
     */
    public Category getCategory() {
        return category;
    }
    /**
     * @param category
     */
    public void setCategory(final Category category) {
        this.category = category;
    }
    /**
     * @return
     */
    public static Comparator<Gift> getAscPrice() {
        return ascPrice;
    }
    /**
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

}

