package com.kh.ex01.vo;

public class ProductVo {
	private String name; // 상품명
	private int price; // 가격
	
	// 기본 생성자
	public ProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 필드 생성자
	public ProductVo(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	// 게터/ 세터
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

	@Override
	public String toString() {
		return "ProductVo [name=" + name + ", price=" + price + "]";
	}
	
	
}
