package com.retail.billingservice.service.discount;

public class EmployeeDiscountStrategy implements DiscountStrategy{


    private static final double DISCOUNT_PERCENTAGE = 0.3;

    @Override
    public double applyDiscount(double amount) {
        return DISCOUNT_PERCENTAGE*amount ;
    }
}
