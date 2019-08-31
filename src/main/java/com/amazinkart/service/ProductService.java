package com.amazinkart.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.amazinkart.bean.ProductDetails;
import com.amazinkart.bean.RateDetails;
import com.amazinkart.client.ConvertRateClient;
import com.amazinkart.client.ProductDetailClient;
import com.amazinkart.rules.PromotionRule;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductService {
  private final ProductDetailClient productDetailClient;
  private final ConvertRateClient convertRateClient;
  private final Map<String, PromotionRule> promotionRuleMap;

  @Inject
  public ProductService(final ProductDetailClient productDetailClient,
                        final ConvertRateClient convertRateClient,
                        final Map<String, PromotionRule> promotionRuleMap) {
    this.productDetailClient = productDetailClient;
    this.convertRateClient = convertRateClient;
    this.promotionRuleMap = promotionRuleMap;
  }

  //todo: output path,input promotion set
  public void getProductDetails(String promotionSet) throws IOException {
    List<ProductDetails> productDetails = productDetailClient.getProductDetails().execute().body();
    RateDetails rateDetails = convertRateClient.getConvertedRates().execute().body();
    productDetails = productDetails.stream().map(product ->
    {
      Double price = null;
      if (rateDetails != null) {
        price = (rateDetails.getRates().get("INR") * product.getPrice()) / rateDetails.getRates().get(product.getCurrency());
      }
      product.setCurrency("INR");
      product.setPrice(price);
      promotionRuleMap.get(promotionSet).addDiscountNodeInProductDetails(product);
      return product;
    }).collect(Collectors.toList());

    try (FileWriter file = new FileWriter("src/main/java/com/amazinkart/target/output.json")) {
      JsonNode json = new ObjectMapper().convertValue(productDetails, JsonNode.class);
      file.write(json.toString());
    }
  }
}
