package pos.machine;

import java.util.*;

public class PosMachine {
    List<ItemInfo> ITEM_INFOS = ItemDataLoader.loadAllItemInfos();

    public String printReceipt(List<String> barcodes) {
        //get map of barcode - quantity
        SortedMap<String, Integer> barcodeQuantityTreeMap = new TreeMap<>();
        barcodes.forEach(barcode -> barcodeQuantityTreeMap.merge(barcode, 1, Integer::sum));

        //get list of item purchase info
        List<ItemPurchaseInfo> itemPurchaseInfos = new ArrayList<>();
        barcodeQuantityTreeMap.forEach((barcode, itemQuantity) -> {
            ItemInfo itemInfo = getItemInfoByBarcode(barcode);
            itemPurchaseInfos.add(new ItemPurchaseInfo(itemInfo, itemQuantity));
        });

        //generate receipt
        Receipt receipt = new Receipt(itemPurchaseInfos);
        return receipt.print();
    }

    ItemInfo getItemInfoByBarcode(String barcode) {
        for (ItemInfo item_info : this.ITEM_INFOS) {
            if (item_info.getBarcode().equals(barcode))
                return item_info;
        }
        throw new NoSuchElementException("Item with such barcode does not exist");
    }
}
