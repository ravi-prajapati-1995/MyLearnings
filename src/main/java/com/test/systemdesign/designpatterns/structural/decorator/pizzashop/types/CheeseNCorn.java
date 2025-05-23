package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.types;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaSize;

public class CheeseNCorn extends BasePizza {

    public CheeseNCorn(final PizzaSize size) {
        super(size, "Cheese N Corn");
    }

    @Override
    public int price() {
        int price =  switch (getSize()){
            case REGULAR -> 209;
            case MEDIUM -> 379;
            case LARGE -> 609;
            case EXTRA_LARGE -> 799;
        };
        System.out.println("Have CheeseNCorn: "+ price);
        return price;
    }
}
