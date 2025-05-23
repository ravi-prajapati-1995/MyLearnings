package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.toppings;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaDecorator;

public class ExtraMushroom extends PizzaDecorator {

    public ExtraMushroom(final BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int price() {
        int topping = switch (size) {
            case REGULAR -> 40;
            case MEDIUM -> 60;
            case LARGE -> 80;
            case EXTRA_LARGE -> 100;
        };
        System.out.println("Adding ExtraMushroom with price: "+ topping);
        return getBasePizza().price() + topping;
    }
}
