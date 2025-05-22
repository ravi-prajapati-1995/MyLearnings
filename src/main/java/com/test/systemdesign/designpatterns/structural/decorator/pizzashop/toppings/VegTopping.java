package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.toppings;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaDecorator;

public class VegTopping extends PizzaDecorator {

    public VegTopping(final BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    protected int price() {
        int topping = switch (size) {
            case REGULAR -> 30;
            case MEDIUM -> 40;
            case LARGE -> 50;
            case EXTRA_LARGE -> 60;
        };

        return price() + topping;
    }
}
