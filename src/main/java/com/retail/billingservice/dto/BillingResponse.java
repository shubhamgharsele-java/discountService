package com.retail.billingservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillingResponse {

    double netPayable;
}
