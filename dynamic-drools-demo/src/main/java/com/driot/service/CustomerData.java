package com.driot.service;

import java.util.HashMap;

public class CustomerData {

    private static final HashMap<String, Integer> customer = new HashMap<>();

    private static final CustomerData customerData = new CustomerData();

    public CustomerData(){
        this.customer.put("8378988445", 10);
        this.customer.put("8378988443", 5);
    }

    private static CustomerData getInstance(){
        return customerData;
    }

    public Integer getCustomerTenure(String mobileNo){
        return (customer.get(mobileNo) !=null) ? customer.get(mobileNo) :0;
    }
}