package hw;

public class Circle {
	final double PI = 3.14159;
	private double radius;
	double perimeter, area;

	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double perimeter(){
		perimeter = PI*2*radius;
		return perimeter;
	}
	
	public double area() {
		area = PI*radius*radius;
		return area;
	}
	
	public void circleInfo() {
		System.out.printf("원둘레:%.2f\n",perimeter());
		System.out.printf("원넓이:%.2f\n",area());
	}
}
