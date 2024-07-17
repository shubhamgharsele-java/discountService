package com.retail.billingservice.service.discount;

public class LongTermCustomerDiscountStrategy implements DiscountStrategy{


    private static final double DISCOUNT_PERCENTAGE = 0.005;

    @Override
    public double applyDiscount(double amount) {
        return DISCOUNT_PERCENTAGE*amount ;
    }
}
