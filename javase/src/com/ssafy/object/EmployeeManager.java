//package com.ssafy.object;
//
//import java.util.Arrays;
//
//public class EmployeeManager {
//	/**일반 사원을 저장하는 배열 */
//	private Employee[] emps;
//	/**관리직 사원을 저장하는 배열 */
//	private Manager[]  mgrs;
//	/**기술직 사원을 저장하는 배열 */
//	private Engineer[] engs;
//	/**emps배열에 저장된 사원 수, 다음 저장 위치 */
//	private int empIndex;
//	/**mgrs배열에 저장된 사원 수, 다음 저장 위치 */
//	private int mgrIndex;
//	/**engs배열에 저장된 사원 수, 다음 저장 위치 */
//	private int engIndex;
//	public EmployeeManager() {
//		emps = new Employee[10];
//		mgrs = new Manager[5];
//		engs = new Engineer[7];
//	}
//	
//	/**사원번호에 해당하는 사원을 검색 */
//	public String findEmployee(String empno) {
//		if(empno != null) {
//			for (int i = 0; i < empIndex; i++) {
//				if(empno.equals(emps[i].getEmpno())) {
//					return emps[i].toString();
//				}
//			}
//			for (int i = 0; i < mgrIndex; i++) {
//				if(empno.equals(mgrs[i].getEmpno())) {
//					return mgrs[i].toString();
//				}
//			}
//			for (int i = 0; i < engIndex; i++) {
//				if(empno.equals(engs[i].getEmpno())) {
//					return engs[i].toString();
//				}
//			}
//		}
//		return "사원번호에 해당하는 사원 정보가 등록되지 않았습니다.";
//	}
//	
//	public void add(Employee emp) {
//		System.out.println("Employee 등록..........");
//		if(emp != null) {
//			String empno = emp.getEmpno();
//			boolean isFind= false;
//			for (int i = 0; i < empIndex; i++) {
//				if(empno.equals(emps[i].getEmpno())) {
//					isFind = true;
//					break;
//				}
//			}
//			if(!isFind) {
//				for (int i = 0; i < mgrIndex; i++) {
//					if(empno.equals(mgrs[i].getEmpno())) {
//						isFind = true;
//						break;
//					}
//				}
//			}
//			if(!isFind) {
//				for (int i = 0; i < engIndex; i++) {
//					if(empno.equals(engs[i].getEmpno())) {
//						isFind = true;
//						break;
//					}
//				}
//			}
//			if(isFind) {
//				System.err.printf("%s번 사원번호는 이미 등록된 번호입니다.\n",empno);
//			}else { //동일한 사원번호로 등록된 사원이 없으므로 등록 
//				if(empIndex >= emps.length) { //배열이 꽉찼기 때문에 배열 크기 변경 
////					Employee[] copy = new Employee[empIndex+5];
////					System.arraycopy(emps, 0, copy, 0, empIndex);
////					emps = copy;
//					emps = Arrays.copyOf(emps, empIndex+5);
//				}
//				emps[empIndex++] = emp; //배열 사이즈 늘려서 추가해줌
//			}
//		}
//	}
//	public void add(Manager emp) {
//		System.out.println("Manager 등록..........");
//		if(emp != null) {
//			String empno = emp.getEmpno();
//			boolean isFind= false;
//			for (int i = 0; i < empIndex; i++) {
//				if(empno.equals(emps[i].getEmpno())) {
//					isFind = true;
//					break;
//				}
//			}
//			if(!isFind) {
//				for (int i = 0; i < mgrIndex; i++) {
//					if(empno.equals(mgrs[i].getEmpno())) {
//						isFind = true;
//						break;
//					}
//				}
//			}
//			if(!isFind) {
//				for (int i = 0; i < engIndex; i++) {
//					if(empno.equals(engs[i].getEmpno())) {
//						isFind = true;
//						break;
//					}
//				}
//			}
//			if(isFind) {
//				System.err.printf("%s번 사원번호는 이미 등록된 번호입니다.\n",empno);
//			}else { 
//				if(mgrIndex >= mgrs.length) {  
//					mgrs = Arrays.copyOf(mgrs, mgrIndex+5);
//				}
//				mgrs[mgrIndex++] = emp;
//			}
//		}
//	}
//	public void add(Engineer emp) {
//		System.out.println("Engineer 등록..........");
//		if(emp != null) {
//			String empno = emp.getEmpno();
//			boolean isFind= false;
//			for (int i = 0; i < empIndex; i++) {
//				if(empno.equals(emps[i].getEmpno())) {
//					isFind = true;
//					break;
//				}
//			}
//			if(!isFind) {
//				for (int i = 0; i < mgrIndex; i++) {
//					if(empno.equals(mgrs[i].getEmpno())) {
//						isFind = true;
//						break;
//					}
//				}
//			}
//			if(!isFind) {
//				for (int i = 0; i < engIndex; i++) {
//					if(empno.equals(engs[i].getEmpno())) {
//						isFind = true;
//						break;
//					}
//				}
//			}
//			if(isFind) {
//				System.err.printf("%s번 사원번호는 이미 등록된 번호입니다.\n",empno);
//			}else { 
//				if(engIndex >= engs.length) {  
//					engs = Arrays.copyOf(engs, engIndex+5);
//				}
//				engs[engIndex++] = emp;
//			}
//		}
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
