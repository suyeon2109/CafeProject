package com.model.vo;

/*Option 클래스를 상속받는 DrinkList클래스*/
//public class Drink extends Option {
public class Drink {

	String name; //음료 이름
	int price; //가격
	
	Option op; //초기값으로 설정된 Option 객체 생성	
	
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
