package com.model.vo;

/*회원 정보*/
public class Member {
	private String name; //이름
	private String id; //아이디 
	private String password; //비밀번호
	private String pNum; //핸드폰 번호 
	private String no;
	
	//private Cart myCart[] = new Cart[10];
	
	/*생성자*/
	public Member() {}
	
	public Member(String name, String id, String password, String pNum, String no) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.pNum = pNum;
		this.no = no;
	}

	/*getter & setter*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	/*toString()*/
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", password=" + password + ", pNum=" + pNum + "]";
	}
	
}
