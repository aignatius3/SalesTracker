import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.NumberFormat;

public class FileName 
{
	private JFrame myFrame;
	private JPanel myPanel;
	private JTextField myText;
	private JLabel myLabel;
	private JButton myButton;
	private String Name;
	private File myFile;
	private String[] Items;
	private String[] Cost;
	private String[] Quantity;
	private String format;
	private String format2;
	private Double Total;
	private ArrayList<Double> Price;
	private ArrayList<Integer> Amount;
	private NumberFormat formatter;
	
	public FileName()
	{
		myFrame = new JFrame("Save");
		//myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(600,350);
		
		myFrame.setMaximumSize(new Dimension(300,200));
		myFrame.setMinimumSize(new Dimension(300,200));
		myFrame.setPreferredSize(new Dimension(300,200));
		myFrame.setResizable(false);
		
		myPanel = new JPanel();
		myPanel.setPreferredSize(new Dimension (300,200));
		
		myText = new JTextField();
		myLabel = new JLabel("Customer Name");
		myButton = new JButton("Save Receipt");
		
		Box a = Box.createVerticalBox();
		a.add(myLabel);
		a.add(Box.createVerticalStrut(20));
		a.add(myText);
		a.add(Box.createVerticalStrut(20));
		a.add(myButton);
		a.add(Box.createVerticalStrut(20));
		
		Font labelFont2 = myLabel.getFont();
		String labelText2 = myLabel.getText();
		int stringWidth2 = myLabel.getFontMetrics(labelFont2).stringWidth(labelText2);
		int componentWidth2 = myLabel.getWidth();
		double widthRatio2 = (double)componentWidth2 / (double)stringWidth2;
		int newFontSize2 = (int)(labelFont2.getSize() * widthRatio2);
		int componentHeight2 = myLabel.getHeight();
		int fontSizeToUse2 = 25; 
		myLabel.setFont(new Font(labelFont2.getName(), Font.PLAIN, fontSizeToUse2));
		
		myText.setFont(new Font(myLabel.getFont().getName(), Font.PLAIN, 20));
		
		Price = new ArrayList<Double>();
		Amount = new ArrayList<Integer>();
		
		Name = new String();
		Total = 0.0;
		
		format = "%-20s%-20s%s%n";
		format2 = "%-10s%s%n";
		
		Items = new String [0];
		Cost = new String [0];
		Quantity = new String[0];
		
		Items = Gui.myText.getText().split("\\n");
		Cost = Gui.myText2.getText().split("\\n");
		Quantity = Gui.myText3.getText().split("\\n");
		
		for(int i = 0; i < Cost.length; i++)
		{
			double price = Double.parseDouble(Cost[i]);
			Price.add(price);
		}
		
		
		for(int i = 0; i < Quantity.length; i++)
		{
			int amount = Integer.parseInt(Quantity[i]);
			Amount.add(amount);
		}
		
		for(int i = 0; i < Price.size(); i++)
		{
			Total += Price.get(i) * Amount.get(i);
		}
		
		formatter = NumberFormat.getCurrencyInstance();
				
		myFrame.add(a);
		myFrame.pack();
		myFrame.setVisible(true);
		
		myButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Name = myText.getText();
				myFile = new File(Name);
				
				try
				{
					PrintWriter fout = new PrintWriter(myFile + ".txt");
					
					fout.printf(format, "Items", "Cost", "Quantity", "\n");
					
					for(int i = 0; i < Items.length; i++)
					{
						fout.printf(format, Items[i], "$" + Cost[i], Quantity[i], "\n");
					}
					
					fout.printf(format2, "Total", formatter.format(Total));
					fout.close();
					
				}
				catch(FileNotFoundException a)
				{
					myText.setText("Rename File");
				}
				
				myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
				Total grandTotal = new Total();
				grandTotal.myText.setText(formatter.format(Total));
					
			}
		});
	}
}
