package pos.machine;

import java.util.List;

public class Receipt {
    static final String NEW_LINE = "\n";
    final String content;

    public Receipt(List<ItemPurchaseInfo> itemPurchaseInfoList) {
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("***<store earning no money>Receipt***").append(NEW_LINE);
        for (ItemPurchaseInfo itemPurchaseInfo : itemPurchaseInfoList) {
            contentBuilder.append(itemPurchaseInfo.printReceipt()).append(NEW_LINE);
        }
        contentBuilder
                .append("----------------------")
                .append(NEW_LINE)
                .append(String.format("Total: %d (yuan)", calcTotalPrice(itemPurchaseInfoList)))
                .append(NEW_LINE)
                .append("**********************");
        this.content = contentBuilder.toString();
    }

    public String print() {
        return this.content;
    }

    private Integer calcTotalPrice(List<ItemPurchaseInfo> itemPurchaseInfoList) {
        return itemPurchaseInfoList.stream()
                .map(ItemPurchaseInfo::getSubtotal)
                .mapToInt(Integer::intValue).sum();
    }

}
