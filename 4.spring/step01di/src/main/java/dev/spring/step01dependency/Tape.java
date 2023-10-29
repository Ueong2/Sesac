package dev.spring.step01dependency;

public class Tape {
	String name; // 테이프 이름
	boolean isWorked; // 정상동작 여부
	
	
	public Tape(String name, boolean isWorked) {
		super();
		this.name = name;
		this.isWorked = isWorked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isWorked() {
		return isWorked;
	}
	public void setWorked(boolean isWorked) {
		this.isWorked = isWorked;
	}

}
