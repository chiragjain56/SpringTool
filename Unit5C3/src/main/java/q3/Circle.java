package q3;

import java.awt.Shape;

public class Circle implements Shape {
private int radius;
public void area() {
	return  (22/7)*radius*radius;
}
public Circle(int radius) {
	this.radius = radius;
}
}
