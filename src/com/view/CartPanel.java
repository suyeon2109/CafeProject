package com.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.controller.CafeManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;

//��ٱ��� �г�
class CartPanel extends JPanel {

	private MainFrame win;

	private static JCheckBox[] cb = new JCheckBox[10];
	private static JSeparator[] menuSe = new JSeparator[10];
	private static JSeparator[] priceSe = new JSeparator[10];
	private static JLabel cntLb;
	private static JLabel totalPriceLb;
	private static JLabel[] optionLb = new JLabel[10];
	private static JLabel[] priceLb = new JLabel[10];
	private static int total = CafeManager.totalPrice;
	private static int totalCnt = CafeManager.totalCount;

	
	public CartPanel(MainFrame win) {
		setLayout(null);
		this.win = win;

		super.setBackground(new Color(151, 112, 103));

		JLabel titleLb = new JLabel("�ֹ� �޴�");
		titleLb.setBounds(20, 10, 100, 25);
		titleLb.setFont(new Font("���� ���", Font.BOLD, 15));

		JPanel listPanel = new JPanel();
		listPanel.setLayout(null);
		listPanel.setBackground(Color.WHITE);
		listPanel.setBounds(20, 40, 540, 410);

		for(int i=0; i<10; i++) {
			cb[i] = new JCheckBox();
			cb[i].setBackground(Color.WHITE);
			cb[i].setFont(new Font("���� ���", Font.BOLD, 15));
			cb[i].setBounds(20, 8+i*40, 135, 30);

			menuSe[i] = new JSeparator();
			menuSe[i].setForeground(Color.LIGHT_GRAY);
			menuSe[i].setBounds(12, 40+i*40, 380, 30); //510

			optionLb[i] = new JLabel();
			optionLb[i].setBackground(Color.WHITE);
			optionLb[i].setFont(new Font("���� ���", Font.PLAIN, 13));
			optionLb[i].setBounds(220, 8+i*40, 135, 30);

			priceLb[i] = new JLabel();
			priceLb[i].setBackground(Color.WHITE);
			priceLb[i].setFont(new Font("���� ���", Font.BOLD, 14));
			priceLb[i].setBounds(430, 8+i*40, 135, 30);

			priceSe[i] = new JSeparator();
			priceSe[i].setForeground(Color.LIGHT_GRAY);
			priceSe[i].setBounds(410, 40+i*40, 110, 30); //510
		}

		JPanel pricePanel = new JPanel();
		pricePanel.setLayout(null);
		pricePanel.setBackground(Color.WHITE);
		pricePanel.setBounds(290, 460, 270, 40);

		JLabel totalLb = new JLabel("���� �����ݾ�");
		totalLb.setFont(new Font("���� ���", Font.BOLD, 13));
		totalLb.setBounds(15, 4, 130, 30);

		cntLb = new JLabel();
		cntLb.setFont(new Font("���� ���", Font.BOLD, 14));
		cntLb.setBackground(Color.white);
		cntLb.setBounds(217, 4, 80, 30);

		totalPriceLb = new JLabel();
		totalPriceLb.setFont(new Font("���� ���", Font.BOLD, 20));
		totalPriceLb.setBounds(125, 4, 80, 30);
		totalPriceLb.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton menuBt = new JButton("�޴��߰�");
		menuBt.setFont(new Font("���� ���", Font.BOLD, 13));
		menuBt.setForeground(Color.DARK_GRAY);
		menuBt.setBounds(170,515,100,25);
		menuBt.setBackground(new Color(234,234,234));
		menuBt.setBorder(null);

		JButton payBt = new JButton("�ֹ��ϱ�");
		payBt.setFont(new Font("���� ���", Font.BOLD, 13));
		payBt.setForeground(Color.DARK_GRAY);
		payBt.setBounds(290,515,100,25);
		payBt.setBackground(new Color(234,234,234));
		payBt.setBorder(null);

		for(int i=0; i<10; i++) {
			listPanel.add(cb[i]);
			listPanel.add(menuSe[i]);
			listPanel.add(optionLb[i]);
			listPanel.add(priceLb[i]);
			listPanel.add(priceSe[i]);
		}

		pricePanel.add(totalLb);
		pricePanel.add(totalPriceLb);
		pricePanel.add(cntLb);

		add(titleLb);
		add(listPanel);
		add(pricePanel);
		add(menuBt);
		add(payBt);

		for(int i=0; i<10; i++) {
			int count = i;
			cb[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {

					if(e.getStateChange()==ItemEvent.SELECTED) {
						total += CafeManager.dList.get(count).getPrice() * CafeManager.dList.get(count).getOp().getCnt();
						System.out.println("üũ�ڽ�+ total : " + total);
						totalPriceLb.setText(Integer.toString(total));

						totalCnt += CafeManager.dList.get(count).getOp().getCnt();
						System.out.println("üũ�ڽ�+ totalCnt : " + totalCnt);
						cntLb.setText("["+Integer.toString(totalCnt)+"��]");
					} else {
						total -= CafeManager.dList.get(count).getPrice() * CafeManager.dList.get(count).getOp().getCnt();
						System.out.println("üũ�ڽ�- total : " + total);
						totalPriceLb.setText(Integer.toString(total));

						totalCnt -= CafeManager.dList.get(count).getOp().getCnt();
						System.out.println("üũ�ڽ�- totalCnt : " + totalCnt);
						cntLb.setText("["+Integer.toString(totalCnt)+"��]");
					}
				}
			});
		}

		menuBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == menuBt) {
					win.change("coffeeMenu");
				}
			}
		});

		//�ֹ��ϱ� ��ư �̺�Ʈ
		payBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				UIManager.put("OptionPane.messageFont", new Font("���� ���", Font.BOLD, 13));
				JOptionPane.showMessageDialog(listPanel, Login.selectName + " �� �ֹ� �Ϸ�Ǿ����ϴ�", "Payment", 1);

				
				win.change("coffeeMenu");
				CafeManager.dList.clear();
				CafeManager.totalCount = 0;
				CafeManager.totalPrice = 0;
				total = 0;
				totalCnt = 0;
				System.out.println("totalCount: " + CafeManager.totalCount);
			}
		});
	}

	//������� �ֹ��� ������ ��ٱ���â�� ����ִ� �޼ҵ�
	public static void printPrice() {
		
		
		int totalPrice = CafeManager.totalPrice;
		int totalCount = CafeManager.totalCount;

//		total = 0;
//		totalCnt = 0;
		
//		total = CafeManager.totalPrice;
//		totalCnt = CafeManager.totalCount;

		System.out.println("totalCount: " + CafeManager.totalCount);
		totalPriceLb.setText(Integer.toString(totalPrice)); //��ٱ���â�� ���� ��� ���� totalPrice�� ����
		cntLb.setText("["+Integer.toString(totalCount)+"��"+"]");

		String hot = null;
		String take = null;

		for(int i=0; i<10; i++) {
			if(i<CafeManager.dList.size()) {

				if(CafeManager.dList.get(i).getOp().isHot()) {
					hot = "HOT";
				} else {
					hot = "ICED";
				}

				if(CafeManager.dList.get(i).getOp().isTake()) {
					take = "����";
				} else {
					take = "����";
				}

				cb[i].setText(CafeManager.dList.get(i).getName());
				cb[i].setSelected(true);
				optionLb[i].setText(hot+" / "+CafeManager.dList.get(i).getOp().getSize()+" / "+take);
				priceLb[i].setText(CafeManager.dList.get(i).getOp().getCnt()+"�� * "+CafeManager.dList.get(i).getPrice());


				cb[i].setVisible(true);
				menuSe[i].setVisible(true);
				optionLb[i].setVisible(true);
				priceLb[i].setVisible(true);
				priceSe[i].setVisible(true);

			} else {
				cb[i].setVisible(false);
				menuSe[i].setVisible(false);
				optionLb[i].setVisible(false);
				priceLb[i].setVisible(false);
				priceSe[i].setVisible(false);
			}
		}
	}

}
