package com.techelevator;

import com.techelevator.view.Menu;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private static final String [] EDIT_DATA_OPTIONS = {"Feed Money", "Select Product", "Finish Transaction", "Back"};

	private Menu menu;
	private List<Product> products = new ArrayList<>();

	private double balance = 0.00;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		loadData();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayLoadData();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displayPurchaseMenuOptions();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.exit(1);
			}
		}
	}

	public void loadData() {
		File file = new File("vendingmachine.csv");

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String [] lineArr = line.split("\\|");

				String slotLocation = lineArr[0];
				String name = lineArr[1];
				double price = Double.parseDouble(lineArr[2]);
				String category = lineArr[3];

				Product product = new Product(slotLocation, name, price, category, 5);
				products.add(product);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problem finding file.");
		}
	}
	public void displayLoadData() {
		 for (Product product : this.products) {
			 System.out.println(product.getSlotLocation() + " " + product.getName() + " " +
					 product.getPrice() + " " + product.getCategory() + " Quantity: " + product.getQuantity());
		 }
	}
	public void displayPurchaseMenuOptions() {
		boolean stay = true;

		while (stay) {
			String choice = (String) menu.getChoiceFromOptions(EDIT_DATA_OPTIONS);
			if (choice.equals("Feed Money")) {
				feedMoney();
			} else if (choice.equals("Select Product")) {
				selectProduct();
			} else if (choice.equals("Finish Transaction")) {

			} else if (choice.equals("Back")) {
				stay = false;
			}
			System.out.println("Current balance: $" + balance);
		}
	}
	public void feedMoney () {
		Scanner feedMoneyScanner = new Scanner(System.in);
		System.out.println("Please enter dollars in 1, 2, 5, or 10");

			int dollarAmount = Integer.parseInt(feedMoneyScanner.nextLine());

			if (dollarAmount == 1) {
				balance += 1;
			} else if (dollarAmount == 2) {
				balance += 2;
			} else if (dollarAmount == 5) {
				balance += 5;
			} else if (dollarAmount == 10) {
				balance += 10;
			} else {
				System.out.println("Not a valid dollar amount");
	}

	}

	public void selectProduct() {
		displayLoadData();
		System.out.println("");
		System.out.println("Please enter an item code to select an item.");
		Scanner inputSelection = new Scanner(System.in);
		String slotLocationInput = inputSelection.nextLine();
		boolean found = false;

		for (int i = 0; i < this.products.size(); i++) {
			Product product = products.get(i);
			String slotLocation = product.getSlotLocation();

			if (slotLocation.equals(slotLocationInput)) {
				if (balance >= product.getPrice()) {
					if (product.getQuantity() > 0) {
						found = true;
						product.setQuantity(product.getQuantity() - 1);
						balance -= product.getPrice();
						if (product.getCategory().equals("Drink")) {
							System.out.println(product.getName() + " " + product.getPrice() + " " + balance + " Glug Glug, Yum!");
						} else if (product.getCategory().equals("Candy")) {
							System.out.println(product.getName() + " " + product.getPrice() + " " + balance + " Munch Munch, Yum!");
						} else if (product.getCategory().equals("Chips")) {
							System.out.println(product.getName() + " " + product.getPrice() + " " + balance + " Crunch Crunch, Yum!");
						} else if (product.getCategory().equals("Gum")) {
							System.out.println(product.getName() + " " + product.getPrice() + " " + balance + " Chew Chew, Yum!");
						}
					}
				}
			}
		}
	}



	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
