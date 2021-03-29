package com.money.service.impl;

import com.money.service.MoneyService;
import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl implements MoneyService {
    //tiêm sự phụ thuộc vào class triển khai nó
    @Override
    public double money(double a, double b) {
        return a*b;
    }
}
