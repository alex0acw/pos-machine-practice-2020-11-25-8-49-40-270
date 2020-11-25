package pos.machine;

public class ItemPurchaseInfo extends ItemInfo {
    private final Integer quantity;

    public ItemPurchaseInfo(ItemInfo itemInfo, Integer quantity) {
        super(itemInfo.getBarcode(), itemInfo.getName(), itemInfo.getPrice());
        this.quantity = quantity;
    }

    public Integer getSubtotal() {
        return this.getPrice() * this.quantity;
    }

    public String printReceipt() {

        return String.format("Name: %s, Quantity: %d, Unit price: %d (yuan), Subtotal: %d (yuan)",
                this.getName(), this.quantity, this.getPrice(), this.getSubtotal());
    }
}
