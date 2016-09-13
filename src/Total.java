import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Total 
{
	private JFrame myFrame;
	private JPanel myPanel;
	static JTextField myText;
	private JLabel myLabel;
	
	public Total()
	{
		myFrame = new JFrame("Total Cost");
		//myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(600,350);
		
		myFrame.setMaximumSize(new Dimension(300,175));
		myFrame.setMinimumSize(new Dimension(300,175));
		myFrame.setPreferredSize(new Dimension(300,175));
		myFrame.setResizable(false);
		
		myPanel = new JPanel();
		myPanel.setPreferredSize(new Dimension (300,175));
		
		myText = new JTextField();
		myLabel = new JLabel("Total Cost");
		
		Box a = Box.createVerticalBox();
		a.add(myLabel);
		a.add(Box.createVerticalStrut(25));
		a.add(myText);
		a.add(Box.createVerticalStrut(25));
		
		Font labelFont2 = myLabel.getFont();
		String labelText2 = myLabel.getText();
		int stringWidth2 = myLabel.getFontMetrics(labelFont2).stringWidth(labelText2);
		int componentWidth2 = myLabel.getWidth();
		double widthRatio2 = (double)componentWidth2 / (double)stringWidth2;
		int newFontSize2 = (int)(labelFont2.getSize() * widthRatio2);
		int componentHeight2 = myLabel.getHeight();
		int fontSizeToUse2 = 30; 
		myLabel.setFont(new Font(labelFont2.getName(), Font.PLAIN, fontSizeToUse2));
		
		myText.setFont(new Font(myLabel.getFont().getName(), Font.PLAIN, 30));
		
		myFrame.add(a);
		myFrame.pack();
		myFrame.setVisible(true);

	}
}
