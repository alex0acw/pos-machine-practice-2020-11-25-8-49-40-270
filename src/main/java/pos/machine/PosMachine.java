package pos.machine;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();

        SortedMap<String, Integer> barcodeCountTreeMap = new TreeMap<>();
        barcodes.forEach(barcode -> {
            Integer barcodeCount = barcodeCountTreeMap.get(barcode);
            if (barcodeCount != null)
                barcodeCountTreeMap.put(barcode, barcodeCount + 1);
            else
                barcodeCountTreeMap.put(barcode, 0);

        });


    }
}
