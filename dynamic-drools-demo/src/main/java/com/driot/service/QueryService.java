package com.driot.service;

public interface QueryService {

    public Object executeQuery(String query);
    public Object executeQuery(String id, Object param, Object op);
}