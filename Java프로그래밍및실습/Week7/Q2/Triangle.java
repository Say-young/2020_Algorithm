package lab1;

import java.util.*;
public class Triangle implements Geometry{//�������̽��� implements
	/*
	System.out.println("=============");
			System.out.println("���� : ��ǻ�Ͱ���");
			System.out.println("�й� : 1871047");
			System.out.println("���� : �弼��");
			System.out.println("=============");	
	*/
	double a, b, c, s;//����� ���� ����
	
	//�� ������
	Triangle(){
	}
	
	//�Ķ���� ���� ������ �����ϴ� ������
	Triangle(double a, double b, double c){
		this();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//�������̵� - ���̸� ���ϴ� �޼���
	public double area() {
		s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
	//�������̵� - ���̸� ���ϴ� �޼���
	public double perimeter() {
		return a+b+c;
	}
	
}
