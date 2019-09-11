package innerclass;

public class SumCalculator {

    public int calculateSum(Bill bill, TaxCalculator taxCalculator) {
        int sum = 0;
        for (BillItem item: bill.getBillItems()) {
            int base = item.getAmount() * item.getPrice();
            sum += base * taxCalculator.calculateTax(base);
        }
        return sum;
    }
}
