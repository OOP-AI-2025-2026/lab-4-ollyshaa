package ua.opnu.java.inheritance.bill;


public class DiscountBill2 {

    private GroceryBill bill;
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }


    public void add(Item item) {
        bill.add(item);

        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    public double getTotal() {
        double total = bill.getTotal();

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
        double fullPrice = bill.getTotal();
        if (fullPrice == 0.0) return 0.0;
        double percent = 100.0 - (getTotal() * 100.0 / fullPrice);
        // округлення до 13 знаків після коми
        return Math.round(percent * 1e13) / 1e13;
    }


    public GroceryBill getBill() {
        return bill;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}
