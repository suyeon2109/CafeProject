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
	
	//초기화블럭을 통해 drink 배열 초기화
	//Option은 기본값으로, 각각의 음료와 가격 저장
	{
		drink[0] = new Drink("에스프레소", 1000, op);
		drink[1] = new Drink("아메리카노", 1500, op);
		drink[2] = new Drink("카페라떼", 2000, op);
		drink[3] = new Drink("카푸치노", 2500, op);
		drink[4] = new Drink("돌체라떼", 3000, op);
		drink[5] = new Drink("캬라멜마끼아또", 3500, op);

		drink[6] = new Drink("얼그레이티", 4000, op);
		drink[7] = new Drink("레몬민트티", 4500, op);
		drink[8] = new Drink("그린티라떼", 5000, op);
		drink[9] = new Drink("차이티라떼", 5500, op);

	}
	
	public ArrayList<Drink> getdList() {
		
		return dList;
	}

	public void setdList(ArrayList<Drink> dList) {
		this.dList = dList;
	}

	//선택한 옵션을 저장해서 카트에 추가하는 메서드
	public void inputCart(int index) {		
		
		Drink select = new Drink();
		Option opt = new Option();
				
		select.setName(drink[index].getName());
		select.setPrice(OptionPanel.price + OptionPanel.addPrice + OptionPanel.op.getAdditionalprice()); //수정해야할것 
		
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
		
		dList.add(select); //주문 리스트에 추가		
	}
}
