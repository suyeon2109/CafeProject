package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.model.vo.Member;

import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Admin extends JFrame {

	static ArrayList<Member> list = new ArrayList<Member>(); 


	private JPanel contentPane;
	
	public Admin() {

		members();

		setTitle("회원 관리");
		setLocation(350, 250);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		// panel
		JPanel panel = new JPanel();
		contentPane.add(panel);
		setVisible(true);
		getContentPane().add(panel);

		JTable table_1 = null;

		Object[] column2 = {"ID","PASSWORD","NAME","PHONE_NUM"};

		Object[][] ob = new Object[list.size()][4];

		for(int i=0; i<list.size(); i++){
			ob[i][0] = list.get(i).getId();
			ob[i][1] = list.get(i).getPassword();
			ob[i][2] = list.get(i).getName();
			ob[i][3] = list.get(i).getpNum();
		}


		table_1= new JTable(ob,column2);

		table_1.getColumn("ID").setPreferredWidth(100);
		table_1.getColumn("PASSWORD").setPreferredWidth(100);
		table_1.getColumn("NAME").setPreferredWidth(100);
		table_1.getColumn("PHONE_NUM").setPreferredWidth(100);


		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table_1.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}

		panel.add(table_1);

		//table_1.setSize(660,387);

	}


	public  void members(){

		String path = "member.txt";
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

}
