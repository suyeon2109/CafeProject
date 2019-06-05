package com.view;

import com.controller.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.model.vo.Drink;
import com.model.vo.Option;

//옵션뷰 창 설정 클래스
public class OptionPanel extends JPanel {

	private MainFrame win;
	JPanel p = new JPanel();

	AddOptionFrame ad = new AddOptionFrame(); //추가옵션 프레임 띄우기

	CafeManager c = new CafeManager();   
	public static Option op = new Option();  //선택한 음료의 옵션값들을 저장할 변수

	public static int totalPrice = 0;
	public static JLabel lbDrinkPic = new JLabel(); //음료 사진을 띄울 라벨
	public static JLabel lbDrinkName = new JLabel();
	public static JLabel lbDrinkPrice = new JLabel();
	public static JLabel logoLb = new JLabel();
	public static JLabel logoTextLb = new JLabel();
	public static int count = 1;

	JButton leftHot = new JButton("HOT"); //HOT 버튼
	JButton rightIce = new JButton("ICED"); //ICE 버튼
	JButton btnTakeIn = new JButton("매장");
	JButton btnTakeOut = new JButton("포장");

	public JLabel lblCount = new JLabel("1"); //수량 저장할 라벨

	public String [] size = {"Small","Regular","Large"}; //콤보박스에 들어갈 선택값 배열
	public JComboBox sizeList = new JComboBox(size);

	public static int price = 0; //  커피 금액 변수
	public static int addPrice = 0;
	public static int printPrice = 0;
	int index = 0; //MenuPanel에서 선택한 음료의 index를 저장

	public OptionPanel() { };

	public OptionPanel(MainFrame win, String tempStr[]) {            

		this.win = win;
		setLayout(null);

		add(p); 
		super.setBackground(new Color(151,112,103));
		p.setBounds(25,25,540,516);
		p.setBackground(new Color(248,248,248));
		p.setLayout(null);      

		ImageIcon imgIcon = new ImageIcon("pic/logo.png"); // 이미지아이콘에 저장

		//이미지를 버튼 크기에 맞게 조정
		Image originImg = imgIcon.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장 

		//새로운 이미지 변수에 사이즈 변경한 이미지 저장
		Image changedImg= originImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH ); 
		ImageIcon icon = new ImageIcon(changedImg);

		logoLb.setBounds(15, 15, 60, 60);
		logoLb.setIcon(icon); //icon으로 버튼
		p.add(logoLb);

		ImageIcon imgIcon2 = new ImageIcon("pic/logoText.png"); // 이미지아이콘에 저장

		//이미지를 버튼 크기에 맞게 조정
		Image originImg2 = imgIcon2.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장 

		//새로운 이미지 변수에 사이즈 변경한 이미지 저장
		Image changedImg2 = originImg2.getScaledInstance(150, 60, Image.SCALE_SMOOTH ); 
		ImageIcon icon2 = new ImageIcon(changedImg2);

		logoTextLb.setBounds(75, 15, 150, 60);
		logoTextLb.setIcon(icon2); //icon으로 버튼
		p.add(logoTextLb);

		//Hot버튼
		leftHot.setBounds(90, 280, 170, 40);
		leftHot.setFont(new Font("맑은고딕", Font.BOLD, 14));

		//leftHot 버튼 액션
		leftHot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Hot 버튼 클릭시 발생
				leftHot.setBackground(new Color(205, 92, 92));
				rightIce.setBackground(Color.WHITE);
				rightIce.setForeground(new Color(100, 149, 237));
				leftHot.setForeground(Color.WHITE);
				op.setHot(true);
			}
		});

		leftHot.setBackground(new Color(205, 92, 92));
		leftHot.setForeground(Color.WHITE);
		leftHot.setBorder(new LineBorder(new Color(205, 92, 92), 2, true));

		//Ice 버튼
		rightIce.setBounds(270, 280, 170, 40);
		rightIce.setFont(new Font("맑은고딕", Font.BOLD, 14));

		//rightIce 버튼 액션
		rightIce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Ice 버튼 클릭시 발생
				rightIce.setBackground(new Color(100, 149, 237));
				leftHot.setBackground(Color.WHITE);
				leftHot.setForeground(new Color(205, 92, 92));
				rightIce.setForeground(Color.WHITE);
				op.setHot(false);
			}
		});

		rightIce.setBackground(Color.WHITE);
		rightIce.setForeground(new Color(100, 149, 237));
		rightIce.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));

		//takeIn / takeOut 버튼 생성      
		btnTakeIn.setBounds(270, 380, 170, 40);
		btnTakeIn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnTakeIn.setBackground(Color.white);
		btnTakeIn.setForeground(Color.black);

		btnTakeOut.setBounds(90, 380, 170, 40);
		btnTakeOut.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnTakeOut.setBackground(new Color(214,211,204));
		btnTakeOut.setForeground(new Color(117,110,104));

		//takeIn 버튼 액션
		btnTakeIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnTakeIn) {
					btnTakeIn.setBackground(new Color(214,211,204));
					btnTakeIn.setForeground(new Color(117,110,104));
					btnTakeOut.setBackground(Color.white);
				}else {
					btnTakeIn.setBackground(new Color(214,211,204));
					btnTakeIn.setForeground(new Color(117,110,104));
				}
				btnTakeOut.setForeground(Color.BLACK);
				op.setTake(false);
			}
		});

		//takeOut 버튼 액션
		btnTakeOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTakeOut.setBackground(new Color(214,211,204));
				btnTakeOut.setForeground(new Color(117,110,104));
				btnTakeIn.setBackground(Color.white);
				btnTakeIn.setForeground(Color.BLACK);
				op.setTake(true);
			}
		});

		//AddOption 버튼 액션 _ AddOptionFrame 띄우기
		JButton btnAddOption = new JButton("추가옵션 선택");
		btnAddOption.setBounds(90, 330, 350, 40); //추가옵션창으로 연결되는 버튼의 위치
		btnAddOption.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnAddOption.setForeground(new Color(248,248,248));
		btnAddOption.setBackground(new Color(151,112,103));
		btnAddOption.setBorder(new LineBorder(new Color(151,112,103), 2, true));

		btnAddOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AddOptionFrame ado = new AddOptionFrame(op);
				setCheckFalse(op);

				System.out.println(op.toString());
			}
		});

		sizeList.setBounds(290, 221, 135, 35);      
		sizeList.setBackground(Color.WHITE);
		sizeList.setSelectedIndex(0);

		//콤보박스 액션 추가
		sizeList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox)e.getSource();

				String selectedSize = (String)box.getSelectedItem();
				op.setSize(selectedSize);

				if(selectedSize.equals("Regular")) {
					addPrice = 500;
					printPrice = (price + addPrice + op.getAdditionalprice()) * count ;
					lbDrinkPrice.setText(printPrice + " 원");

				}else if(selectedSize.equals("Large")){
					addPrice = 1000;
					printPrice = (price + addPrice + op.getAdditionalprice()) * count ;
					lbDrinkPrice.setText(printPrice + " 원");

				}else if(selectedSize.equals("Small")){
					addPrice = 0;
					//printPrice = (price + addPrice ) * count + op.getAdditionalprice();
					printPrice = (price + addPrice + op.getAdditionalprice()) * count ;
					lbDrinkPrice.setText(printPrice + " 원");
				}
			}
		});

		//수량 라벨 생성
		lblCount.setBounds(346, 174, 25, 35);
		lblCount.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);

		//수량 -버튼 생성
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(290, 175, 45, 35);
		btnMinus.setBackground(new Color(151,112,103));
		btnMinus.setForeground(new Color(248,248,248));
		btnMinus.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		//수량-버튼 액션
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMinus) {
					if(count > 1) {
						count--;
						printPrice = (op.getAdditionalprice() + price + addPrice ) * count;

						lbDrinkPrice.setText(printPrice + " 원");
						op.setCnt(count);
						lblCount.setText(count + "");
					} 
				}
			}
		});

		//수량 +버튼 생성
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(380, 175, 45, 35);
		btnPlus.setBackground(new Color(151,112,103));
		btnPlus.setForeground(new Color(248,248,248));
		btnPlus.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		//수량 +버튼 액션
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnPlus) {
					if(count <10) {
						if((count+c.totalCount)<10) {
							count++;
							printPrice = (op.getAdditionalprice() + price + addPrice ) * count;
							lbDrinkPrice.setText(printPrice + " 원");
							op.setCnt(count);
							lblCount.setText(count + "");
						} else {
							JOptionPane aa = new JOptionPane();
							aa.showMessageDialog(null, "최대 10잔까지 주문 가능합니다.");
							UIManager.put(aa, new Font("맑은고딕", Font.BOLD, 13));
						}

					} else if(count ==10) {
						JOptionPane aa = new JOptionPane();
						aa.showMessageDialog(null, "최대 10잔까지 주문 가능합니다.");
						UIManager.put(aa, new Font("맑은고딕", Font.BOLD, 13));

					}
				}
			}
		});

		//[메뉴로 돌아가기] 버튼_장바구니 추가 없이 메뉴로 돌아가는 버튼
		JButton btnMenuBack = new JButton("메뉴로 돌아가기");
		btnMenuBack.setBounds(90, 430, 170, 40);   
		btnMenuBack.setBorder(new LineBorder(new Color(151,112,103), 2, true));
		btnMenuBack.setForeground(new Color(248,248,248));
		btnMenuBack.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnMenuBack.setBackground(new Color(151,112,103));

		btnMenuBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMenuBack) {

					win.change("coffeeMenu");
					resetOption();   
					setCheckFalse(op);
					//AddOptionFrame.price = 0;
				}
			}
		});   

		///장바구니 추가 버튼_지은
		JButton btnAddCart = new JButton("담기");
		btnAddCart.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnAddCart.setBounds(270, 430, 170, 40);
		btnAddCart.setBorder(new LineBorder(new Color(151,112,103), 2, true));
		btnAddCart.setForeground(new Color(248,248,248));
		btnAddCart.setBackground(new Color(151,112,103));

		p.add(btnAddCart);
		btnAddCart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// 장바구니에 추가 버튼 클릭시 팝업창

				if(count+c.totalCount>10) {
					JOptionPane aa = new JOptionPane();
					aa.showMessageDialog(null, "최대 10잔까지 주문 가능합니다.");
					UIManager.put(aa, new Font("맑은고딕", Font.BOLD, 13));

					win.change("cart");
					resetOption();

				} else {
					temp(); //선택한 메뉴를 카트에 넣기

					int result = JOptionPane.showConfirmDialog(null, "장바구니에 추가되었습니다! \n장바구니로 이동하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);

					if(result == JOptionPane.CLOSED_OPTION) { //팝업창 닫기를 누르면 저장하지않고 coffeeMenu 패널로 이동
						win.change("coffeeMenu");
						resetOption();

					} else if(result == JOptionPane.YES_OPTION) {
						win.change("cart");
						resetOption();

					} else {
						win.change("coffeeMenu");
						resetOption();

					}
				}
			}
		});

		//패널에 버튼과 라벨들 추가하기
		p.add(leftHot);
		p.add(rightIce);
		p.add(btnAddOption);
		p.add(btnTakeIn);
		p.add(btnTakeOut);
		p.add(sizeList);
		p.add(btnMenuBack);
		p.add(lblCount);
		p.add(btnPlus);
		p.add(btnMinus);

	}

	//저장된 사진과 이름을 가져와 라벨에 저장해줄 메소드
	public void getSelectedImage(int isNon) {

		index = MenuPanel.index + isNon; //선택한 음료의 MenuPanel.drink 배열의 index를 저장
		String selectDrName = CafeManager.drink[index].getName();
		int selectDrPrice = CafeManager.drink[index].getPrice();

		//URL imgURL = this.getClass().getResource("./pic/" + selectDrName + ".PNG"); //pic폴더의 dirnkStr[i].PNG 파일의 URL을 가져옴
		ImageIcon imgIcon = new ImageIcon("pic/" + selectDrName + ".PNG"); // 이미지아이콘에 저장

		//이미지를 버튼 크기에 맞게 조정
		Image originImg = imgIcon.getImage(); // 이미지아이콘의 이미지를 이미지 변수에 저장 

		//새로운 이미지 변수에 사이즈 변경한 이미지 저장
		Image changedImg= originImg.getScaledInstance(170, 170, Image.SCALE_SMOOTH ); 
		ImageIcon icon = new ImageIcon(changedImg);

		lbDrinkPic.setBounds(90, 85, 170, 170);
		lbDrinkPic.setIcon(icon);
		p.add(lbDrinkPic);

		//음료 이름으로 라벨의 텍스트 변경
		lbDrinkName.setBounds(290, 80, 170, 40);
		lbDrinkName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbDrinkName.setText(selectDrName);
		System.out.println("selectDrName: " + selectDrName);
		p.add(lbDrinkName);

		//커피 금액을 출력할 라벨
		lbDrinkPrice.setBounds(290, 120, 170, 40);
		lbDrinkPrice.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lbDrinkPrice.setText(selectDrPrice + " 원");
		System.out.println("selectDrPrice: " + selectDrPrice);
		p.add(lbDrinkPrice);

		price = selectDrPrice; //price변수에 선택한 음료의 기본 가격 저장
	}

	//inputCart 해준 후 리스트 값 출력 확인용
	public void temp() {
		c.inputCart(index); //index값을 받아서 inputCart에 전달

		for(int i = 0; i < c.dList.size(); i++) {
			System.out.println(c.dList.get(i));
		}
	}

	//옵션을 초기값으로 리셋해주는 메서드
	public void resetOption() {
		//this.op = op;

		lblCount.setText("1");
		count = 1;
		op.setCnt(1);
		sizeList.setSelectedIndex(0); //사이즈를 small로 재설정

		leftHot.setBackground(new Color(205, 92, 92));
		leftHot.setForeground(Color.white);
		rightIce.setBackground(Color.WHITE);
		rightIce.setForeground(new Color(100, 149, 237));
		op.setHot(true);

		btnTakeIn.setBackground(Color.white);
		btnTakeIn.setForeground(Color.black);
		btnTakeOut.setBackground(new Color(214,211,204));
		btnTakeOut.setForeground(new Color(117,110,104));
		op.setTake(true);

		//additionalOption도 초기화
		op.setDeCaffeine(false);
		op.setCaramel(false);
		op.setCream(false);
		op.setHazelnut(false);
		op.setSoyMilk(false);
		op.setVanilla(false);
		op.setShot(0);
		op.setAdditionalprice(0);
	}

	//추가옵션창 체크박스 설정
	public void setCheckFalse(Option op) {

		System.out.println("setCheckFalse의 op: " + op.toString());

		if(op.isDeCaffeine())  //DeCaffeine이 true이면 체크박스도 true로 설정
			AddOptionFrame.boxes[0].setSelected(true);

		if(op.isVanilla())
			AddOptionFrame.boxes[1].setSelected(true);

		if(op.isHazelnut())
			AddOptionFrame.boxes[2].setSelected(true);

		if(op.isCaramel())
			AddOptionFrame.boxes[3].setSelected(true);

		if(op.isSoyMilk())
			AddOptionFrame.boxes[4].setSelected(true);

		if(op.isCream())
			AddOptionFrame.boxes[5].setSelected(true);	

//		if(op.getShot() == 1) {
//			ad.lb[2].setText("1");
//		}
//		
//		if(op.getShot() == 2) {
//			ad.lb[2].setText("2");
//		}
//		
//		if(op.getShot() == 3) {
//			ad.lb[2].setText("3");
//		}
//		
//		if(op.getShot() == 4) {
//			ad.lb[2].setText("4");
//		}
//		
//		if(op.getShot() == 5) {
//			ad.lb[2].setText("5");
//		}
	}

}

