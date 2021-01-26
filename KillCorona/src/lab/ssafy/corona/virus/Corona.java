package lab.ssafy.corona.virus;

public class Corona extends Virus{
	private int spreadSpeed;
	//private String name;
	public int getSpreadSpeed() {
		return spreadSpeed;
	}

	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}
	
	public void showInfo() {
		String info = super.getName()+" "+super.getLevel() + " " + this.spreadSpeed;
		System.out.println(info);
	}
	
	public Corona() { // 여기에 부모 클래스 생성자를 명시적으로 호출하지 않고 부모 클래스의 기본생성자가 없으면 오류
//		super("",0); // 이렇게 명시적으로 부모 클래스의 생성자를 호출하면 오류가 사라짐
	}
	
	public Corona(String name, int level, int spreadSpeed) {
//		super.setName(name);
//		super.setLevel(level);
		super(name,level);
		this.spreadSpeed = spreadSpeed;
	}
	
	public String toString() {
		return super.getName()+" "+ super.getLevel()+ " "+ this.spreadSpeed;
	}
}
