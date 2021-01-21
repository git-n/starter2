package com.localhost.starter2.service;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {
    @Override
    public long add(int num1, int num2) {
        return (long)num1+num2;
    }
}
