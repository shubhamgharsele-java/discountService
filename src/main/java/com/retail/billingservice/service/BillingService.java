package com.retail.billingservice.service;

import com.retail.billingservice.dto.BillingRequest;
import com.retail.billingservice.dto.BillingResponse;
import com.retail.billingservice.service.discount.AffiliateDiscountStrategy;
import com.retail.billingservice.service.discount.DiscountStrategy;
import com.retail.billingservice.service.discount.EmployeeDiscountStrategy;
import com.retail.billingservice.service.discount.GeneralDiscountStrategy;
import com.retail.billingservice.service.discount.LongTermCustomerDiscountStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillingService {
    private List<DiscountStrategy>  discounts = new ArrayList<>();

    public BillingService(){
        discounts.add(new AffiliateDiscountStrategy());
        discounts.add(new EmployeeDiscountStrategy());
        discounts.add(new LongTermCustomerDiscountStrategy());
        discounts.add(new GeneralDiscountStrategy());
    }

    public BillingResponse getPayableAmount(BillingRequest billingRequest) {
        double applicableDiscount = 0.0;
        for (DiscountStrategy ds : discounts) {
            if(!billingRequest.isHasGroceries()) {
                if (ds instanceof EmployeeDiscountStrategy && billingRequest.isEmployee()) {
                    applicableDiscount = Math.max(applicableDiscount, ds.applyDiscount(billingRequest.getBillAmount()));
                } else if (ds instanceof AffiliateDiscountStrategy && billingRequest.isAffiliate()) {
                    applicableDiscount = Math.max(applicableDiscount, ds.applyDiscount(billingRequest.getBillAmount()));

                } else if (ds instanceof LongTermCustomerDiscountStrategy && billingRequest.isLongTermCustomer()) {
                    applicableDiscount = Math.max(applicableDiscount, ds.applyDiscount(billingRequest.getBillAmount()));
                } else if (ds instanceof GeneralDiscountStrategy) {
                    applicableDiscount = Math.max(applicableDiscount, new GeneralDiscountStrategy().applyDiscount(billingRequest.getBillAmount()));
                }
            }
        }
        return BillingResponse.builder()
                .netPayable(billingRequest.getBillAmount()-applicableDiscount)
                .build();

    }
}
