package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.types;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaSize;

public class VegDeluxe extends BasePizza {

    public VegDeluxe(final PizzaSize size) {
        super(size, "Veg Deluxe");
    }

    @Override
    protected int price() {
        return switch (getSize()){
            case REGULAR -> 299;
            case MEDIUM -> 549;
            case LARGE -> 799;
            case EXTRA_LARGE -> 950;
        };
    }
}
