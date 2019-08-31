package com.amazinkart.client;

import com.amazinkart.bean.RateDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ConvertRateClient {

  @GET(".")
  @Headers({"Content-Type: application/json", "Accept: application/json"})
  Call<RateDetails> getConvertedRates();
}
