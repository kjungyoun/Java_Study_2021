package com.ssafy.object;

import java.util.Arrays;

/** 고객을 관리하기 위한 클래스 */
public class CustomerManager {
	/** 고객 정보를 저장할 배열 */
	private Customer[] custs; // 이 배열에 접근하는 인덱스 필요

	/** 등록된 고객 수, 고객이 저장된 배열 위치 */
	private int size;

	private int MAX_SIZE = 3;
	
	private static CustomerManager instance;

	private CustomerManager() {
		custs = new Customer[MAX_SIZE];
	}
	
	public static CustomerManager getInstance() { // static이므로 객체 생성 없이 사용 가능
		if(instance == null)
			instance = new CustomerManager();
		return instance;
	}

	/**
	 * 고객 정보를 등록하는 기능
	 * 
	 * @param cust 등록할 고객 정보
	 */
	public void add(Customer cust) {
		// 공간이 부족하면 저장 X (시험문제)
		if (size < MAX_SIZE)
			custs[size++] = cust;
		else
			System.out.println("더 이상 등록할 수 없습니다.");
	}

//	public void add(Customer cust) {
	// 공간이 부족하면 공간을 늘리고 저장
//		if(size>=MAX_SIZE) {
//			MAX_SIZE += 10;
//			custs = Arrays.copyOf(custs, MAX_SIZE);
//		}
//		custs[size++] = cust;
//	}

	/**
	 * 고객 저장 유무를 확인하는 기능
	 */
	public void printCustomers() {
		for (int i = 0; i < size; i++) {
			System.out.println(custs[i]);
		}
	}

	/**
	 * 고객 정보를 제거하는 기능
	 * 
	 * @param name 제거할 고객 이름
	 */
	public void remove(String name) {
		for (int i = 0; i < size; i++) {
			if (name.equals(custs[i].getName())) {
				// 정석 제거 방법
				//custs[i] = custs[size-1]; // 맨 뒤에 애를 제거한 곳으로 옮김
				//custs[size-1] = null; // 맨 뒤에 남은 애를 제거

				/**
				 * 다른 제거 방법 이 방법은 사이즈를 줄여 맨 끝을 비우지 않고 접근하지 않도록 함
				 */
				custs[i] = custs[--size];

				break;
			}
		}
	}

	/**
	 * 고객 이름으로 검색
	 * 
	 * @param name 검색할 고객 이름
	 * @return 고객의 객체 정보 리턴
	 */
	public Customer searchByName(String name) {
		for (int i = 0; i < size; i++) {
			if (name.equals(custs[i].getName()))
				return custs[i];
		}
		return null;
	}
	
	/**
	 * 고객 정보 수정 기능
	 * @param cust 수정할 고객 정보
	 */
	public void update(Customer cust) {
		for (int i = 0; i < size; i++) {
			if (cust.getName().equals(custs[i].getName())) {
				//custs[i].setAddress(cust.getAddress());
				//custs[i].setAge(cust.getAge());
				custs[i] = cust;
				break;
			}
		}
	}
	
	/**
	 * 등록된 모든 고객 정보를 반환하는 기능
	 * @return 등록된 전체 고객 리스트
	 */
	public Customer[] getList() {
		return Arrays.copyOfRange(custs, 0, size);
	}

}
