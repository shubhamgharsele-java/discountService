package com.retail.billingservice.service;

import com.retail.billingservice.dto.BillingRequest;
import com.retail.billingservice.dto.BillingResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BillingServiceTest {

    @Autowired
    BillingService service ;


    void init(){

    }

    @Test
    public void getPayableAmountForAffilate(){
        BillingRequest request = BillingRequest.builder()
                .billAmount(500)
                .isAffiliate(true)
                .hasGroceries(false)
                .isLongTermCustomer(false)
                .isEmployee(false)
                .build();

        BillingResponse response = BillingResponse.builder()
                .netPayable(450)
                .build();
        assertEquals(response,service.getPayableAmount(request));

    }

    @Test
    public void getPayableAmountforEmployee(){
        BillingRequest request = BillingRequest.builder()
                .billAmount(500)
                .isAffiliate(false)
                .hasGroceries(false)
                .isLongTermCustomer(false)
                .isEmployee(true)
                .build();

        BillingResponse response = BillingResponse.builder()
                .netPayable(350)
                .build();
        assertEquals(response,service.getPayableAmount(request));

    }
    @Test
    public void getPayableAmountforLongTermCustomer(){
        BillingRequest request = BillingRequest.builder()
                .billAmount(500)
                .isAffiliate(false)
                .hasGroceries(false)
                .isLongTermCustomer(true)
                .isEmployee(false)
                .build();

        BillingResponse response = BillingResponse.builder()
                .netPayable(475)
                .build();
        assertEquals(response,service.getPayableAmount(request));

    }

    @Test
    public void getPayableAmountforhasGrocery(){
        BillingRequest request = BillingRequest.builder()
                .billAmount(500)
                .isAffiliate(true)
                .hasGroceries(true)
                .isLongTermCustomer(false)
                .isEmployee(false)
                .build();

        BillingResponse response = BillingResponse.builder()
                .netPayable(500)
                .build();
        assertEquals(response,service.getPayableAmount(request));

    }

    @Test
    public void getPayableAmountformorethan100$(){
        BillingRequest request = BillingRequest.builder()
                .billAmount(999)
                .isAffiliate(false)
                .hasGroceries(false)
                .isLongTermCustomer(false)
                .isEmployee(false)
                .build();

        BillingResponse response = BillingResponse.builder()
                .netPayable(954)
                .build();
        assertEquals(response,service.getPayableAmount(request));

    }


}