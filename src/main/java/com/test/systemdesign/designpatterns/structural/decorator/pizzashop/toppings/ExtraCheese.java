package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.toppings;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaDecorator;

public class ExtraCheese extends PizzaDecorator {

    public ExtraCheese(final BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int price() {
        int topping = switch (size) {
            case REGULAR -> 75;
            case MEDIUM -> 99;
            case LARGE -> 129;
            case EXTRA_LARGE -> 199;
        };
        System.out.println("Adding Chesse with price: "+ topping);
        return getBasePizza().price() + topping;
    }
}
