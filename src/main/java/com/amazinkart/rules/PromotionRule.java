package com.amazinkart.rules;

import com.amazinkart.bean.Discount;
import com.amazinkart.bean.ProductDetails;

public interface PromotionRule {

  default void addDiscountNodeInProductDetails(final ProductDetails productDetails) {
    Discount discount = getMaxDiscount(productDetails);
    if (discount.getAmount() != null) {
      productDetails.setDiscount(discount);
      productDetails.setPrice(productDetails.getPrice() - discount.getAmount());
    }
  }

  Discount getMaxDiscount(ProductDetails productDetails);
}
