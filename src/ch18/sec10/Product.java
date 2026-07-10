package ch18.sec10;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = -621812868470078544L;
	private String name;
	private int price;
	private transient int price2; // transient를 사용하면 저장이 안 됨

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() { return name + ": " + price; }
}