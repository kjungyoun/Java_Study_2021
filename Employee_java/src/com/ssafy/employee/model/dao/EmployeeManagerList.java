package com.ssafy.employee.model.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.employee.model.dto.Employee;
import com.ssafy.employee.model.dto.EmployeeException;

public class EmployeeManagerList implements EmployeeManager {
	private LinkedList<Employee> emps;
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = (LinkedList<Employee>)emps;
	}
	public EmployeeManagerList() {
		emps = new LinkedList<Employee>();
	}
	private int findIndex(String empno) {
		if(empno != null) {
			for (int i = 0,size=emps.size(); i < size; i++) {
				if(empno.equals(emps.get(i).getEmpno())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	@Override
	public void add(Employee emp) { 
		// throws를 하지 않은 이유는 uncheckedException을 상속 받았기 때문에 에러 처리를 할 필요가 없기 때문이다.
		// 해도되고 안해도 됨, 안하면 JVM에 의해 자동 throws 된다.
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index>-1) {
				// throw는 리턴의 효과를 준다.
				throw new EmployeeException(String.format("사원 번호 %s 번은 이미 등록된 사원 번호입니다.", empno));
			}
			emps.add(emp);
		}else {
			throw new EmployeeException("사원번호가 부정확합니다. 다시 입력해주세요");
		}

	}

	@Override
	public void update(Employee emp)  {
		if(emp != null) {
			String empno = emp.getEmpno();
			int index = findIndex(empno);
			if(index == -1) { // 등록되지 않은 사원일 경우
				throw new EmployeeException(String.format("사원번호 %s 번은 등록되지 않은 사원번호로 수정할 수 없습니다.", empno));
			}
			emps.set(index, emp);
		}else {
			throw new EmployeeException("수정할 사원번호가 부정확합니다. 다시 입력해주세요");
		}

	}

	@Override
	public Employee search(String empno)  {
		if(empno != null) {
			int index = findIndex(empno);
			if(index == -1) { // 등록되지 않은 사원일 경우
				throw new EmployeeException(String.format("%s 번은 등록되지 않은 사원번호로 사원 번호를 조회할 수 없습니다.", empno));
			}
			return emps.get(index);
		}else {
			throw new EmployeeException("조회할 사원 번호를 입력해주세요");
		}
	}

	@Override
	public List<Employee> searchAll(){
		// dao이기 때문에 원본을 넘겨주면 위험 부담이 있다. 따라서 원본은 건들지 않도록 복제본을 넘겨주는 게 좋다.
		Object copy = emps.clone();
		return (List<Employee>)copy;
	}
	
	@Override
	public void remove(String empno) {
		if(empno != null) {
			int index = findIndex(empno);
			if(index == -1) { // 등록되지 않은 사원일 경우
				throw new EmployeeException(String.format("사원번호 %s 번은 등록되지 않은 사원번호로 삭제할 수 없습니다.", empno));
			}
			emps.remove(index);
		}else {
			throw new EmployeeException("삭제할 사원 번호를 입력해주세요");
		}
		
	}

}
