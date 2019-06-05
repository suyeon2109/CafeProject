package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.model.vo.Drink;
import com.model.vo.Option;


/* 여러개의 패널을 생성해 하나의 프레임 위에 필요한 패널을 호출하는 방법으로 작성!! */

public class MainFrame extends JFrame {

	public static MenuPanel coffeeMenu = null;
	public MenuPanel nonCoffeeMenu = null;
	public OptionPanel option = null;
	public CartPanel cart = null;

	static JTabbedPane jtab = new JTabbedPane();
	static JLabel logoLb = new JLabel();
	static JLabel logoTextLb = new JLabel();
	static JPanel pan = new JPanel();

	public static String[] coffeeStr = new String[]{"에스프레소", "아메리카노", "카페라떼", "카푸치노", "돌체라떼", "캬라멜마끼아또"}; //메뉴 이름 저장 배열
	public static String[] nonCoffeeStr = new String[]{"얼그레이티", "레몬민트티", "그린티라떼", "차이티라떼"};

	public static int isNon = 0;

	public static JLabel memNameLb = new JLabel("[ " + Login.selectName + " ] 님");
	//public static JLabel memNameLb = new JLabel("[ hello" + " ] 님");
	
	public MainFrame() {

	}

	//패널 창 변경 메소드
	public void change(String panelName) {	

		getJtabIndex();

		if(panelName.equals("coffeeMenu")) {

			getContentPane().removeAll(); // 모든 패널 삭제
			getContentPane().add(jtab);
	
			ImageIcon imgIcon = new ImageIcon("pic/logo.png"); // 이미지아이콘에 저장
			Image originImg = imgIcon.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장
			Image changedImg= originImg.getScaledInstance(85, 85, Image.SCALE_SMOOTH ); 
			ImageIcon icon = new ImageIcon(changedImg);

			logoLb.setBounds(160, 5, 85, 85);
			logoLb.setIcon(icon); //icon으로 버튼
			add(logoLb);

			ImageIcon imgIcon2 = new ImageIcon("pic/logoText.png"); // 이미지아이콘에 저장
			Image originImg2 = imgIcon2.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장 
			Image changedImg2 = originImg2.getScaledInstance(180, 60, Image.SCALE_SMOOTH ); 
			ImageIcon icon2 = new ImageIcon(changedImg2);

			logoTextLb.setBounds(235, 25, 180, 60);
			logoTextLb.setIcon(icon2); //icon으로 버튼
			add(logoTextLb);
			
			//회원 이름을 출력하는 라벨
			memNameLb.setBounds(460, 80, 100, 30);
			memNameLb.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			add(memNameLb);
			
			JLabel what = new JLabel(); //무엇?
			add(what);

			getContentPane().setBackground(Color.WHITE);	

			jtab.setSelectedIndex(0);
			getJtabIndex();

			revalidate();	
			repaint();

		} else if(panelName.equals("option")){
			getContentPane().removeAll(); // 모든 패널 삭제
			getContentPane().add(option);

			option.getSelectedImage(isNon); //옵션패널에서 선택한 음료로 사진, 이름, 가격 설정해주는 메소드 호출

			revalidate();
			repaint();

		} else if(panelName.equals("cart")) {

			CartPanel.printPrice();

			getContentPane().removeAll(); // 모든 패널 삭제
			getContentPane().add(cart);
			revalidate();
			repaint();
		}
	}

	//로그인에 성공할 경우 호출
	public static void afterLogin() {

		MainFrame win = new MainFrame();
		
		 
		//logoLb.setBounds(250, 5, 90, 90); //텍스트가 끝, 로고가 가운데
		
		ImageIcon logoIcon = new ImageIcon("pic/logo.png"); // 이미지아이콘에 저장

		//이미지를 버튼 크기에 맞게 조정
		Image originImg = logoIcon.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장 

		//새로운 이미지 변수에 사이즈 변경한 이미지 저장
		Image changedImg= originImg.getScaledInstance(85, 85, Image.SCALE_SMOOTH ); 
		ImageIcon icon = new ImageIcon(changedImg);

		logoLb.setBounds(160, 5, 85, 85);
		logoLb.setIcon(icon); //icon으로 버튼
		win.add(logoLb);
		
		ImageIcon imgIcon2 = new ImageIcon("pic/logoText.png"); // 이미지아이콘에 저장

		//이미지를 버튼 크기에 맞게 조정
		Image originImg2 = imgIcon2.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장 

		//새로운 이미지 변수에 사이즈 변경한 이미지 저장
		Image changedImg2 = originImg2.getScaledInstance(180, 60, Image.SCALE_SMOOTH ); 
		ImageIcon icon2 = new ImageIcon(changedImg2);

		logoTextLb.setBounds(235, 25, 180, 60);
		logoTextLb.setIcon(icon2); //icon으로 버튼
		win.add(logoTextLb);

		memNameLb.setBounds(460, 80, 100, 30);
		memNameLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		win.add(memNameLb);

		win.getContentPane().setBackground(Color.WHITE);	


		//실행시 프레임이 화면의 가운데 뜨게
		Dimension frameSize = win.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		win.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);


		win.setTitle("Coffee G4;");
		win.coffeeMenu = new MenuPanel(win, coffeeStr);
		win.nonCoffeeMenu = new MenuPanel(win, nonCoffeeStr);
		win.option = new OptionPanel(win, coffeeStr);
		win.cart = new CartPanel(win);

		win.getContentPane().add(jtab);

		jtab.addTab("COFFEE", win.coffeeMenu);
		jtab.addTab("NONCOFFEE", win.nonCoffeeMenu);
		jtab.setBorder(BorderFactory.createEmptyBorder(100 , 0 , 0 , 0)); //탭을 아래로 내리기!

		getJtabIndex();

		win.setSize(600, 600);
		win.setVisible(true);
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setLocationRelativeTo(null); 
	}

	//선택한 탭의 인덱스에 따라 isNon을 설정해줌
	public static void getJtabIndex() {

		if(jtab.getSelectedIndex() == 0)
			isNon = 0;
		else
			isNon = 6;
	}

}
