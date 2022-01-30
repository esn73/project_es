package DoughnutsKiosk;

import java.io.Serializable;

public class Donuts implements Serializable {
	
	private int no;
	private String menuName;
	private int count;
	private int price;
	private int sum;
	private int total;
	
	public Donuts() {};
	
	public Donuts(int no, String menuName, int count, int price) {
		this.no = no;
		this.menuName = menuName;
		this.count = count;
		this.price = price;
		setPrice();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = this.count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice() {
		sum = this.price * this.count;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}


	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	

}//end class
