import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Part2Driver {
	
	
	
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Part2Driver window = new Part2Driver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Part2Driver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 204));
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 500, 3);
		frame.getContentPane().add(separator);
		
		JTextArea displayArea = new JTextArea();
		Font font = new Font("anything", Font.PLAIN, 20);
		displayArea.setBackground(new Color(0, 102, 204));
		displayArea.setForeground(new Color(255, 255, 255));
		displayArea.setFont(font);
		displayArea.setBounds(10, 73, 464, 177);
		frame.getContentPane().add(displayArea);
		
		JButton QSB = new JButton("Quick Sort");
		QSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File ("inventory.txt");
				BufferedReader reader = null;
				try {
					 reader = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
				QuickSort QS = new QuickSort();
				String tempKey = ""; int x = 0;
				String [] inputQ = new String[1125];
				while(x<1125)
				{
					try {
						tempKey = reader.readLine();
					} catch (IOException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					inputQ[x++] = tempKey;
					
				}
				
			
				//calculates time taken by Quick Sort
				
				
						x  =(int) System.nanoTime();
						QS.Sort(inputQ);
						x -= (int) System.nanoTime();
						displayArea.setText("Quick Sort: 1125 elements sorted\nTime: "+(-1*x));
			}
		});
		QSB.setBackground(new Color(255, 255, 255));
		QSB.setBounds(324, 25, 150, 23);
		frame.getContentPane().add(QSB);
		
		JButton MSB = new JButton("Merge Sort");
		MSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File ("inventory.txt");
				BufferedReader reader = null;
				try {
					 reader = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				MergeSort MS = new MergeSort();
				String tempKey = ""; int x = 0;
				String [] inputM = new String[1125];
				while(x<1125)
				{
					try {
						tempKey = reader.readLine();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					inputM[x++] = tempKey;
					
				}
				
				
				
				//calculates time taken by Merge Sort
				
						x  =(int) System.nanoTime();
						MS.Sort(inputM);
						x -= (int) System.nanoTime();
						displayArea.setText("Merge Sort: 1125 elements sorted\nTime: "+(-1*x));
			}
		});
		MSB.setBackground(new Color(255, 255, 255));
		MSB.setBounds(166, 25, 150, 23);
		frame.getContentPane().add(MSB);
		
		JButton ISB = new JButton("Insertion Sort");
		ISB.setBackground(new Color(255, 255, 255));
		ISB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File ("inventory.txt");
				BufferedReader reader = null;
				try {
					 reader = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				InsertionSort IS = new InsertionSort();
				String tempKey = ""; int x = 0;
				String [] inputI = new String[1125];
				while(x<1125)
				{
					try {
						tempKey = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					inputI[x++] = tempKey;
					
				}
				
				
				//calculates time taken by Insertion Sort
				
						x  =(int) System.nanoTime();
						IS.Sort(inputI,1125 );
						x -= (int) System.nanoTime();
						displayArea.setText("Insertion Sort: 1125 elements sorted\nTime: "+(-1*x));
				
			
			}//end
		});
		ISB.setBounds(8, 25, 150, 23);
		frame.getContentPane().add(ISB);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
