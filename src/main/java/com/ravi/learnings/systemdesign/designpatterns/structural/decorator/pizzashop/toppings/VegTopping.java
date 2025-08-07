package com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.toppings;

import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaDecorator;

public class VegTopping extends PizzaDecorator {

    public VegTopping(final BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int price() {
        int topping = switch (size) {
            case REGULAR -> 30;
            case MEDIUM -> 40;
            case LARGE -> 50;
            case EXTRA_LARGE -> 60;
        };
        System.out.println("Adding VegTopping with price: "+ topping);
        return getBasePizza().price() + topping;
    }
}
