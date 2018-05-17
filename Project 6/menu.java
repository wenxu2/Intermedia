import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.AbstractButton;

import javax.swing.text.MaskFormatter;

/*wenwen xu
 * project 6
 * The user must make selection in all three section!!
 * in the meat/cheese, no matter how many items the user selected, it will cost the same. 
 * */

public class menu implements ActionListener{
		
		public JPanel p1;
		public JPanel p2;
		public JPanel p3;
		public JPanel p4;
		public JPanel p5;
		
		public JLabel l1;
		public JLabel l2;
		public JLabel l3;
		public JLabel l4;
		
		public JRadioButton white;
		public JRadioButton wheat;
		public JRadioButton r1;
		public JRadioButton r2;
		public JRadioButton r3;
		public JRadioButton r4;
		
	
		public JCheckBox c1;
		public JCheckBox c2;
		public JCheckBox c3;
		public JCheckBox c4;
		
		
		public JButton calculate;
		public JButton exit;
		
		public JFrame frame;
      
      
		int sub_b = 0;
		int sub_d = 0;
		int sub_m = 0;
			
		
		public menu(){
			gui();
			groupButton();	
		}
		
		//this  method set make the layout of the GUI
		public void gui(){
		
		//set the name of the gui
		frame = new JFrame("Odrer Calculator");
		frame.setVisible(true);
		frame.setSize(700,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagConstraints c =  new GridBagConstraints();
		
		
		//panel p1 : name only
		p1 = new JPanel(new GridBagLayout());
		//p1.setBorder(BorderFactory.createLineBorder(Color.black));
		l1 = new JLabel("Welcome to Johnny's Sandwich Shop");
		c.insets = new Insets(20,20,20,20);
		c.gridx=0;
		c.gridy=1;
		p1.add(l1,c);	
		frame.add(p1,BorderLayout.NORTH);
		
		
		//panel p2
		p2 = new JPanel(new GridBagLayout());
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		l2 = new JLabel("Bread");
		white = new JRadioButton("White");	
		wheat = new JRadioButton("Wheat");
		
		
		//set position 
		c.insets = new Insets(10,90,30,10);
		c.gridx=0;
		c.gridy=1;
		p2.add(l2,c);
		c.gridx = 0;
		c.gridy = 8;
		p2.add(white,c);
		c.gridx=0;
		c.gridy=10;
		p2.add(wheat,c);
		frame.add(p2,BorderLayout.WEST);
		
		
		//panel p3
		p3 = new JPanel(new GridBagLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		l3 = new JLabel("Meat/Cheese");
		c1 = new JCheckBox("Cheese");
		c2 = new JCheckBox("Roast Beef");
		c3 = new JCheckBox("Turkey");
		c4 = new JCheckBox("Ham");	
		//set position 
		c.insets = new Insets(20,10,0,0);
		//name
		c.gridx = 0;
		c.gridy = 1;
		p3.add(l3,c);
		//cheese
		c.gridx = 0;
		c.gridy = 2;
		p3.add(c1,c);
		//RB
		c.gridx = 0;
		c.gridy = 3;
		p3.add(c2,c);
		//Turkey
		c.gridx = 0;
		c.gridy = 4;
		p3.add(c3,c);
		//Ham
		c.gridx = 0;
		c.gridy = 5;
		p3.add(c4,c);
		frame.add(p3,BorderLayout.CENTER);
		
		
		//panel p4
		p4 = new JPanel(new GridBagLayout());
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		l4 = new JLabel("Coffee");	
		r1 = new JRadioButton("None");	
		r2 = new JRadioButton("Regular coffee");
		r3 = new JRadioButton("Decaf coffee");
		r4 = new JRadioButton("Cappuccino");	
		c.insets = new Insets(20,10,0,100);	
		//title
		c.gridx = 0;
		c.gridy = 1;
		p4.add(l4,c);	
		//r1-none
		c.gridx=0;
		c.gridy=2;
		p4.add(r1,c);	
		//r2-regular coffee
		c.gridx=0;
		c.gridy=3;
		p4.add(r2,c);	
		//r3-decaf coffee
		c.gridx=0;
		c.gridy=4;
		p4.add(r3,c);
		//r4-cappuccino
		c.gridx=0;
		c.gridy=5;
		p4.add(r4,c);	
		frame.add(p4,BorderLayout.EAST);
		
		
		//panel p5
		p5 = new JPanel(new GridBagLayout());	
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
	
		
		p5.add(calculate);
		p5.add(exit);
		frame.add(p5,BorderLayout.SOUTH);	

	}
	
//this method makes the program run when user click "Calculate"
public void actionPerformed(ActionEvent e) {
		
		final JButton source = (JButton)e.getSource();
		DecimalFormat df2 = new DecimalFormat(".##");
		
		if(source.equals(calculate)){
			
			
			if(!c1.isSelected() && !c2.isSelected() && !c3.isSelected() && !c4.isSelected()){
				JOptionPane.showMessageDialog(null,"Please make sure you click all three categories");
				return;
			}
			if(!white.isSelected() && !wheat.isSelected()){
				JOptionPane.showMessageDialog(null,"Please make sure you click all three categories");
				return;
			}
			if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected()){
				JOptionPane.showMessageDialog(null,"Please make sure you click all three categories");
				return;
			}
			else{
				if((white.isSelected() || wheat.isSelected())&& r1.isSelected()){
			
					sub_b = 1;
					sub_m = 2;
					sub_d = 0;
					}
				else if((white.isSelected() || wheat.isSelected()) && !r1.isSelected()){
					sub_b = 1;
					sub_m = 2;
					sub_d = 1;
					}
			//calculate the price 
			int subtotal =sub_b + sub_m +sub_d;
			double tax = 0.075 * subtotal;
			double total = subtotal + tax;
			String string = "Subtotal:" + df2.format(subtotal) + "\nTax: "+df2.format(tax)+ "\nTotal: "+df2.format(total);
			
			JOptionPane.showMessageDialog(null,string);
		    
			}
		}
		
		if(source.equals(exit)) {
			
			System.exit(0);
			}
}

//this method make the radio button mutually exclusive
public void groupButton(){
		
		ButtonGroup BG1 = new ButtonGroup();	
		BG1.add(white);
		BG1.add(wheat);
		
		ButtonGroup BG2 = new ButtonGroup();
		BG2.add(r1);
		BG2.add(r2);
		BG2.add(r3);
		BG2.add(r4);	
	}
}
