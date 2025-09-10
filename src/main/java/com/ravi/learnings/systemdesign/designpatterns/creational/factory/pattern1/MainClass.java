package com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1;

import com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.factory.ShapeFactory;

public class MainClass {
    public static void main(String[] args) {
        final var circle = ShapeFactory.getShape("circle");
        circle.draw();
    }
}
