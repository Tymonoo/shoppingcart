package com.virtuslab.internship.discount;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptEntry;
import com.virtuslab.internship.receipt.ReceiptGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FifteenPercentDiscount {

    public final String NAME = "FifteenPercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            System.out.println(receipt.discounts().size());
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }


    private boolean shouldApply(Receipt receipt) {
        int grainProductsCount = 0;
        List<ReceiptEntry> productList = receipt.entries();
        for (ReceiptEntry receiptEntry : productList) {
            if (receiptEntry.product().type() == Product.Type.GRAINS) {
                grainProductsCount+= receiptEntry.quantity();
            }
        }


        return grainProductsCount >= 3;
    }



}
