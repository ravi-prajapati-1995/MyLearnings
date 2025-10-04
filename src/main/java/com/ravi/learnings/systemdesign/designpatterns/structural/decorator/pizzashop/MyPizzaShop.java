package com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop;

import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.pizzatypes.VegDeluxe;
import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.toppings.ExtraCheese;
import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.toppings.ExtraMushroom;
import com.ravi.learnings.systemdesign.designpatterns.structural.decorator.pizzashop.toppings.VegTopping;

public class MyPizzaShop {
    public static void main(String[] args) {
        final var vegDeluxe = new VegDeluxe(PizzaSize.MEDIUM);
        final var extraMushroom = new ExtraMushroom(vegDeluxe);
        final var extraCheese = new ExtraCheese(extraMushroom);
        final var vegTopping = new VegTopping(extraCheese);

        System.out.println(vegTopping.description);
        System.out.println(vegTopping.price());
    }
}
