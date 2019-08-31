package com.amazinkart.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailsResponse {
  List<ProductDetails> productDetails;
}
