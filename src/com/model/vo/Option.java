package com.model.vo;

import java.util.Arrays;

/*������ �ɼ��� �����ϴ� Ŭ����*/
public class Option {
	private boolean hot = true; //��/���̽�
	private String size = "Small"; //������(����, ���ַ�, ����) -> ��������� +500��
	private int cnt = 1; //����
	private boolean take = true; 
	
	/*additional option*/
	private boolean deCaffeine = false; //ī����, ��ī����
	private boolean vanilla = false; //�ٴҶ�
	private boolean hazelnut = false; // �������
	private boolean caramel = false; // ļ���
	private int shot = 0; //�� �߰�
	private boolean soyMilk = false; 
	private boolean cream = false; //���� ����
	private String addmemo; //�߰��ֹ�����
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
