//********************************************************************
//  EmailGUI.java    
//
//********************************************************************

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmailGUI
{
	private static JTextField searchfd;
   //-----------------------------------------------------------------
   //  Creates and displays the GUI.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Prototype Email GUI");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      EmailGUIPanel emailGUIPanel = new EmailGUIPanel();
      emailGUIPanel.setForeground(new Color(119, 136, 153));
      emailGUIPanel.setBackground(new Color(192, 192, 192));
      frame.getContentPane().add(emailGUIPanel, BorderLayout.SOUTH);
      
      JLabel lblyouCanAdd = new JLabel("****You can add up to four messages****");
      lblyouCanAdd.setBounds(135, 267, 219, 14);
      emailGUIPanel.add(lblyouCanAdd);
      
      JButton btnSearchMessage = new JButton("Search message");
      btnSearchMessage.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		EmailGUIPanel egp = new EmailGUIPanel();
      		System.out.println(egp.hashmap.get(searchfd.getText()));
      		
      	}
      });
      btnSearchMessage.setBounds(10, 292, 148, 23);
      emailGUIPanel.add(btnSearchMessage);
      
      searchfd = new JTextField();
      searchfd.setText("Enter ID to search...");
      searchfd.setBounds(168, 293, 155, 20);
      emailGUIPanel.add(searchfd);
      searchfd.setColumns(10);
      frame.pack();
      frame.setVisible(true);
      
   }
}
