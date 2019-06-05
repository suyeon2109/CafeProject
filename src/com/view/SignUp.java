package com.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.model.vo.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.TextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SignUp extends JFrame {
	static ArrayList<Member> list = new ArrayList<Member>();
	public String path = "member.txt";
	private JPanel contentPane;

	int isClicked = 0;



	public SignUp() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// panel
		JPanel panel = new JPanel();
		contentPane.add(panel);
		setVisible(true);
		getContentPane().add(panel);

		JLabel label_ID = new JLabel("아이디");
		label_ID.setBounds(59, 36, 76, 16);
		contentPane.add(label_ID);

		JLabel label_Pass = new JLabel("비밀번호");
		label_Pass.setBounds(59, 64, 76, 16);
		contentPane.add(label_Pass);

		JLabel label_Rpass = new JLabel("비밀번호확인");
		label_Rpass.setBounds(59, 92, 100, 16);
		contentPane.add(label_Rpass);

		JLabel label_Name = new JLabel("이름");
		label_Name.setBounds(59, 131, 46, 16);
		contentPane.add(label_Name);

		JLabel label_Hp = new JLabel("연락처");
		label_Hp.setBounds(59, 157, 76, 16);
		contentPane.add(label_Hp);

		JTextField Field_ID = new JTextField();
		Field_ID.setBackground(Color.WHITE);
		Field_ID.setBounds(173, 30, 100, 22);
		contentPane.add(Field_ID);

		JPasswordField Field_Pass = new JPasswordField();
		Field_Pass.setBounds(172, 58, 195, 22);
		contentPane.add(Field_Pass);

		JPasswordField Field_Rpass = new JPasswordField();




		Field_Rpass.setBounds(172, 86, 195, 22);
		contentPane.add(Field_Rpass);


		JTextField Field_Name = new JTextField();
		Field_Name.setBounds(172, 131, 195, 22);
		contentPane.add(Field_Name);

		JTextField Field_Hp = new JTextField();
		Field_Hp.setBounds(172, 159, 195, 22);
		contentPane.add(Field_Hp);

		JButton button_SignUp = new JButton("회원가입");
		button_SignUp.setForeground(Color.DARK_GRAY);
		button_SignUp.setBackground(Color.LIGHT_GRAY);
		
		//회원가입 버튼 이벤트
		button_SignUp.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
							
				//if문 사용하여 기존의 아이디 중복체크 부분을 가져옴
				isClicked = 0;
				String idch ="a";
				
				if(idch=="a") {
					
					int temp = 0;

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
							st = new StringTokenizer(str,",");
							m.setId(st.nextToken());
							m.setPassword(st.nextToken());
							m.setName(st.nextToken());
							m.setpNum(st.nextToken());
							list.add(m);


							if(Field_ID.getText().equals(m.getId())){
								temp++;
								c=false;
								break;
							} if (c) 
							{


							}
						}
						

						if(temp != 0) {
							JOptionPane.showMessageDialog(null, "아이디중복확인버튼을눌러확인하세요");
							
						} else {
								
							String pattern = "^[S]*$";
							boolean i = Pattern.matches(pattern, Field_ID.getText());
							boolean p = Pattern.matches(pattern, Field_Pass.getText());
							boolean n = Pattern.matches(pattern, Field_Name.getText());
							boolean h = Pattern.matches(pattern, Field_Name.getText());


							if(i==true){
								JOptionPane.showMessageDialog(null, "아이디입력해주세요");
							}else if(p==true){
								JOptionPane.showMessageDialog(null, "패스워드 입력해주세요");
							}else if(n==true){
								JOptionPane.showMessageDialog(null, "이름입력해주세요");
							}else if(h==true){
								JOptionPane.showMessageDialog(null, "연락처 입력해주세요");
							}


							else if(Field_Rpass.getText().equals(Field_Pass.getText())){

								try{
									String path = "member.txt";
									BufferedWriter bur = new BufferedWriter(new FileWriter(path,true));


									bur.write(Field_ID.getText()+",");
									bur.write(Field_Pass.getText()+",");
									bur.write(Field_Name.getText()+",");
									bur.write(Field_Hp.getText()+",1\r\n");
									
									bur.close();


									JOptionPane.showMessageDialog(null, "회원가입완료");
									dispose();

									Login login = new Login();

								}catch (Exception e1){
									JOptionPane.showMessageDialog(null, "회원가입 오류");

								}

							}else {
								JOptionPane.showMessageDialog(null, "오류 ");
							}
							
						}
					}catch (Exception e10) {
						e10.printStackTrace();
					}finally{

					}
					try{
						fi.close();
					}catch(IOException e10){
						e10.printStackTrace();
					}
					
				}

			}
		});
		
		button_SignUp.setBounds(217, 207, 107, 29);
		contentPane.add(button_SignUp);

		JButton button_Overlap = new JButton("중복확인");
		button_Overlap.setForeground(Color.DARK_GRAY);
		button_Overlap.setBackground(Color.LIGHT_GRAY);
		
		//중복확인 버튼 이벤트
		button_Overlap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//isClicked++;
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
						st = new StringTokenizer(str,",");
						m.setId(st.nextToken());
						m.setPassword(st.nextToken());
						m.setName(st.nextToken());
						m.setpNum(st.nextToken());
						list.add(m);


						if(Field_ID.getText().equals(m.getId())){
							temp++;
							c=false;
							break;
						}if (c) 
						{


						}
					}

					if(temp != 0) {
						JOptionPane.showMessageDialog(null, "중복아이디입니다.");
					} else {
						JOptionPane.showMessageDialog(null, "사용가능한아이디입니다.");
					}
				}catch (Exception e10) {
					e10.printStackTrace();
				}finally{

				}
				try{
					fi.close();
				}catch(IOException e10){
					e10.printStackTrace();
				}

			}
		});
		
		button_Overlap.setBounds(277, 30, 90, 25);
		contentPane.add(button_Overlap);

		JButton button_Cancel = new JButton("취소");
		button_Cancel.setForeground(Color.DARK_GRAY);
		button_Cancel.setBackground(Color.LIGHT_GRAY);
		button_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login login = new Login();
				dispose();
			}
		});
		button_Cancel.setBounds(95, 207, 110, 29);
		contentPane.add(button_Cancel);}


	public void memberLoad(String path) {
		FileInputStream fi = null;
		InputStreamReader isr = null;
		BufferedReader bfr = null;
		StringTokenizer st = null;

		try{
			list.clear();
			fi = new FileInputStream(path);
			isr = new InputStreamReader(fi);
			bfr = new BufferedReader(isr);
			String str = null;
			while((str = bfr.readLine())!= null){
				Member m = new Member();
				st = new StringTokenizer(str,",");
				m.setId(st.nextToken());
				m.setPassword(st.nextToken());
				m.setName(st.nextToken());
				m.setpNum(st.nextToken());
				list.add(m);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				fi.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}


	//회원정보를 텍스트에 입력해주는 메소드
	public void fileSave(String path) {
		FileWriter fw = null;
		try{
			fw = new FileWriter("member.txt",true);
			for(int i=0; i<list.size(); i++){
				fw.write(list.get(i).getId());
				fw.write(",");
				fw.write(list.get(i).getPassword());
				fw.write(",");
				fw.write(list.get(i).getName());
				fw.write(",");
				fw.write(list.get(i).getpNum());
				fw.write("\r\n");

			}       
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				fw.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}

