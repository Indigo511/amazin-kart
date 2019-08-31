package com.amazinkart.module;

import com.amazinkart.rules.PromotionA;
import com.amazinkart.rules.PromotionB;
import com.amazinkart.rules.PromotionRule;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class ApplicationModule extends AbstractModule{
  @Override
  protected void configure() {
    bindPromotionalRules();
  }

  private void bindPromotionalRules() {
    MapBinder<String, PromotionRule> promotionRuleMapBinder =
        MapBinder.newMapBinder(binder(), String.class, PromotionRule.class);
    promotionRuleMapBinder.addBinding("promotionSetA").to(PromotionA.class);
    promotionRuleMapBinder.addBinding("promotionSetB").to(PromotionB.class);
  }
}
