package com.amazinkart.bean;

import java.text.DecimalFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Discount {
  private Double amount;
  private String discountTag;

  public void setAmount(final Double amount) {
    DecimalFormat df2 = new DecimalFormat("#.##");
    this.amount =Double.valueOf(df2.format(amount));
  }
}
