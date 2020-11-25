package pos.machine;

public class ItemPurchaseInfo {
    private final ItemInfo itemInfo;
    private final Integer quantity;

    public ItemPurchaseInfo(ItemInfo itemInfo, Integer quantity) {
        this.itemInfo = itemInfo;
        this.quantity = quantity;
    }

    public Integer getSubtotal() {
        return this.itemInfo.getPrice() * this.quantity;
    }

    public String printReceipt() {

        return String.format("Name: %s, Quantity: %d, Unit price: %d (yuan), Subtotal: %d (yuan)",
                this.itemInfo.getName(), this.quantity, this.itemInfo.getPrice(), this.getSubtotal());
    }
}
