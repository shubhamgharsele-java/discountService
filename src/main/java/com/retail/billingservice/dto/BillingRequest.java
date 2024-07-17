package com.retail.billingservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingRequest {

    double billAmount;
    boolean isEmployee;
    boolean isAffiliate;
    boolean isLongTermCustomer;
    boolean hasGroceries;
}
