package com.amazinkart;

import com.amazinkart.config.Configuration;
import com.amazinkart.module.ApplicationModule;
import com.amazinkart.module.RetrofitModule;
import com.amazinkart.service.ProductService;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<Configuration> {
  private GuiceBundle<Configuration> guiceBundle;

  public static void main(String[] args) throws Exception {
    new MainApp().run(args);
  }

  @Override
  public void run(final Configuration configuration, final Environment environment) throws Exception {
    String promotionSet="promotionSetA";
    ProductService productService=guiceBundle.getInjector().getInstance(ProductService.class);
   productService.getProductDetails(promotionSet);
  }

  private void addBundles(final Bootstrap<Configuration> bootstrap) {
    guiceBundle = createGuiceBundle(bootstrap);
    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void initialize(final Bootstrap<Configuration> bootstrap) {
    addBundles(bootstrap);
  }

  private GuiceBundle<Configuration> createGuiceBundle(final Bootstrap<Configuration> bootstrap) {
    return GuiceBundle.<Configuration>newBuilder()
        .setConfigClass(Configuration.class)
        .addModule(new RetrofitModule())
        .addModule(new ApplicationModule())
        .build(Stage.DEVELOPMENT);
  }
}
