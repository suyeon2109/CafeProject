package com.controller;

import java.util.ArrayList;
import java.util.Scanner;

//import com.model.vo.AdditionalOption;
import com.model.vo.Drink;
import com.model.vo.Option;
import com.view.*;

public class CafeManager {
	Scanner sc = new Scanner(System.in);

	Option op = new Option();
	public static Drink[] drink = new Drink[10];
		
	public static int totalPrice = 0;	
	public static int totalCount = 0;
	
	public static ArrayList<Drink> dList = new ArrayList<Drink>();
	
	//�ʱ�ȭ���� ���� drink �迭 �ʱ�ȭ
	//Option�� �⺻������, ������ ����� ���� ����
	{
		drink[0] = new Drink("����������", 1000, op);
		drink[1] = new Drink("�Ƹ޸�ī��", 1500, op);
		drink[2] = new Drink("ī���", 2000, op);
		drink[3] = new Drink("īǪġ��", 2500, op);
		drink[4] = new Drink("��ü��", 3000, op);
		drink[5] = new Drink("ļ��Ḷ���ƶ�", 3500, op);

		drink[6] = new Drink("��׷���Ƽ", 4000, op);
		drink[7] = new Drink("�����ƮƼ", 4500, op);
		drink[8] = new Drink("�׸�Ƽ��", 5000, op);
		drink[9] = new Drink("����Ƽ��", 5500, op);

	}
	
	public ArrayList<Drink> getdList() {
		
		return dList;
	}

	public void setdList(ArrayList<Drink> dList) {
		this.dList = dList;
	}

	//������ �ɼ��� �����ؼ� īƮ�� �߰��ϴ� �޼���
	public void inputCart(int index) {		
		
		Drink select = new Drink();
		Option opt = new Option();
				
		select.setName(drink[index].getName());
		select.setPrice(OptionPanel.price + OptionPanel.addPrice + OptionPanel.op.getAdditionalprice()); //�����ؾ��Ұ� 
		
		select.setOp(opt);
		
		opt.setDeCaffeine(OptionPanel.op.isDeCaffeine());
		opt.setCream(OptionPanel.op.isCream());
		opt.setCnt(OptionPanel.op.getCnt());
		opt.setHot(OptionPanel.op.isHot());
		opt.setSoyMilk(OptionPanel.op.isSoyMilk());
		opt.setShot(OptionPanel.op.getShot());
		opt.setSize(OptionPanel.op.getSize());
		opt.setVanilla(OptionPanel.op.isVanilla());
		opt.setHazelnut(OptionPanel.op.isHazelnut());
		opt.setCaramel(OptionPanel.op.isCaramel());
		opt.setTake(OptionPanel.op.isTake());
		
		totalPrice += select.getPrice() * select.getOp().getCnt();		
		totalCount += select.getOp().getCnt();
		
		dList.add(select); //�ֹ� ����Ʈ�� �߰�		
	}
}
