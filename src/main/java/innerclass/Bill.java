package innerclass;

import java.util.List;

public class Bill {

    private List<BillItem> billItems;

    public Bill(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }
}
