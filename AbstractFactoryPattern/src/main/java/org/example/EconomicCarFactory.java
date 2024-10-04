package org.example;

import org.example.AbstractCarFactory;
import org.example.Alto;

public class EconomicCarFactory implements AbstractCarFactory {

    @Override
    public Car getCarInstance(int price) {
        if(price == 500000) {
            return new Alto();
        } else if (price == 1000000) {
            return new Swift();
        }
        return null;
    }

}
