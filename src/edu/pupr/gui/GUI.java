/**
 Program: GUI.java
 Author: Miguel Mejias Amparo
 Date: 05/06/2024
 Description: Day of Week GUI is a program that shows you what day of the week was based on the date selected in the program.
 History:
         05/06/2024 File created. MLMA
         05/06/2024: implementing exception handling 
         05/06/2024 implementing JcomboBox and making it work
         05/06/2024 implementing maximum days in a month. Example: February has 28 days
 */

package edu.pupr.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.InputMethodListener;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.event.InputMethodEvent;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.time.Month;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;

public class GUI extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JButton calculateDayofWeek;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel resultadoJL;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Day of Week");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		
		
		textField.setColumns(10);
		
		calculateDayofWeek = new JButton("Day of Week");
		calculateDayofWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			try {
				int month = comboBox.getSelectedIndex() + 1;
				int day = comboBox_1.getSelectedIndex() + 1;
				int year = Integer.parseInt(textField.getText());
				
				DayOfWeek dow = new DayOfWeek(month,day,year); //instanciar
				resultadoJL.setText(dow.Zellercongruence());
			}catch(InputMismatchException | NumberFormatException ex) {
				JOptionPane.showMessageDialog(GUI.this, "Must enter numbers!","Error",JOptionPane.WARNING_MESSAGE);
			}catch(ArithmeticException ex) {
				JOptionPane.showMessageDialog(GUI.this, ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
			}
			}
				});
		
		JLabel monthDayofWeekx = new JLabel("Month:");
		
		JLabel dayDayofWeekx = new JLabel("Day:");
		
		JLabel yearDayofWeekx = new JLabel("Year:");
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int month = comboBox.getSelectedIndex() + 1;
				if(month==2) {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
				}
				if(month==4||month==6||month==9||month==11){
						comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28","29","30"}));
				}
				else if (month==1||month==3||month==5||month==7||month==8||month==10||month==12){
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			}}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		resultadoJL = new JLabel("");
	
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addComponent(monthDayofWeekx)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(resultadoJL)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(dayDayofWeekx)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(yearDayofWeekx)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(calculateDayofWeek, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(dayDayofWeekx)
						.addComponent(monthDayofWeekx)
						.addComponent(yearDayofWeekx)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(calculateDayofWeek, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(resultadoJL)
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
