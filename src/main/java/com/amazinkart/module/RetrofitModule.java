package com.amazinkart.module;

import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import com.amazinkart.client.ConvertRateClient;
import com.amazinkart.client.ProductDetailClient;
import com.amazinkart.config.Configuration;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitModule extends AbstractModule {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  @Override
  protected void configure() {

  }

  @Provides
  ProductDetailClient provideProductDetailClient(final Configuration config) {
    OkHttpClient.Builder client = new OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS);
    return new Retrofit.Builder()
        .baseUrl(config.getExternalServicesConfig().getProductDetailsRetrievalAPI())
        .addConverterFactory(JacksonConverterFactory.create(MAPPER))
        .client(client.build())
        .build()
        .create(ProductDetailClient.class);
  }

  @Provides
  ConvertRateClient provideConvertRateClient(final Configuration config) {
    OkHttpClient.Builder client = new OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS);
    return new Retrofit.Builder()
        .baseUrl(config.getExternalServicesConfig().getConvertRatesAPI())
        .addConverterFactory(JacksonConverterFactory.create(MAPPER))
        .client(client.build())
        .build()
        .create(ConvertRateClient.class);
  }

}
