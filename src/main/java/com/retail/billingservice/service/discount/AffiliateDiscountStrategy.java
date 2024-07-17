package com.retail.billingservice.service.discount;

public class AffiliateDiscountStrategy implements DiscountStrategy {


    private static final double DISCOUNT_PERCENTAGE = 0.1;

    @Override
    public double applyDiscount(double amount) {
        return DISCOUNT_PERCENTAGE*amount ;
    }
}
