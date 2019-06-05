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


/* �������� �г��� ������ �ϳ��� ������ ���� �ʿ��� �г��� ȣ���ϴ� ������� �ۼ�!! */

public class MainFrame extends JFrame {

	public static MenuPanel coffeeMenu = null;
	public MenuPanel nonCoffeeMenu = null;
	public OptionPanel option = null;
	public CartPanel cart = null;

	static JTabbedPane jtab = new JTabbedPane();
	static JLabel logoLb = new JLabel();
	static JLabel logoTextLb = new JLabel();
	static JPanel pan = new JPanel();

	public static String[] coffeeStr = new String[]{"����������", "�Ƹ޸�ī��", "ī���", "īǪġ��", "��ü��", "ļ��Ḷ���ƶ�"}; //�޴� �̸� ���� �迭
	public static String[] nonCoffeeStr = new String[]{"��׷���Ƽ", "�����ƮƼ", "�׸�Ƽ��", "����Ƽ��"};

	public static int isNon = 0;

	public static JLabel memNameLb = new JLabel("[ " + Login.selectName + " ] ��");
	//public static JLabel memNameLb = new JLabel("[ hello" + " ] ��");
	
	public MainFrame() {

	}

	//�г� â ���� �޼ҵ�
	public void change(String panelName) {	

		getJtabIndex();

		if(panelName.equals("coffeeMenu")) {

			getContentPane().removeAll(); // ��� �г� ����
			getContentPane().add(jtab);
	
			ImageIcon imgIcon = new ImageIcon("pic/logo.png"); // �̹��������ܿ� ����
			Image originImg = imgIcon.getImage(); // �̹����������� �̹����� �̹��� ������ ����
			Image changedImg= originImg.getScaledInstance(85, 85, Image.SCALE_SMOOTH ); 
			ImageIcon icon = new ImageIcon(changedImg);

			logoLb.setBounds(160, 5, 85, 85);
			logoLb.setIcon(icon); //icon���� ��ư
			add(logoLb);

			ImageIcon imgIcon2 = new ImageIcon("pic/logoText.png"); // �̹��������ܿ� ����
			Image originImg2 = imgIcon2.getImage(); // �̹����������� �̹����� �̹��� ������ ���� 
			Image changedImg2 = originImg2.getScaledInstance(180, 60, Image.SCALE_SMOOTH ); 
			ImageIcon icon2 = new ImageIcon(changedImg2);

			logoTextLb.setBounds(235, 25, 180, 60);
			logoTextLb.setIcon(icon2); //icon���� ��ư
			add(logoTextLb);
			
			//ȸ�� �̸��� ����ϴ� ��
			memNameLb.setBounds(460, 80, 100, 30);
			memNameLb.setFont(new Font("���� ���", Font.BOLD, 15));
			add(memNameLb);
			
			JLabel what = new JLabel(); //����?
			add(what);

			getContentPane().setBackground(Color.WHITE);	

			jtab.setSelectedIndex(0);
			getJtabIndex();

			revalidate();	
			repaint();

		} else if(panelName.equals("option")){
			getContentPane().removeAll(); // ��� �г� ����
			getContentPane().add(option);

			option.getSelectedImage(isNon); //�ɼ��гο��� ������ ����� ����, �̸�, ���� �������ִ� �޼ҵ� ȣ��

			revalidate();
			repaint();

		} else if(panelName.equals("cart")) {

			CartPanel.printPrice();

			getContentPane().removeAll(); // ��� �г� ����
			getContentPane().add(cart);
			revalidate();
			repaint();
		}
	}

	//�α��ο� ������ ��� ȣ��
	public static void afterLogin() {

		MainFrame win = new MainFrame();
		
		 
		//logoLb.setBounds(250, 5, 90, 90); //�ؽ�Ʈ�� ��, �ΰ� ���
		
		ImageIcon logoIcon = new ImageIcon("pic/logo.png"); // �̹��������ܿ� ����

		//�̹����� ��ư ũ�⿡ �°� ����
		Image originImg = logoIcon.getImage(); // �̹����������� �̹����� �̹��� ������ ���� 

		//���ο� �̹��� ������ ������ ������ �̹��� ����
		Image changedImg= originImg.getScaledInstance(85, 85, Image.SCALE_SMOOTH ); 
		ImageIcon icon = new ImageIcon(changedImg);

		logoLb.setBounds(160, 5, 85, 85);
		logoLb.setIcon(icon); //icon���� ��ư
		win.add(logoLb);
		
		ImageIcon imgIcon2 = new ImageIcon("pic/logoText.png"); // �̹��������ܿ� ����

		//�̹����� ��ư ũ�⿡ �°� ����
		Image originImg2 = imgIcon2.getImage(); // �̹����������� �̹����� �̹��� ������ ���� 

		//���ο� �̹��� ������ ������ ������ �̹��� ����
		Image changedImg2 = originImg2.getScaledInstance(180, 60, Image.SCALE_SMOOTH ); 
		ImageIcon icon2 = new ImageIcon(changedImg2);

		logoTextLb.setBounds(235, 25, 180, 60);
		logoTextLb.setIcon(icon2); //icon���� ��ư
		win.add(logoTextLb);

		memNameLb.setBounds(460, 80, 100, 30);
		memNameLb.setFont(new Font("���� ���", Font.BOLD, 14));
		win.add(memNameLb);

		win.getContentPane().setBackground(Color.WHITE);	


		//����� �������� ȭ���� ��� �߰�
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
		jtab.setBorder(BorderFactory.createEmptyBorder(100 , 0 , 0 , 0)); //���� �Ʒ��� ������!

		getJtabIndex();

		win.setSize(600, 600);
		win.setVisible(true);
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setLocationRelativeTo(null); 
	}

	//������ ���� �ε����� ���� isNon�� ��������
	public static void getJtabIndex() {

		if(jtab.getSelectedIndex() == 0)
			isNon = 0;
		else
			isNon = 6;
	}

}
