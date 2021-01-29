package lab.ssafy.corona.person;

public class Doctor extends Person {
	private String hopitalId;
	private String licenseId;
	public Doctor () {}
	public Doctor(String hopitalId, String licenseId) {
		this.hopitalId = hopitalId;
		this.licenseId = licenseId;
	}
	public String getHopitalId() {
		return hopitalId;
	}
	public void setHopitalId(String hopitalId) {
		this.hopitalId = hopitalId;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	
	
}
