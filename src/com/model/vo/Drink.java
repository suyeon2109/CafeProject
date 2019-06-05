package com.model.vo;

/*Option Ŭ������ ��ӹ޴� DrinkListŬ����*/
//public class Drink extends Option {
public class Drink {

	String name; //���� �̸�
	int price; //����
	
	Option op; //�ʱⰪ���� ������ Option ��ü ����	
	
	public Drink() { }

	public Drink(String name, int price, Option op) {
		this.name = name;
		this.price = price;
		this.op = op;
	}

	/*getter & setter*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Option getOp() {
		return op;
	}

	public void setOp(Option op) {
		this.op = op;
	}

	@Override
	public String toString() {
		return "Drink [name=" + name + ", price=" + price + ", op=" + op + "]";
	}

}
