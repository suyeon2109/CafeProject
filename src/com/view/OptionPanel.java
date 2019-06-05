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

//�ɼǺ� â ���� Ŭ����
public class OptionPanel extends JPanel {

	private MainFrame win;
	JPanel p = new JPanel();

	AddOptionFrame ad = new AddOptionFrame(); //�߰��ɼ� ������ ����

	CafeManager c = new CafeManager();   
	public static Option op = new Option();  //������ ������ �ɼǰ����� ������ ����

	public static int totalPrice = 0;
	public static JLabel lbDrinkPic = new JLabel(); //���� ������ ��� ��
	public static JLabel lbDrinkName = new JLabel();
	public static JLabel lbDrinkPrice = new JLabel();
	public static JLabel logoLb = new JLabel();
	public static JLabel logoTextLb = new JLabel();
	public static int count = 1;

	JButton leftHot = new JButton("HOT"); //HOT ��ư
	JButton rightIce = new JButton("ICED"); //ICE ��ư
	JButton btnTakeIn = new JButton("����");
	JButton btnTakeOut = new JButton("����");

	public JLabel lblCount = new JLabel("1"); //���� ������ ��

	public String [] size = {"Small","Regular","Large"}; //�޺��ڽ��� �� ���ð� �迭
	public JComboBox sizeList = new JComboBox(size);

	public static int price = 0; //  Ŀ�� �ݾ� ����
	public static int addPrice = 0;
	public static int printPrice = 0;
	int index = 0; //MenuPanel���� ������ ������ index�� ����

	public OptionPanel() { };

	public OptionPanel(MainFrame win, String tempStr[]) {            

		this.win = win;
		setLayout(null);

		add(p); 
		super.setBackground(new Color(151,112,103));
		p.setBounds(25,25,540,516);
		p.setBackground(new Color(248,248,248));
		p.setLayout(null);      

		ImageIcon imgIcon = new ImageIcon("pic/logo.png"); // �̹��������ܿ� ����

		//�̹����� ��ư ũ�⿡ �°� ����
		Image originImg = imgIcon.getImage(); // �̹����������� �̹����� �̹��� ������ ���� 

		//���ο� �̹��� ������ ������ ������ �̹��� ����
		Image changedImg= originImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH ); 
		ImageIcon icon = new ImageIcon(changedImg);

		logoLb.setBounds(15, 15, 60, 60);
		logoLb.setIcon(icon); //icon���� ��ư
		p.add(logoLb);

		ImageIcon imgIcon2 = new ImageIcon("pic/logoText.png"); // �̹��������ܿ� ����

		//�̹����� ��ư ũ�⿡ �°� ����
		Image originImg2 = imgIcon2.getImage(); // �̹����������� �̹����� �̹��� ������ ���� 

		//���ο� �̹��� ������ ������ ������ �̹��� ����
		Image changedImg2 = originImg2.getScaledInstance(150, 60, Image.SCALE_SMOOTH ); 
		ImageIcon icon2 = new ImageIcon(changedImg2);

		logoTextLb.setBounds(75, 15, 150, 60);
		logoTextLb.setIcon(icon2); //icon���� ��ư
		p.add(logoTextLb);

		//Hot��ư
		leftHot.setBounds(90, 280, 170, 40);
		leftHot.setFont(new Font("�������", Font.BOLD, 14));

		//leftHot ��ư �׼�
		leftHot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Hot ��ư Ŭ���� �߻�
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

		//Ice ��ư
		rightIce.setBounds(270, 280, 170, 40);
		rightIce.setFont(new Font("�������", Font.BOLD, 14));

		//rightIce ��ư �׼�
		rightIce.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //Ice ��ư Ŭ���� �߻�
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

		//takeIn / takeOut ��ư ����      
		btnTakeIn.setBounds(270, 380, 170, 40);
		btnTakeIn.setFont(new Font("���� ���", Font.BOLD, 14));
		btnTakeIn.setBackground(Color.white);
		btnTakeIn.setForeground(Color.black);

		btnTakeOut.setBounds(90, 380, 170, 40);
		btnTakeOut.setFont(new Font("���� ���", Font.BOLD, 14));
		btnTakeOut.setBackground(new Color(214,211,204));
		btnTakeOut.setForeground(new Color(117,110,104));

		//takeIn ��ư �׼�
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

		//takeOut ��ư �׼�
		btnTakeOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTakeOut.setBackground(new Color(214,211,204));
				btnTakeOut.setForeground(new Color(117,110,104));
				btnTakeIn.setBackground(Color.white);
				btnTakeIn.setForeground(Color.BLACK);
				op.setTake(true);
			}
		});

		//AddOption ��ư �׼� _ AddOptionFrame ����
		JButton btnAddOption = new JButton("�߰��ɼ� ����");
		btnAddOption.setBounds(90, 330, 350, 40); //�߰��ɼ�â���� ����Ǵ� ��ư�� ��ġ
		btnAddOption.setFont(new Font("���� ���", Font.BOLD, 14));
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

		//�޺��ڽ� �׼� �߰�
		sizeList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox)e.getSource();

				String selectedSize = (String)box.getSelectedItem();
				op.setSize(selectedSize);

				if(selectedSize.equals("Regular")) {
					addPrice = 500;
					printPrice = (price + addPrice + op.getAdditionalprice()) * count ;
					lbDrinkPrice.setText(printPrice + " ��");

				}else if(selectedSize.equals("Large")){
					addPrice = 1000;
					printPrice = (price + addPrice + op.getAdditionalprice()) * count ;
					lbDrinkPrice.setText(printPrice + " ��");

				}else if(selectedSize.equals("Small")){
					addPrice = 0;
					//printPrice = (price + addPrice ) * count + op.getAdditionalprice();
					printPrice = (price + addPrice + op.getAdditionalprice()) * count ;
					lbDrinkPrice.setText(printPrice + " ��");
				}
			}
		});

		//���� �� ����
		lblCount.setBounds(346, 174, 25, 35);
		lblCount.setFont(new Font("���� ���", Font.BOLD, 16));
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);

		//���� -��ư ����
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(290, 175, 45, 35);
		btnMinus.setBackground(new Color(151,112,103));
		btnMinus.setForeground(new Color(248,248,248));
		btnMinus.setFont(new Font("���� ���", Font.BOLD, 15));

		//����-��ư �׼�
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMinus) {
					if(count > 1) {
						count--;
						printPrice = (op.getAdditionalprice() + price + addPrice ) * count;

						lbDrinkPrice.setText(printPrice + " ��");
						op.setCnt(count);
						lblCount.setText(count + "");
					} 
				}
			}
		});

		//���� +��ư ����
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(380, 175, 45, 35);
		btnPlus.setBackground(new Color(151,112,103));
		btnPlus.setForeground(new Color(248,248,248));
		btnPlus.setFont(new Font("���� ���", Font.BOLD, 15));

		//���� +��ư �׼�
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnPlus) {
					if(count <10) {
						if((count+c.totalCount)<10) {
							count++;
							printPrice = (op.getAdditionalprice() + price + addPrice ) * count;
							lbDrinkPrice.setText(printPrice + " ��");
							op.setCnt(count);
							lblCount.setText(count + "");
						} else {
							JOptionPane aa = new JOptionPane();
							aa.showMessageDialog(null, "�ִ� 10�ܱ��� �ֹ� �����մϴ�.");
							UIManager.put(aa, new Font("�������", Font.BOLD, 13));
						}

					} else if(count ==10) {
						JOptionPane aa = new JOptionPane();
						aa.showMessageDialog(null, "�ִ� 10�ܱ��� �ֹ� �����մϴ�.");
						UIManager.put(aa, new Font("�������", Font.BOLD, 13));

					}
				}
			}
		});

		//[�޴��� ���ư���] ��ư_��ٱ��� �߰� ���� �޴��� ���ư��� ��ư
		JButton btnMenuBack = new JButton("�޴��� ���ư���");
		btnMenuBack.setBounds(90, 430, 170, 40);   
		btnMenuBack.setBorder(new LineBorder(new Color(151,112,103), 2, true));
		btnMenuBack.setForeground(new Color(248,248,248));
		btnMenuBack.setFont(new Font("���� ���", Font.BOLD, 14));
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

		///��ٱ��� �߰� ��ư_����
		JButton btnAddCart = new JButton("���");
		btnAddCart.setFont(new Font("���� ���", Font.BOLD, 14));
		btnAddCart.setBounds(270, 430, 170, 40);
		btnAddCart.setBorder(new LineBorder(new Color(151,112,103), 2, true));
		btnAddCart.setForeground(new Color(248,248,248));
		btnAddCart.setBackground(new Color(151,112,103));

		p.add(btnAddCart);
		btnAddCart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// ��ٱ��Ͽ� �߰� ��ư Ŭ���� �˾�â

				if(count+c.totalCount>10) {
					JOptionPane aa = new JOptionPane();
					aa.showMessageDialog(null, "�ִ� 10�ܱ��� �ֹ� �����մϴ�.");
					UIManager.put(aa, new Font("�������", Font.BOLD, 13));

					win.change("cart");
					resetOption();

				} else {
					temp(); //������ �޴��� īƮ�� �ֱ�

					int result = JOptionPane.showConfirmDialog(null, "��ٱ��Ͽ� �߰��Ǿ����ϴ�! \n��ٱ��Ϸ� �̵��Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);

					if(result == JOptionPane.CLOSED_OPTION) { //�˾�â �ݱ⸦ ������ ���������ʰ� coffeeMenu �гη� �̵�
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

		//�гο� ��ư�� �󺧵� �߰��ϱ�
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

	//����� ������ �̸��� ������ �󺧿� �������� �޼ҵ�
	public void getSelectedImage(int isNon) {

		index = MenuPanel.index + isNon; //������ ������ MenuPanel.drink �迭�� index�� ����
		String selectDrName = CafeManager.drink[index].getName();
		int selectDrPrice = CafeManager.drink[index].getPrice();

		//URL imgURL = this.getClass().getResource("./pic/" + selectDrName + ".PNG"); //pic������ dirnkStr[i].PNG ������ URL�� ������
		ImageIcon imgIcon = new ImageIcon("pic/" + selectDrName + ".PNG"); // �̹��������ܿ� ����

		//�̹����� ��ư ũ�⿡ �°� ����
		Image originImg = imgIcon.getImage(); // �̹����������� �̹����� �̹��� ������ ���� 

		//���ο� �̹��� ������ ������ ������ �̹��� ����
		Image changedImg= originImg.getScaledInstance(170, 170, Image.SCALE_SMOOTH ); 
		ImageIcon icon = new ImageIcon(changedImg);

		lbDrinkPic.setBounds(90, 85, 170, 170);
		lbDrinkPic.setIcon(icon);
		p.add(lbDrinkPic);

		//���� �̸����� ���� �ؽ�Ʈ ����
		lbDrinkName.setBounds(290, 80, 170, 40);
		lbDrinkName.setFont(new Font("���� ���", Font.BOLD, 15));
		lbDrinkName.setText(selectDrName);
		System.out.println("selectDrName: " + selectDrName);
		p.add(lbDrinkName);

		//Ŀ�� �ݾ��� ����� ��
		lbDrinkPrice.setBounds(290, 120, 170, 40);
		lbDrinkPrice.setFont(new Font("���� ���", Font.BOLD, 15));
		lbDrinkPrice.setText(selectDrPrice + " ��");
		System.out.println("selectDrPrice: " + selectDrPrice);
		p.add(lbDrinkPrice);

		price = selectDrPrice; //price������ ������ ������ �⺻ ���� ����
	}

	//inputCart ���� �� ����Ʈ �� ��� Ȯ�ο�
	public void temp() {
		c.inputCart(index); //index���� �޾Ƽ� inputCart�� ����

		for(int i = 0; i < c.dList.size(); i++) {
			System.out.println(c.dList.get(i));
		}
	}

	//�ɼ��� �ʱⰪ���� �������ִ� �޼���
	public void resetOption() {
		//this.op = op;

		lblCount.setText("1");
		count = 1;
		op.setCnt(1);
		sizeList.setSelectedIndex(0); //����� small�� �缳��

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

		//additionalOption�� �ʱ�ȭ
		op.setDeCaffeine(false);
		op.setCaramel(false);
		op.setCream(false);
		op.setHazelnut(false);
		op.setSoyMilk(false);
		op.setVanilla(false);
		op.setShot(0);
		op.setAdditionalprice(0);
	}

	//�߰��ɼ�â üũ�ڽ� ����
	public void setCheckFalse(Option op) {

		System.out.println("setCheckFalse�� op: " + op.toString());

		if(op.isDeCaffeine())  //DeCaffeine�� true�̸� üũ�ڽ��� true�� ����
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

