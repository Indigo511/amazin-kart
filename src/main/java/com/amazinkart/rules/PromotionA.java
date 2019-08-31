package com.amazinkart.rules;

import java.util.Arrays;
import java.util.Objects;

import com.amazinkart.bean.Discount;
import com.amazinkart.bean.ProductDetails;

public class PromotionA implements PromotionRule {

  public Discount getMaxDiscount(final ProductDetails productDetails) {
    Discount discount = new Discount();
    if (productDetails.getRating() < 2) {
      discount.setDiscountTag("get 8% off");
      discount.setAmount(productDetails.getPrice() * .08);
    } else if (Objects.equals(productDetails.getOrigin(), "Africa")) {
      discount.setDiscountTag("get 7% off");
      discount.setAmount(productDetails.getPrice() * .07);
    } else if (productDetails.getRating() == 2) {
      discount.setDiscountTag("get 4% off");
      discount.setAmount(productDetails.getPrice() * .04);
    } else if (Arrays.asList("electronics", "furnishing").contains(productDetails.getCategory())
        && productDetails.getPrice() >= 500
        && (Objects.isNull(discount.getAmount()) || discount.getAmount() < 100)) {
      discount.setDiscountTag("get Rs 100 off");
      discount.setAmount(100D);
    } else if (discount.getAmount() == null && productDetails.getPrice() > 1000) {
      discount.setDiscountTag("get default 2% off");
      discount.setAmount(productDetails.getPrice() * .02);
    }
    return discount;
  }

}
