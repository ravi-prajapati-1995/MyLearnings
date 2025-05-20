package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.toppings;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaDecorator;

public class VegTopping extends PizzaDecorator {

    public VegTopping(final BasePizza basePizza) {
        super(basePizza);
    }


}
