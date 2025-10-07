package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item item) {
        super.add(item);

        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();

        if (regularCustomer) {
            total -= discountAmount;
        }

        return total;
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        double fullPrice = super.getTotal();
        if (fullPrice == 0.0) return 0.0;
        double percent = 100.0 - (getTotal() * 100.0 / fullPrice);
        // округлення до 13 знаків після коми
        return Math.round(percent * 1e13) / 1e13;
    }


}
