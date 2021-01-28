package lab.ssafy.corona.medical;

import lab.ssafy.corona.person.Patient;

public class Organization {
	private String name;
	private int employeeCount;
	
	public Organization() {}

	public Organization(String name, int employeeCount) {
		this.name = name;
		this.employeeCount = employeeCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	public void about() {
		System.out.println("Organization : " + name );
	}

	public void addPatient(Patient p) throws NotCoronaException {
		// TODO Auto-generated method stub
		
	}

	public void removePatient(Patient p) {
		// TODO Auto-generated method stub
		
	}
}
