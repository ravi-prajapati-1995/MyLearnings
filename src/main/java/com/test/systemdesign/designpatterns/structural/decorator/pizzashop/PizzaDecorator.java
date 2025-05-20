package com.test.systemdesign.designpatterns.structural.decorator.pizzashop;

abstract  public class PizzaDecorator {
    final private BasePizza basePizza;

    public PizzaDecorator(final BasePizza basePizza) {
        this.basePizza = basePizza;
    }
}
