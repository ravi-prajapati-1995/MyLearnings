package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.types;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaSize;

public class FarmHouse extends BasePizza {

    public FarmHouse(final PizzaSize size) {
        super(size, "Farm House");
    }

    @Override
    protected int price() {
        return switch (getSize()){
            case REGULAR -> 259;
            case MEDIUM -> 459;
            case LARGE -> 689;
            case EXTRA_LARGE -> 849;
        };
    }
}
