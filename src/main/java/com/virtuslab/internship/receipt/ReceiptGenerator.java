package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;

import java.util.*;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        Map<Product,Integer> map = new HashMap<>();
        for (int i=0;i<basket.getProducts().size();i++) {

            if (map.containsKey(basket.getProducts().get(i))) // J
                map.put(basket.getProducts().get(i), map.get(basket.getProducts().get(i)) + 1);
            else
                map.put(basket.getProducts().get(i), 1);
        }
        map.forEach((Product, quantity) ->{
            receiptEntries.add(new ReceiptEntry(Product,quantity));
        });



        return new Receipt(receiptEntries);
    }
}
