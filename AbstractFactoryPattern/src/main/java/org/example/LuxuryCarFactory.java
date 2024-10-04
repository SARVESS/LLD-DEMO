package org.example;

import org.example.AbstractCarFactory;
import org.example.BMW;

public class LuxuryCarFactory implements AbstractCarFactory {
    @Override
    public Car getCarInstance(int price) {
        if(price == 5000000) {
            return new BMW();
        } else if(price == 6000000) {
            return new Mercedes();
        }
        return null;
    }
}
