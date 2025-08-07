package com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop;

import lombok.Getter;

@Getter
abstract public class BasePizza {
    protected final PizzaSize size;
    protected final String description;

    public BasePizza(final PizzaSize size, final String description) {
        this.size = size;
        this.description = description;
    }

    public abstract int price();
}
