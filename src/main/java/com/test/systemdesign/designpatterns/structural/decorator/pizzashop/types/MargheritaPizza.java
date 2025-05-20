package com.test.systemdesign.designpatterns.structural.decorator.pizzashop.types;

import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.BasePizza;
import com.test.systemdesign.designpatterns.structural.decorator.pizzashop.PizzaSize;

public class MargheritaPizza extends BasePizza {

    public MargheritaPizza(final PizzaSize size) {
        super(size, "Margherita");
    }

    @Override
    protected int price() {
        return switch (getSize()){
            case REGULAR -> 109;
            case MEDIUM -> 239;
            case LARGE -> 449;
            case EXTRA_LARGE -> 599;
        };
    }
}
