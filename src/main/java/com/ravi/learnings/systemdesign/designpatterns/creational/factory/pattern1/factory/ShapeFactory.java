package com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.factory;

import com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.Shape;
import com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.impl.Circle;
import com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.impl.Rectangle;
import com.ravi.learnings.systemdesign.designpatterns.creational.factory.pattern1.impl.Square;

public class ShapeFactory {

    public static Shape getShape(String type) {
        if("circle".equalsIgnoreCase(type)){
            return new Circle();
        } else if("square".equalsIgnoreCase(type)) {
            return new Square();
        } else if("rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }

    }
}
