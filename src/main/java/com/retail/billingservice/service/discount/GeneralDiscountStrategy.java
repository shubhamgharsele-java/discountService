package com.retail.billingservice.service.discount;

public class GeneralDiscountStrategy implements DiscountStrategy{


    private static final double DISCOUNT_PERCENTAGE = 0.05;

    @Override
    public double applyDiscount(double amount) {
        return Math.floor(amount/100)*DISCOUNT_PERCENTAGE*100 ;
    }
}
