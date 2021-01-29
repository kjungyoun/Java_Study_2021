package com.ssafy.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ssafy.employee.model.dao.EmployeeManager;
import com.ssafy.employee.model.dao.EmployeeManagerFile;
import com.ssafy.employee.model.dto.Employee;

public class Main {
	static Scanner s = new Scanner(System.in);
//	private EmployeeManager mgr = new EmployeeManagerList();
	// 파일 저장하기 위해서 다른 코드는 수정할 필요 없이 객체 생성만 바꾸어 주면 된다.
	// 파일로 저장하기 때문에 실행을 껐다가 다시 켜서 바로 조회해도 정보가 저장되있는 것을 알 수 있다.
	private EmployeeManager mgr = new EmployeeManagerFile();

	public static int menu() {
		int result = 0;
		System.out.println("==================================");
		System.out.println("========== 사원 관리 프로그램 ==========");
		System.out.println("==================================");
		System.out.println("1. 사원 등록");
		System.out.println("2. 사원 목록 보기");
		System.out.println("3. 사원 검색");
		System.out.println("4. 사원 수정");
		System.out.println("5. 사원 삭제");
		System.out.println("0. 종료");
		System.out.println("원하는 번호를 선택 하세요.");

		result = s.nextInt();

		return result;
	}
	/**
	 * 사원 등록 기능
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	private void insert() throws NumberFormatException, SQLException {
		// 문자열을 숫자형으로 형변환 해야하는 메서드들은 NumberFormatException을 throws한다.
		System.out.println("사원 정보를 입력하세요. 형식:사원번호,이름,급여");
		String[] info = s.next().split(","); // split을 이용해 구분자로 문자열 나눔
		mgr.add(new Employee(info[0],info[1],Integer.parseInt(info[2])));
	}
	
	/**
	 *  사원 전체 목록 조회 기능
	 * @throws SQLException
	 */
	private void search() throws SQLException {
		System.out.println(">>>>>>>>>>>>>>>>>>사원 목록 보기");
		List<Employee> emps = mgr.searchAll();
		for(Employee employee : emps) {
			System.out.println(employee);
		}
		
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		int num = 0;
		while (true) {
			num = menu();
			if (num == 0)
				break;
			try { 
				// Exception이 한 곳에 모였기 때문에 한번에 처리함
				// case 내부에 호출하는 곳에서 일일이 try - catch 할 수 있지만 코드 재사용률이 떨어진다.
				switch (num) {
				case 1:
				m.insert();
					break;
				case 2:
				m.search();
					break;
				case 3:
				m.searchNum();
					break;
				case 4:
				m.update();
				m.search();
					break;
				case 5:
				m.delete();
				m.search();
					break;
				default:
					System.err.println("메뉴 번호를 정확히 입력해 주세요.");
					continue;
				}
			} catch (NumberFormatException e) {
				System.err.println("급여는 정수로 입력해주세요");
			}catch(Exception e) {
				System.err.println(e.getMessage()); // 각 Exception이 가진 메세지 출
			}

		}
	}
	
	private void delete() throws SQLException {
		System.out.println(">>>>>>>>> 사원 정보 삭제");
		System.out.println(">>>>>>>>> 삭제할 사원 번호를 입력해주세요.");
		String empno = s.next();
		mgr.remove(empno);
	}
	private void update() throws NumberFormatException, SQLException { 
		// 둘다 checkedException 이므로 반드시 throws를 해주어야 한다.
		System.out.println(">>>>>>>>> 사원 정보 수정");
		System.out.println(">>>>>>>>> 수정할 사원 정보를 입력해주세요(형식:사원번호,이름,급여");
		String[] info = s.next().split(",");
		mgr.update(new Employee(info[0],info[1],Integer.parseInt(info[2])));
		
	}
	private void searchNum() throws SQLException {
		System.out.println(">>>>>>>>>>> 검색할 사원의 사원번호를 입력해주세요");
		String empno = s.next();
		System.out.println(mgr.search(empno));
		
	}

}
