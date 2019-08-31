package com.amazinkart.client;

import java.util.List;

import com.amazinkart.bean.ProductDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ProductDetailClient {
  @GET(".")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  Call<List<ProductDetails>> getProductDetails();
}
