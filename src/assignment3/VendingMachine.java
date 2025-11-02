package assignment3;

import java.util.ArrayList;
import java.util.Collections;
public class VendingMachine {
	// ArrayList of Integers represents inserted coins in Coin Slot
	private ArrayList<Integer> insertedCoins;
	// ArrayList of Product represents inventories of products
	private ArrayList<Product> products;
	public VendingMachine() {
		insertedCoins = new ArrayList<Integer>();
		products = new ArrayList<Product>();
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	public void insertCoin(Integer c) {
		insertedCoins.add(c);
	}
	public void initializeProducts() {
		products.add(new Product("Cocacola", 4, 0));
		products.add(new Product("Pepsi", 5, 0));
		products.add(new Product("Sprite", 6, 0));
		products.add(new Product("Mirinda", 7, 0));
		products.add(new Product("Gatorade", 8, 0));
		products.add(new Product("Bonaqua", 11, 0));
		products.add(new Product("RedBull", 12, 0));
		products.add(new Product("Tropicana", 15, 0));
		products.add(new Product("MinuteMaid", 10, 0));
	}
	// testing use
	public String printProduct() {
		String message = "";
		for (Product p : products) {
			message += p.getName() + "-" + p.getPrice() + "-" + p.getQuantity() + ", ";
		}
		return message;
	}
	// end testing
	public void stockProduct(String name, int quantity) {
		int i = 0;
		while (!products.get(i).getName().equals(name)) {
			i++;
		}
		products.get(i).changeQuantity(quantity);
	}
	public String buyProduct(String name, int bal) {
		int i = 0;
		while (!products.get(i).getName().equals(name)) {
			i++;
		}
		if (products.get(i).getPrice() > bal) {
			return "Not enough credit to buy " + name + "! Inserted $" + bal + " but needs $" + products.get(i).getPrice() + ".";
		} else if (products.get(i).getQuantity() == 0) {
			return name + " is out of stock!";
		} else {
			insertedCoins.clear();
			products.get(i).changeQuantity(-1);
			int change = bal - products.get(i).getPrice();
			String message = "Dropped " + name + ". Paid $" + bal + ". ";
			if (change == 0) {
				message += "No change.";
			} else {
				message += "Your change:";
				while (change != 0) {
					if (change >= 10) {
						message += " $10";
						change -= 10;
					} else if (change >= 5) {
						message += " $5";
						change -= 5;
					} else if (change >= 2) {
						message += " $2";
						change -= 2;
					} else {
						message += " $1";
						change -= 1;
					}
					if (change == 0) {
						message += ".";
					} else {
						message += ",";
					}
				}
			}
			return message;
		}
	}
	
	public int countCoin() {
		int total = 0;
		for (int coin : insertedCoins) {
			total += coin;
		}
		return total;
	}
	public int[] productInfo(String name) {
		int i = 0;
		while (!products.get(i).getName().equals(name)) {
			i++;
		}
		return new int[] {products.get(i).getPrice(), products.get(i).getQuantity()};
	}
	public String rejectCoin() {
		Collections.sort(insertedCoins, Collections.reverseOrder());
		String message = "Rejected ";
		int sum = 0;
		for (int i = 0; i < insertedCoins.size(); i++) {
			message += "$" + insertedCoins.get(i);
			sum += insertedCoins.get(i);
			if (i == insertedCoins.size() - 1) {
				message += ". ";
			} else {
				message += ", ";
			}
		}
		message += "$" + sum + " in total.";
		insertedCoins.clear();
		return message;
	}
}