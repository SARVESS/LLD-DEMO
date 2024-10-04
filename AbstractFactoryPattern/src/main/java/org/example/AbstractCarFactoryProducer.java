package org.example;

import org.example.AbstractCarFactory;

public class AbstractCarFactoryProducer {
    public AbstractCarFactory getAbstractCarFactoryInstance(String value) {
        if(value.equals("Economic")) {
            return new EconomicCarFactory();
        } else if (value.equals("Luxury")) {
            return new LuxuryCarFactory();
        }
        return null;
    }
}
