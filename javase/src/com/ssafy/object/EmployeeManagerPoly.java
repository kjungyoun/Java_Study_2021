package com.ssafy.object;

import java.util.Arrays;

public class EmployeeManagerPoly {
	/**다형성을 배열에 적용
	 * - 모든 자식은 부모타일으로 자동 형변환 되므로 부모타입의 배열에 자식들을 담을 수 있다
	 *  
	 *  */
	private Employee[] emps;
	
	/**emps배열에 저장된 사원 수, 다음 저장 위치 */
	private int empIndex;
	
	public EmployeeManagerPoly() {
		emps = new Employee[10];
	}
	/**
	* 사원 번호로 해당하는 배열 인덱스 반환 (재사용을 위함)
	* @param empno 찾을 사원 번호
	* @return 해당하는 사원 번호의 인덱스
	*/
	private int findIndex(String empno) { //사원 번호로 사원 검색
		if(empno != null) {
			for(int i=0; i<empIndex; i++) {
				if(empno.equals(emps[i].getEmpno())) {
					return i;
				}
			}
		}return -1; // 같은 사원을 못찾은 경우
	}
	
	/**
	 * 다형성을 리턴 타입에 적용
	 *  */
	public Employee findEmployee(String empno) { //
		int index = findIndex(empno);
		if(index>-1) { //찾았다면 사원 정보 리턴
			return emps[index];
		}else { // 못찾았으면 null 리턴
			return null;
		}
	}
	/**
	 * 다형성을 인자에 적용
	 * 모든 자식은 부모로 자동형변환 되므로 인자를 부모타입으로 선언하면 모든 자식은 전달 받을 수 있다.
	 */
	public void add(Employee emp) {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				System.err.printf("%s번 사원번호는 이미 등록된 번호입니다.\n",empno);
			}else { //동일한 사원번호로 등록된 사원이 없으므로 등록 
				if(empIndex >= emps.length) { //배열이 꽉찼기 때문에 배열 크기 변경 
//					Employee[] copy = new Employee[empIndex+5];
//					System.arraycopy(emps, 0, copy, 0, empIndex);
//					emps = copy;
					emps = Arrays.copyOf(emps, empIndex+5);
				}
				emps[empIndex++] = emp;
			}
		}
	}
	public void update(Employee emp) {
		if(emp!=null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				emps[index] = emp;
			}else {
				System.err.printf("사원번호 %s번에 등록된 사원 정보가 없어서 수정할 수 없습니다.",empno);
			}
		}
	}
	public void remove(String empno) {
		int index = findIndex(empno);
		if(index>-1) {
			emps[index] = emps[--empIndex];
		}else {
			System.err.printf("사원번호 %s번에 등록된 사원 정보가 없어서 삭제할 수 없습니다.",empno);
		}
				
	}
	public void print() {
		for(int i = 0;i<empIndex; i++) {
			System.out.println(emps[i]);
		}
	}
	
}

