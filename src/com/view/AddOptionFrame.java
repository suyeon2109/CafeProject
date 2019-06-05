package com.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.model.vo.Option;

public class AddOptionFrame extends JFrame {
   
   private JPanel p;
   private int count = 0; //¼¦Ãß°¡ Ä«¿îÆ®
   public int price = 0; //ÇÕÇÑ°¡°Ý
   public static JTextField txf = new JTextField(50);
   
   JButton[] btn = new JButton[4];
   public static JLabel[] lb = new JLabel [5];
   public static JCheckBox[] boxes = new JCheckBox [6];
   
   public AddOptionFrame() { 
      setBounds(100, 100, 240, 502);
      setResizable(false);
   }
      
   public AddOptionFrame(Option op) {
            
      super("Ãß°¡¿É¼Ç");
      setBounds(100, 100, 240, 502);
      setResizable(false);      
      
      Option temp = new Option();
            
      p = new JPanel();
      p.setBackground(new Color(255, 255, 255));
      p.setLayout(null);
      
      lb[0] = new JLabel("¸Þ¸ð");
      lb[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      p.add(lb[0]).setBounds(8, 289, 52, 15);

      lb[1] = new JLabel("¼¦Ãß°¡");
      lb[1].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(lb[1]).setBounds(8, 56, 62, 15);
      
      lb[2] = new JLabel("0");
      lb[2].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(lb[2]).setBounds(151, 66, 28, 15);

//      lb[3] = new JLabel("ÇÕ°è : ");
//      p.add(lb[3]).setBounds(76, 407, 41, 15);

      lb[4] = new JLabel(" ");
      p.add(lb[4]).setBounds(119, 407, 57, 15);
      
      boxes[0] = new JCheckBox("µðÄ«ÆäÀÎ(+500¿ø)");
      boxes[0].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(boxes[0]).setBounds(0, 17, 226, 23);
      p.add(boxes[0]).setBackground(new Color(245, 245, 245));
      
      boxes[1] = new JCheckBox("¹Ù´Ò¶ó ½Ã·´(+500¿ø)");
      boxes[1].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(boxes[1]).setBounds(0, 107, 226, 23);
      
      boxes[2] = new JCheckBox("ÇìÀÌÁñ³Ó ½Ã·´(+500¿ø)");
      boxes[2].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(boxes[2]).setBounds(0, 137, 226, 23);
      
      boxes[3] = new JCheckBox("Ä³·¯¸á ½Ã·´(+500¿ø)");
      boxes[3].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(boxes[3]).setBounds(0, 167, 226, 23);
      
      boxes[4] = new JCheckBox("µÎÀ¯·Î º¯°æ(+500¿ø)");
      boxes[4].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(boxes[4]).setBounds(0, 213, 226, 23);
      
      boxes[5] = new JCheckBox("ÈÖÇÎÅ©¸² Ãß°¡(+500¿ø)");
      boxes[5].setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
      p.add(boxes[5]).setBounds(0, 256, 226, 23);
      
      //Ã¼Å©¹Ú½º ¾×¼Ç Ãß°¡
      for(int i=0; i<boxes.length; i++) {
         boxes[i].addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
               
               if(boxes[0].isSelected()) { //µðÄ«ÆäÀÎ 
                  temp.setDeCaffeine(true);
                     
               }else {
                  temp.setDeCaffeine(false);
               }

               if(boxes[1].isSelected()) { //¹Ù´Ò¶ó
                  temp.setVanilla(true);
                  
               }else {
                  temp.setVanilla(false);
               }
               if(boxes[2].isSelected()) {  //ÇìÀÌÁñ³Ó
                  temp.setHazelnut(true);
                  
               }else {
                  temp.setHazelnut(false);
                  
               }
               if(boxes[3].isSelected()) { //Ä³·¯¸á
                  temp.setCaramel(true);
                  
               }else {
                  temp.setCaramel(false);
                  
               }
               if(boxes[4].isSelected()) { //µÎÀ¯
                  temp.setSoyMilk(true);
                  
               }else {
                  temp.setSoyMilk(false);
                  
               }
               if(boxes[5].isSelected()) { //ÈÖÇÎ
                  temp.setCream(true);
                  
               }else {
                  temp.setCream(false);
                  
               }
                        
            }
         });
      }
      
      /////////////////////////////////////////////
      JTextField txf = new JTextField(50);
      p.add(txf).setBounds(8, 308, 206, 77);
      txf.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
         }
      });   
      
      btn[0] = new JButton("È®ÀÎ");
      p.add(btn[0]).setBounds(8,432, 102, 23);
      p.add(btn[0]).setBackground(new Color(123,110,102));
      p.add(btn[0]).setForeground(new Color(225,225,225));
      
      btn[1] = new JButton("+");
      p.add(btn[1]).setBounds(174, 62, 52, 23);
      p.add(btn[1]).setBackground(new Color(214,211,204));
      p.add(btn[1]).setForeground(new Color(117,110,104));
      
      btn[2] = new JButton("-");
      p.add(btn[2]).setBounds(84, 62, 52, 23);
      p.add(btn[2]).setBackground(new Color(214,211,204));
      p.add(btn[2]).setForeground(new Color(117,110,104));
      
      btn[3] = new JButton("¿É¼Ç ÃÊ±âÈ­");
      p.add(btn[3]).setBounds(112, 432, 102, 23);
      p.add(btn[3]).setBackground(new Color(214,211,204));
      p.add(btn[3]).setForeground(new Color(117,110,104));
      
      for(int i=0; i<btn.length; i++) {
         btn[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                  
               if(e.getSource() == btn[1]) {
                  if(count<5) {
                     count++;
                     lb[2].setText(count + " ");
                     temp.setShot(count);
                     price += 500;
                     
                  }
               }else if(e.getSource() == btn[2]) {
                  if(count>0) {
                     count--;
                     lb[2].setText(count + " ");
                     temp.setShot(count);
                     price -= 500;
                  }
               }
               if(e.getSource() == btn[3]) {
                  temp.setDeCaffeine(false);
                  temp.setVanilla(false);
                  temp.setHazelnut(false);
                  temp.setCaramel(false);
                  temp.setSoyMilk(false);
                  temp.setCream(false);
                  temp.setShot(0);
                  temp.setAddmemo(null);
                  temp.setAdditionalprice(0);
                  for(int i=0; i<boxes.length; i++) {
                     boxes[i].setSelected(false);
                  }
                  lb[2].setText("0");
                  count = 0;
                  price = 0;
                  System.out.println(temp.toString());
                  txf.setText(" ");
               
               }
               
               if(e.getSource() == btn[0]) {//È®ÀÎ
                  for(int i=0; i<boxes.length; i++) {
                     if(boxes[i].isSelected()) {
                        price += 500;
                     } 
                     
                     op.setDeCaffeine(temp.isDeCaffeine());
                     op.setVanilla(temp.isVanilla());
                     op.setCaramel(temp.isCaramel());
                     op.setCream(temp.isCream());
                     op.setHazelnut(temp.isHazelnut());
                     op.setSoyMilk(temp.isSoyMilk());
                     op.setShot(temp.getShot());
                     op.setAdditionalprice(temp.getAdditionalprice());
                  
                  }
            
                  op.setAddmemo(txf.getText());
                  op.setAdditionalprice(price);               
                  
                  System.out.println("OptionPanel.printPrice1: " +  OptionPanel.printPrice);
                  
                  OptionPanel.lbDrinkPrice.setText(((OptionPanel.price + OptionPanel.addPrice + price) * OptionPanel.count) + " ¿ø");
                  
                  System.out.println("OptionPanel.printPrice2: " +  OptionPanel.printPrice);
                  
                  System.out.println("price: " + price);
                  System.out.println(temp.toString());
                  dispose();
               }
               
            }
         });
      }
      
      add(p);
      this.setVisible(true);         
   }

}