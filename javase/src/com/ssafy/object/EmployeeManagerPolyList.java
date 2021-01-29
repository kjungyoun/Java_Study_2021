package com.ssafy.object;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeManagerPolyList {

	private ArrayList<Employee> emps;
	
	public EmployeeManagerPolyList() {
		emps = new ArrayList<>(10);
	}
	private int findIndex(String empno) { //사원 번호로 사원 검색
		if(empno != null) {
			for(int i=0, size = emps.size();i<size; i++) {
				if(empno.equals(emps.get(i).getEmpno())) {
					return i;
				}
			}
		}return -1; // 같은 사원을 못찾은 경우
	}
	public Employee findEmployee(String empno) { //
		int index = findIndex(empno);
		if(index>-1) { //찾았다면 사원 정보 리턴
			return emps.get(index);
		}else { // 못찾았으면 null 리턴
			return null;
		}
	}
	public void add(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				System.err.printf("%s번 사원번호는 이미 등록된 번호입니다.\n",empno);
			}else { //동일한 사원번호로 등록된 사원이 없으므로 등록 
				emps.add(emp);
			}
		}
	}
	public void update(Employee emp) {
		if(emp!=null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				emps.set(index, emp);
			}else {
				System.err.printf("사원번호 %s번에 등록된 사원 정보가 없어서 수정할 수 없습니다.",empno);
			}
		}
	}
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index>-1) {
			emps.remove(index);
		}else {
			System.err.printf("사원번호 %s번에 등록된 사원 정보가 없어서 삭제할 수 없습니다.",empno);
		}		
	}
	public void print() {
		for (Employee emp : emps) { //for-each문에서 배열은 전체를 돌리지만 리스트는 size만큼 돌림
			System.out.println(emp);
		}
	}
}

