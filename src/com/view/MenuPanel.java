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

//�޴� â ���� Ŭ����
class MenuPanel extends JPanel {

	CafeManager c = new CafeManager();
	public static JButton[] drinkBtn = new JButton[6]; //�޴� ��ư �迭_ �� �������� 6��
	public static JLabel[] drinkLb = new JLabel[6];
		
	public static int index = 0;
	/////////////////////////////////////////////

	private MainFrame win;

	public MenuPanel() { }

	//tempStr�� coffeeStr �Ǵ� nonCoffeeStr�� ����
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

			int j = i; //���� �ε��� ��ȣ�� j�� ����

			drinkBtn[i] = new JButton();
			drinkBtn[i].setName(tempStr[i]); //��ư�� �̸��� ��������� ����
			
			drinkLb[i] = new JLabel(tempStr[i]);
			drinkLb[i].setHorizontalAlignment(SwingConstants.CENTER);
			drinkLb[i].setFont(new Font("�������", Font.BOLD, 14));
			
			
			//(������ �̸�)�� (��ư�� �̸�)�� ���� ��� �� �̹����� ��ư�� �������� ���� 
			if(tempStr[i].equals(drinkBtn[i].getName())) { //drinkBtn[i]�� �ؽ�Ʈ�� tempStr[i]�� �ؽ�Ʈ�� ������
				ImageIcon imgIcon = new ImageIcon("pic/" + tempStr[i] + ".PNG"); // �̹��������ܿ� ����

				//�̹����� ��ư ũ�⿡ �°� ����
				Image originImg = imgIcon.getImage(); // �̹����������� �̹����� �̹��� ������ ���� 

				//���ο� �̹��� ������ ������ ������ �̹��� ����
				Image changedImg= originImg.getScaledInstance(120, 120, Image.SCALE_SMOOTH ); 
				ImageIcon icon = new ImageIcon(changedImg);

				drinkBtn[i].setIcon(icon); //icon���� ��ư�� �̹��� ����
			}			
			
			if (i < 3) {
				drinkBtn[i].setBounds(25 + i * 180, 30, 120, 120); //��ư�� ��ġ (����, ��, ���α���, ���α���)
				drinkLb[i].setBounds(25 + i * 180, 160, 120, 15);
				//drinkLb[i].setFont(new Font("�������", Font.BOLD, 14));
			} else {
				drinkBtn[i].setBounds(25 + (i - 3) * 180, 200, 120, 120);
				drinkLb[i].setBounds(25 + (i - 3) * 180, 330, 120, 15);
				//drinkLb[i].setFont(new Font("�������", Font.BOLD, 14));
			}

			//�޴� �̹��� ��ư Ŭ���� �߻� �̺�Ʈ
			drinkBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {				
					index = j;  // ���� �ε����� index������ ����
					
					System.out.println("index: " + index);
					win.change("option"); //optionâ���� ����
				}
			});
			
			whPan.add(drinkBtn[i]);
			whPan.add(drinkLb[i]);
		}	

	}
}
