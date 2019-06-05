package com.view;


import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.vo.Member;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textPass;
	private JPasswordField passwordField;
	static ArrayList<Member> list = new ArrayList<Member>();

	public static String selectName = "";


	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 235);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);

		

		JButton buttonID = new JButton("로그인");
		buttonID.setForeground(Color.DARK_GRAY);
		buttonID.setBackground(SystemColor.activeCaption);
		buttonID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lod();
			}
		});

		JButton buttonPASS = new JButton("회원가입");
		buttonPASS.setForeground(Color.DARK_GRAY);
		buttonPASS.setBackground(SystemColor.activeCaption);
		buttonPASS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SignUp sin = new SignUp();
				dispose();
			}
		});

		buttonID.setBounds(242, 80, 117, 29);
		contentPane.add(buttonID);

		buttonPASS.setBounds(242, 130, 117, 29);
		contentPane.add(buttonPASS);

		textId = new JTextField();
		textId.setBounds(100, 80, 130, 26);
		contentPane.add(textId);
		textId.setColumns(10);

		textPass = new JPasswordField();
		textPass.setBackground(Color.WHITE);
		textPass.setBounds(100, 131, 130, 26);
		contentPane.add(textPass);
		textPass.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(27, 86, 49, 16);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 130, 61, 16);
		contentPane.add(lblPassword);

		JLabel lblNewLabel = new JLabel("Coffee G4;");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setBounds(107, 10, 183, 62);
		contentPane.add(lblNewLabel);

		setVisible(true);
	}

	public void lod() {

		int temp = 0;
		String path = "member.txt";

		FileInputStream fi = null;
		InputStreamReader isr = null;
		BufferedReader bfr = null;
		StringTokenizer st = null;
		
		try{
			boolean c = true;
			list.clear();
			fi = new FileInputStream(path);
			isr = new InputStreamReader(fi);
			bfr = new BufferedReader(isr);
			String str = null;

			while((str = bfr.readLine())!= null){

				Member m = new Member();
				st = new StringTokenizer(str, ",");
				m.setId(st.nextToken());
				m.setPassword(st.nextToken());
				m.setName(st.nextToken());
				m.setpNum(st.nextToken());
				m.setNo(st.nextToken());
				list.add(m);

				if(textId.getText().equals(m.getId()) && textPass.getText().equals(m.getPassword()) ) {
					temp++;
					selectName = m.getName();
				}			
			} //end while

			if(temp != 0) {
				if(textId.getText().equals("admin") && textPass.getText().equals("admin") ) {
					
					JOptionPane.showMessageDialog(null, "관리자로 로그인합니다.");
					Admin admin = new Admin();
					
				} else {
					JOptionPane.showMessageDialog(null, selectName +" 님 환영 합니다." );
					dispose();
					
					MainFrame.afterLogin();
				}
			} else {
				JOptionPane.showMessageDialog(null, "아이디 비밀번호  오류");
			}


		} catch (Exception e10) {
			e10.printStackTrace();
		} try{
			fi.close();
		} catch(IOException e10){
			e10.printStackTrace();
		}

	}
}


