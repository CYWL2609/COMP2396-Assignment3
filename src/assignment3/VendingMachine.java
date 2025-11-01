package assignment3;

import java.util.ArrayList;
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
	public int countCoin() {
		int total = 0;
		for (int coin : insertedCoins) {
			total += coin;
		}
		return total;
	}
	public int[] productInfo(String name) {
		int i = 0;
		while (products.get(i).getName() != name) {
			i++;
		}
		return new int[] {products.get(i).getPrice(), products.get(i).getQuantity()};
	}
}