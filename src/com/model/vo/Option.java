package com.model.vo;

import java.util.Arrays;

/*음료의 옵션을 저장하는 클래스*/
public class Option {
	private boolean hot = true; //핫/아이스
	private String size = "Small"; //사이즈(스몰, 레귤러, 라지) -> 사이즈업은 +500원
	private int cnt = 1; //수량
	private boolean take = true; 
	
	/*additional option*/
	private boolean deCaffeine = false; //카페인, 디카페인
	private boolean vanilla = false; //바닐라
	private boolean hazelnut = false; // 헤이즐넛
	private boolean caramel = false; // 캬라멜
	private int shot = 0; //샷 추가
	private boolean soyMilk = false; 
	private boolean cream = false; //휘핑 유무
	private String addmemo; //추가주문사항
	private int additionalprice;
	
	
	public Option() { }
	
	public Option(boolean hot, String size, int cnt, boolean take, boolean vanilla, boolean hazelnut, boolean caramel, int shot, boolean soyMilk, boolean cream) {
		super();
		this.hot = hot;
		this.size = size;
		this.cnt = cnt;
		this.take = take;
		this.vanilla = vanilla;
		this.hazelnut = hazelnut;
		this.caramel = caramel;
		this.shot = shot;
		this.soyMilk = soyMilk;
		this.cream = cream;
	}
	
	/*getter & setter*/
	public boolean isDeCaffeine() {
		return deCaffeine;
	}
	
	public void setDeCaffeine(boolean deCaffeine) {
		this.deCaffeine = deCaffeine;
	}
	public boolean isHot() {
		return hot;
	}
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public boolean isTake() {
		return take;
	}
	public void setTake(boolean take) {
		this.take = take;
	}
	
	public boolean isVanilla() {
		return vanilla;
	}

	public void setVanilla(boolean vanilla) {
		this.vanilla = vanilla;
	}

	public boolean isHazelnut() {
		return hazelnut;
	}

	public void setHazelnut(boolean hazelnut) {
		this.hazelnut = hazelnut;
	}

	public boolean isCaramel() {
		return caramel;
	}

	public void setCaramel(boolean caramel) {
		this.caramel = caramel;
	}

	
	public int getShot() {
		return shot;
	}
	public void setShot(int shot) {
		this.shot = shot;
	}
	public boolean isSoyMilk() {
		return soyMilk;
	}
	public void setSoyMilk(boolean soyMilk) {
		this.soyMilk = soyMilk;
	}
	public boolean isCream() {
		return cream;
	}
	public void setCream(boolean cream) {
		this.cream = cream;
	}
	
	public String getAddmemo() {
		return addmemo;
	}

	public void setAddmemo(String addmemo) {
		this.addmemo = addmemo;
	}
	
	public int getAdditionalprice() {
		return additionalprice;
	}

	public void setAdditionalprice(int additionalprice) {
		this.additionalprice = additionalprice;
	}

	@Override
	public String toString() {
		return "Option [hot=" + hot + ", size=" + size + ", cnt=" + cnt + ", take=" + take + ", deCaffeine=" + deCaffeine
				+ ", vanilla=" + vanilla + ", hazelnut=" + hazelnut + ", caramel=" + caramel + ", shot=" + shot
				+ ", soymilk=" + soyMilk + ", cream=" + cream + ", addmemo=" + addmemo + "]";
	}

	
	
}
