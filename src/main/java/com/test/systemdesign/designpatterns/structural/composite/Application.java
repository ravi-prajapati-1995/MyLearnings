package com.test.systemdesign.designpatterns.structural.composite;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final var pen = new Product("Pen", 20.0);
        final var noteBook = new Product("Note Book", 50.45);
        final var seizure = new Product("Seizure", 50.65);
        final var box1 = new Box(List.of(pen, noteBook, seizure));

        System.out.println("Box1 Price: "+ box1.getPrice());

        final var mobile = new Product("Mobile", 25499);
        final var headphone = new Product("Head phone", 4599);
        final var charger = new Product("charger", 1199);
        final var box2 = new Box(List.of(mobile, headphone, charger));

        System.out.println("Box2 Price: "+ box2.getPrice());

        final var hammer = new Product("Hammer", 500);
        final var book = new Product("Book", 500.53);

        final var finalBox = new Box(List.of(box1, box2, hammer, book));

        System.out.println("Final box price: "+finalBox.getPrice());
        
    }
}
