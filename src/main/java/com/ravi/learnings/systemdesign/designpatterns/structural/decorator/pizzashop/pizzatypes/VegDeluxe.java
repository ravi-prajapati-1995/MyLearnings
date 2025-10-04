package com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.pizzatypes;

import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaSize;

public class VegDeluxe extends BasePizza {

    public VegDeluxe(final PizzaSize size) {
        super(size, "Veg Deluxe");
    }

    @Override
    public int price() {
        int price = switch (getSize()) {
            case REGULAR -> 299;
            case MEDIUM -> 549;
            case LARGE -> 799;
            case EXTRA_LARGE -> 950;
        };

        System.out.println("Have VegDeluxe: " + price);
        return price;
    }
}
