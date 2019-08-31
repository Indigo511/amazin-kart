package com.amazinkart.bean;

import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetails {
  private String category;
  private String currency;
  private String origin;
  private String product;
  private Integer inventory;
  private Double price;
  private Double rating;
  private String arrival;
  private Discount discount;

  public void setPrice(final Double price) {
    DecimalFormat df2 = new DecimalFormat("#.##");
    this.price = Double.valueOf(df2.format(price));
  }

}