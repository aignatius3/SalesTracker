import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Gui 
{
	private JFrame myFrame;
	private JPanel myPanel;
	static JTextArea myText;
	static JTextArea myText2;
	static JTextArea myText3;
	private JLabel Item;
	private JLabel Cost;
	private JLabel Quantity;
	private JScrollPane myScroll;
	private JScrollPane myScroll2;
	private JScrollPane myScroll3;
	private JButton Save;
	private JButton NewOrder;
	private JButton Clear;
	private JButton Receipt;
	private String [] Items;
	private String [] Costs;
	private String [] Quantities;
	private String [] blankItems;
	private String [] blankCosts;
	private String [] blankQuantities;
	private ArrayList<Double> Price;
	private ArrayList<Integer> Amount;
	
	
	public Gui()
	{
		myFrame = new JFrame("Sales Tracker");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(400,150);
		
		myFrame.setMaximumSize(new Dimension(800,400));
		myFrame.setMinimumSize(new Dimension(800,400));
		myFrame.setPreferredSize(new Dimension(800,400));
		myFrame.setResizable(false);
		
		myPanel = new JPanel();
		myPanel.setPreferredSize(new Dimension (100,100));
		//myFrame.add(myPanel);
		
		Box a = Box.createHorizontalBox();
		Box b = Box.createVerticalBox();
		Box c = Box.createVerticalBox();
		Box d = Box.createHorizontalBox();
		Box e = Box.createHorizontalBox();
		
		a.add(c);
		
		Save = new JButton("Save");
		NewOrder = new JButton("New Order");
		Clear = new JButton("Clear");
		Receipt = new JButton("Receipt");
		
		b.add(Receipt);
		b.add(Box.createVerticalStrut(50));
		b.add(Save);
		b.add(Box.createVerticalStrut(50));
		b.add(NewOrder);
		b.add(Box.createVerticalStrut(50));
		b.add(Clear);
		b.add(Box.createVerticalStrut(50));
		
		
		
		a.add(Box.createHorizontalStrut(50));
		a.add(b);
		a.add(Box.createHorizontalStrut(50));
		
		myText = new JTextArea();
		myText2 = new JTextArea();
		myText3 = new JTextArea();
		
		myScroll = new JScrollPane(myText);
		myScroll2 = new JScrollPane(myText2);
		myScroll3 = new JScrollPane(myText3);
		e.add(myScroll);
		e.add(myScroll2);
		e.add(myScroll3);
		
		Item = new JLabel("Item");
		Item.setPreferredSize(new Dimension(50,50));
		Item.setSize(50,50);
		Cost = new JLabel("Cost");
		Cost.setPreferredSize(new Dimension(50,50));
		Quantity = new JLabel("Quantity");
		Quantity.setPreferredSize(new Dimension(50,50));
		d.add(Item);
		d.add(Box.createHorizontalStrut(110));
		d.add(Cost);
		d.add(Box.createHorizontalStrut(110));
		d.add(Quantity);
		d.add(Box.createHorizontalStrut(25));
		c.add(e);
		c.add(d);
		
		Font labelFont = Item.getFont();
		String labelText = Item.getText();
		int stringWidth = Item.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = Item.getWidth();
		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;
		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = Item.getHeight();
		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = 40;
		// Set the label's font size to the newly determined size.
		Item.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		
		Font labelFont2 = Cost.getFont();
		String labelText2 = Cost.getText();
		int stringWidth2 = Cost.getFontMetrics(labelFont2).stringWidth(labelText2);
		int componentWidth2 = Cost.getWidth();
		double widthRatio2 = (double)componentWidth2 / (double)stringWidth2;
		int newFontSize2 = (int)(labelFont2.getSize() * widthRatio2);
		int componentHeight2 = Cost.getHeight();
		int fontSizeToUse2 = 40;
		Cost.setFont(new Font(labelFont2.getName(), Font.PLAIN, fontSizeToUse2));
		
		Font labelFont3 = Quantity.getFont();
		String labelText3 = Quantity.getText();
		int stringWidth3 = Quantity.getFontMetrics(labelFont3).stringWidth(labelText3);
		int componentWidth3 = Quantity.getWidth();
		double widthRatio3 = (double)componentWidth3 / (double)stringWidth3;
		int newFontSize3 = (int)(labelFont3.getSize() * widthRatio3);
		int componentHeight3 = Quantity.getHeight();
		int fontSizeToUse3 = 40;
		Quantity.setFont(new Font(labelFont3.getName(), Font.PLAIN, fontSizeToUse3));
		
		myText.setFont(new Font(Item.getFont().getName(), Font.PLAIN, 15));
		myText2.setFont(new Font(Item.getFont().getName(), Font.PLAIN, 15));
		myText3.setFont(new Font(Item.getFont().getName(), Font.PLAIN, 15));
		
		Price = new ArrayList<Double>();
		Amount = new ArrayList<Integer>();
		
		Items = new String [0];
		Costs = new String [0];
		Quantities = new String[0];
		
		blankItems = new String[0];
		blankCosts = new String[0];
		blankQuantities = new String[0];
		
		NewOrder.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				myText3.setText(" ");
			}
		});
		
		Clear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				myText.setText(" ");
				myText2.setText(" ");
				myText3.setText(" ");
			}
		});
		
		Receipt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				FileName myFile = new FileName();
			}
		});
		
		Save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Items = Gui.myText.getText().split("\\n");
				Costs = Gui.myText2.getText().split("\\n");
				Quantities = Gui.myText3.getText().split("\\n");
				
				for(int i = 0; i < Costs.length; i++)
				{
					double price = Double.parseDouble(Costs[i]);
					Price.add(price);
					
				}
				
				for(int i = 0; i < Quantities.length; i++)
				{
					int amount = Integer.parseInt(Quantities[i]);
					Amount.add(amount);
				}
				
				if(Database.Items.isEmpty())
				{
					for(int i = 0; i < Items.length; i++)
					{
						Database.Items.add(Items[i]);
						Database.Costs.add(Price.get(i));
						Database.Quantities.add(Amount.get(i));
						double y = Database.Costs.get(i) * Database.Quantities.get(i);
						Database.totalPerItem.add(y);
					}
				}
				
				else
				{
					int i = 0;
					int r = Items.length;
					while(i < r)
					{
						int u = Database.Items.indexOf(Items[i]);
						if(u >= 0 && Price.get(i).equals(Database.Costs.get(u)))
						{
							int x = Database.Quantities.get(i) + Amount.get(i);
							Database.Quantities.set(i, x);
							double y = Database.Costs.get(i) * Database.Quantities.get(i);
							Database.totalPerItem.set(i, y);
						}
						else
						{
							Database.Items.add(Items[i]);
							Database.Costs.add(Price.get(i));
							Database.Quantities.add(Amount.get(i));
							double y = Database.Costs.get(i) * Database.Quantities.get(i);
							Database.totalPerItem.add(y);
						}
						i++;
					}

				}
					
				
				for(int x = 0; x < Database.totalPerItem.size(); x++)
				{
					Database.Total += Database.totalPerItem.get(x);
				}
				
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
				
				try 
				{
					PrintWriter fout = new PrintWriter("Sales.txt");
					String format = "%-30s%-30s%-30s%s%n";
					fout.printf(format, "Items", "Cost", "Quantity", "Total per Item", "\n");
					for(int z = 0; z < Database.Items.size(); z++)
					{
						fout.printf(format, Database.Items.get(z), formatter.format(Database.Costs.get(z)), Database.Quantities.get(z), formatter.format(Database.totalPerItem.get(z)), "\n");
					}
					
					String format2 = "%-20s%s%n";
					fout.printf(format2, "Grand Total", formatter.format(Database.Total));
					fout.close();
				} 
				catch (FileNotFoundException a) 
				{
					
				}
				
				Items = blankItems;
				Costs = blankCosts;
				Quantities = blankQuantities;
				
				Price = new ArrayList<Double>();
				Amount = new ArrayList<Integer>();
				
			}
		});
		
		myFrame.add(a);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}