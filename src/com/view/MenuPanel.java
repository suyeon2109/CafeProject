package com.view;

import com.controller.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//메뉴 창 설정 클래스
class MenuPanel extends JPanel {

	CafeManager c = new CafeManager();
	public static JButton[] drinkBtn = new JButton[6]; //메뉴 버튼 배열_ 한 페이지에 6개
	public static JLabel[] drinkLb = new JLabel[6];
		
	public static int index = 0;
	/////////////////////////////////////////////

	private MainFrame win;

	public MenuPanel() { }

	//tempStr에 coffeeStr 또는 nonCoffeeStr이 들어옴
	public MenuPanel(MainFrame win, String tempStr[]) { 
		this.win = win;
		setLayout(null);
		
		super.setBackground(new Color(151, 112, 103));
		
		JPanel whPan = new JPanel();
		whPan.setBounds(25,25,530,380);
		whPan.setBackground(new Color(248,248,248));
		whPan.setLayout(null);
		add(whPan);
		
		for(int i = 0; i < tempStr.length; i++) {

			int j = i; //현재 인덱스 번호를 j에 저장

			drinkBtn[i] = new JButton();
			drinkBtn[i].setName(tempStr[i]); //버튼의 이름을 음료명으로 설정
			
			drinkLb[i] = new JLabel(tempStr[i]);
			drinkLb[i].setHorizontalAlignment(SwingConstants.CENTER);
			drinkLb[i].setFont(new Font("맑은고딕", Font.BOLD, 14));
			
			
			//(사진의 이름)과 (버튼의 이름)이 같을 경우 그 이미지로 버튼의 아이콘을 설정 
			if(tempStr[i].equals(drinkBtn[i].getName())) { //drinkBtn[i]의 텍스트와 tempStr[i]의 텍스트가 같으면
				ImageIcon imgIcon = new ImageIcon("pic/" + tempStr[i] + ".PNG"); // 이미지아이콘에 저장

				//이미지를 버튼 크기에 맞게 조정
				Image originImg = imgIcon.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장 

				//새로운 이미지 변수에 사이즈 변경한 이미지 저장
				Image changedImg= originImg.getScaledInstance(120, 120, Image.SCALE_SMOOTH ); 
				ImageIcon icon = new ImageIcon(changedImg);

				drinkBtn[i].setIcon(icon); //icon으로 버튼의 이미지 설정
			}			
			
			if (i < 3) {
				drinkBtn[i].setBounds(25 + i * 180, 30, 120, 120); //버튼의 위치 (왼쪽, 위, 가로길이, 세로길이)
				drinkLb[i].setBounds(25 + i * 180, 160, 120, 15);
				//drinkLb[i].setFont(new Font("맑은고딕", Font.BOLD, 14));
			} else {
				drinkBtn[i].setBounds(25 + (i - 3) * 180, 200, 120, 120);
				drinkLb[i].setBounds(25 + (i - 3) * 180, 330, 120, 15);
				//drinkLb[i].setFont(new Font("맑은고딕", Font.BOLD, 14));
			}

			//메뉴 이미지 버튼 클릭시 발생 이벤트
			drinkBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {				
					index = j;  // 현재 인덱스를 index변수에 저장
					
					System.out.println("index: " + index);
					win.change("option"); //option창으로 변경
				}
			});
			
			whPan.add(drinkBtn[i]);
			whPan.add(drinkLb[i]);
		}	

	}
}
