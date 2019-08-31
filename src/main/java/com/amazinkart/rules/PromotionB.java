package com.amazinkart.rules;

import java.util.Objects;

import com.amazinkart.bean.Discount;
import com.amazinkart.bean.ProductDetails;

public class PromotionB implements PromotionRule {
  @Override
  public Discount getMaxDiscount(final ProductDetails productDetails) {
    Discount discount = new Discount();
    if (productDetails.getInventory() > 20) {
      discount.setDiscountTag("get 12% off");
      discount.setAmount(productDetails.getPrice() * .12);
    }else if (Objects.equals(productDetails.getArrival(), "NEW")) {
      discount.setDiscountTag("get 7% off");
      discount.setAmount(productDetails.getPrice() * .07);
    }else if (discount.getAmount() == null && productDetails.getPrice() > 1000) {
      discount.setDiscountTag("get default 2% off");
      discount.setAmount(productDetails.getPrice() * .02);
    }
    return discount;
  }
}
