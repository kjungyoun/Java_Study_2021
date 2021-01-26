package com.ssafy.object;

import java.util.Arrays;

public class ProductMgr {
	private static ProductMgr instance;
	private int size;
	private int MAX_SIZE=100;
	private Product[] prods;
	
	private ProductMgr() {
		prods = new Product[MAX_SIZE];
	}
	
	public static ProductMgr getInstance() {
		if(instance == null) instance = new ProductMgr();
		return instance;
	}
	
	public void add(Product p) {
		if(size<MAX_SIZE) {
			prods[size++] = p;
		}else {
			MAX_SIZE +=10;
			prods = Arrays.copyOf(prods, MAX_SIZE);
		}
	}
	
	public void list() {
		for(int i=0; i<size;i++) {
			System.out.println(prods[i]);
		}
	}
	
	public void list(int num) {
		for (int i = 0; i < size; i++) {
			if(num == prods[i].getNum()) System.out.println(prods[i]);
		}
	}
	
	public void delete(int num) {
		for (int i = 0; i < size; i++) {
			if(num == prods[i].getNum()) {
				prods[i] = prods[size-1];
				prods[size-1] = null;
				size--;
				break;
			}
		}
	}
	
	public void priceList(int price) {
		for(int i =0; i<size; i++) {
			if(price>prods[i].getPrice())
				System.out.println(prods[i]);
		}
	}
}
