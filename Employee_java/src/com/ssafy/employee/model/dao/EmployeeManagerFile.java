package com.ssafy.employee.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.employee.model.dto.Employee;

public class EmployeeManagerFile extends EmployeeManagerList {
	// 아래 파일 경로는 따로 지정하지 않은 이상 프로젝트 경로 안에 만들어진다.
	private String fileName = "employee.csv";
	
	/**
	 * 처음 실행할 때 불러올 것이므로 생성자에 load()를 추가한다.
	 */
	public EmployeeManagerFile() {
		load();
	}

	public void save() {
		//try 안에서 선언 후 생성하므로 close를 따로 안해도 된다.
		// BufferedWriter는 객체 정보를 쓰는 기능
		// file에 ms949로 생성하고 ms949로 만들기 위해 outputStreamWriter를 이용하여 계열 변환
		// 그다음 버퍼를 이용해서 출력한다.
		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "MS949"))) {
			List<Employee> emps = searchAll();
			for (Employee employee : emps) {
				// toString을 이용해 나온 객체 정보를 쓴다.
				out.write(employee.toString());
				out.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		File file = new File(fileName);
		if (file.exists() && file.canRead()) {
			// in은fileInputStream -> InputStreamReader -> BufferedReader순으로 동작
			try (BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileName), "MS949"))) {
				String line = null;
				LinkedList<Employee> emps = new LinkedList<Employee>();
				// 읽은 한 줄을 라인에 저장
				while ((line = in.readLine()) != null) {
					String[] info = line.split(",");
					// line을 읽어서 다시 리스트에 저장
					emps.add(new Employee(info[0], info[1], Integer.parseInt(info[2])));
				}
				setEmps(emps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 사원 정보를 등록 후 파일에 저장하겠다.
	 */
	@Override
	public void add(Employee emp) {
		super.add(emp);
		save();
	}
	
	/**
	 * 업데이트 후 파일에 저장한다.
	 */
	@Override
	public void update(Employee emp) {
		super.update(emp);
		save();
	}
	
	/**
	 * 제거 후 파일에 저장한다.
	 */
	@Override
	public void remove(String empno) {
		super.remove(empno);
		save();
	}
}
