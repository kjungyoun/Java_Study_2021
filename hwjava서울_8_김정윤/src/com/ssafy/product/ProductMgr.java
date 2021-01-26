package com.ssafy.product;

import java.util.Arrays;

public class ProductMgr {
	private Product[] prods;
	private int size;
	private int MAX_SIZE = 100;
	private static ProductMgr instance;
	
	/**
	 * 싱글톤 구현을 위한 private 생성자
	 */
	private ProductMgr() {
		prods = new Product[MAX_SIZE];
	}
	
	/**
	 * 싱글톤에서 객체 생성을 위한 메서드
	 * @return 생성된 객체 반환
	 */
	public static ProductMgr getInstance() {
		if(instance == null)
			instance = new ProductMgr();
		return instance;
	}
	
	/**
	 * 상품을 목록에 추가하는 기능
	 * @param p 추가할 상품 객체
	 */
	public void add(Product p) {
		if(size<MAX_SIZE) {
			prods[size++] = p;
		}else System.out.println("상품이 가득찼습니다.");
	}
	
	/**
	 * 저장된 상품을 모두 볼 수 있는 기능
	 */
	public Product[] list() {
		return Arrays.copyOf(prods, size);
	}
	
	/*
	 * 상품 번호로 검색하는 기능
	 * @param num 검색할 상품 번호 
	 */
	public Product list(int num) {
		for (int i = 0; i < size; i++) {
			if(num == prods[i].getNum()) {
				return prods[i];
			}
		}
		return null;
	}
	
	/**
	 * 상품 번호로 제거하는 기능
	 * @param num 제거할 상품 번호
	 */
	public void delete(int num) {
		for (int i = 0; i < size; i++) {
			if(num == prods[i].getNum()) {
				prods[i] = prods[size-1];
				prods[size-1] = null;
				size--;
				break;
			}
			System.out.println("찾는 상품이 없습니다.");
		}
	}
	
	/**
	 * 특정 가격 이하의 상품만 검색하는 기능
	 * @param price 검색할 기준 가격
	 */
	public Product[] priceList(int price) {
		int index=0;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if(price >= prods[i].getPrice()) {
				count++;
			}
		}
		Product[] pd = new Product[count];
		for (int i = 0; i < size; i++) {
			if(price>=prods[i].getPrice()) {
				pd[index++] = prods[i];
			}
		}
		return Arrays.copyOf(pd, index);
	}
}
