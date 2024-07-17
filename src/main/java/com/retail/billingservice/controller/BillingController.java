package com.retail.billingservice.controller;

import com.retail.billingservice.dto.BillingRequest;
import com.retail.billingservice.dto.BillingResponse;
import com.retail.billingservice.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discount")
public class BillingController {

    @Autowired
    BillingService service;


    @PostMapping
    public ResponseEntity<BillingResponse> getPayableAmount(@RequestBody BillingRequest billingRequest){

        return ResponseEntity.ok(service.getPayableAmount(billingRequest));    }
}
