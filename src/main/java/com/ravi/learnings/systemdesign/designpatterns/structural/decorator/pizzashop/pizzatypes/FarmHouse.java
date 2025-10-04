package com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.pizzatypes;

import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaSize;

public class FarmHouse extends BasePizza {

    public FarmHouse(final PizzaSize size) {
        super(size, "Farm House");
    }

    @Override
    public int price() {
        int price = switch (getSize()) {
            case REGULAR -> 259;
            case MEDIUM -> 459;
            case LARGE -> 689;
            case EXTRA_LARGE -> 849;
        };

        System.out.println("Have FarmHouse: " + price);
        return price;
    }
}
