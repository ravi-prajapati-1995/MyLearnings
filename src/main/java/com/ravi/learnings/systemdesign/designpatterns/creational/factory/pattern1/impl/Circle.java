package com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.impl;

import com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.Shape;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawing circle");
    }
}
