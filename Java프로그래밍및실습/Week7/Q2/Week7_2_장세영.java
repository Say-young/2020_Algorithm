package lab1;

import java.util.*;
public class Week7_2_�弼�� {
	public static void main(String[] args) {
		
		System.out.println("=============");
		System.out.println("���� : ��ǻ�Ͱ���");
		System.out.println("�й� : 1871047");
		System.out.println("���� : �弼��");
		System.out.println("=============");
		
		Scanner scanner = new Scanner(System.in);
		
		int a,b,c; //�Է� ���� ���� ����
		System.out.println("Input radius for a circle");
		a=scanner.nextInt();//�����Է¹ޱ�
		Circle circle = new Circle(a);//circle ��ü ����
		
		System.out.println("Input radius for a square");
		a=scanner.nextInt();//�����Է¹ޱ�
		Square square = new Square(a);//square ��ü ����

		System.out.println("Input radius for a triangle");
		a=scanner.nextInt();//���� �Է� �ޱ�
		System.out.println("Input radius for b triangle");
		b=scanner.nextInt();
		System.out.println("Input radius for c triangle");
		c=scanner.nextInt();
		Triangle triangle = new Triangle(a, b, c);//triangle ��ü ����
		
		//������ area, perimeter �޼��带 �̿��� ����� ���
		System.out.println("<Circle>");
		System.out.println("Area: "+circle.area());
		System.out.println("Perimeter: "+circle.perimeter());
		
		System.out.println("<Sqaure>");
		System.out.println("Area: "+square.area());
		System.out.println("Perimeter: "+square.perimeter());
		
		System.out.println("<Triangle>");
		System.out.println("Area: "+triangle.area());
		System.out.println("Perimeter: "+triangle.perimeter());
	}
}
