package output;

import enums.Category;
import java.util.Comparator;

public class OutGift {
    private String productName;
    private Double price;
    private Category category;

    public OutGift() {
    }

    public OutGift(final String productName, final Double price,
                   final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    private static Comparator<input.Gift> ascPrice = (o1, o2) -> {
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
    public static Comparator<input.Gift> getAscPrice() {
        return ascPrice;
    }
}
