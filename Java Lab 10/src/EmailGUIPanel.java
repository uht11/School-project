//********************************************************************
//  EmailGUIPanel.java       
//
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class EmailGUIPanel extends JPanel
{
   private EmailFieldPanel toPanel, ccPanel, bccPanel, subjectPanel;
   private EmailFieldPanel messagePanel;
   private JLabel resultLabel;
   private JButton sendButton;
   public static HashMap hashmap = new HashMap();
   //-----------------------------------------------------------------
   //  Constructor: Sets up the main GUI components.
   //-----------------------------------------------------------------
   public EmailGUIPanel()
   {
      toPanel = new EmailFieldPanel("To (ID):", 30);
      toPanel.setBounds(0, 5, 500, 40);
      toPanel.setToolTipText("This is the key for the messaged to be searched");
      ccPanel = new EmailFieldPanel("CC:", 30);
      ccPanel.setBounds(0, 50, 500, 40);
      bccPanel = new EmailFieldPanel("BCC:", 30);
      bccPanel.setBounds(0, 95, 500, 40);
      subjectPanel = new EmailFieldPanel("Subject:", 30);
      subjectPanel.setBounds(0, 140, 500, 40);
      messagePanel = new EmailFieldPanel("Message:", 30);
      messagePanel.setBounds(0, 185, 500, 40);
      resultLabel = new JLabel ("------");
      resultLabel.setBounds(247, 240, 208, 14);
      
      sendButton = new JButton("Send");
      sendButton.setBounds(137, 236, 100, 23);
      sendButton.addActionListener(new SendListener());
      setLayout(null);

      add(toPanel);
      add(ccPanel);
      add(bccPanel);
      add(subjectPanel);
      add(messagePanel);
      add(sendButton);
      add(resultLabel);

      setPreferredSize (new Dimension(500, 325));
      setBackground (Color.lightGray);
   }

   //*****************************************************************
   //  Represents an action listener for the send button.
   //*****************************************************************
   private class SendListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Prints the field information to standard output.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
    	  if (hashmap.size()!= 4){
    	 
    	 //adds the send info to the hash table uses the "to (ID)" as the key
    	 hashmap.put(toPanel.getFieldText(), "To: " + toPanel.getFieldText()+"\nCC: " + ccPanel.getFieldText()+"\nBCC: " + bccPanel.getFieldText()+"\nSubject: " + subjectPanel.getFieldText()+"\nMessage: " + messagePanel.getFieldText());
         
         resultLabel.setText("Message add to Hash-Table");
         System.out.println("Number of entries so far: "+hashmap.size());
      	  }
    	  else
    		  JOptionPane.showMessageDialog(null,"Sorry you've already added four messages!!!");
      }
   }
}
