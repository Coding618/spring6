package com.test.spring6.aop.example;

import org.junit.jupiter.api.Test;

public class TestCalculation {
    @Test
    public void testCalculation() {
        ProxyFactory factory = new ProxyFactory(new CalculatorLogImpl());
        Calculator proxy = (Calculator)factory.getProxy();
        proxy.add(1, 2);
        proxy.sub(6,2);
        proxy.mul(2,9);
        proxy.div(9, 2);
    }
}
