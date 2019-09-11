package innerclass;

import java.util.Arrays;
import java.util.List;

public class SumCalculator {

    public int calculateSum(Bill bill, TaxCalculator taxCalculator) {
        int sum = 0;
        for (BillItem item: bill.getBillItems()) {
            int base = item.getAmount() * item.getPrice();
            sum += base + taxCalculator.calculateTax(base);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<BillItem> items = Arrays.asList(new BillItem(10, 200),
                new BillItem(20, 300));
        Bill bill = new Bill(items);

        int sum = new SumCalculator().calculateSum(bill, new TaxCalculator() {
            @Override
            public int calculateTax(int base) {
                return (int)(0.2 * base);
            }
        });
        System.out.println(sum);
    }
}
