package org.example.Decorator;

import org.example.BasePizza;

public class ExtraSauce extends ToppingDecorator {
    BasePizza basePizza;
    public ExtraSauce(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
