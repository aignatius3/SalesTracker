import java.util.ArrayList;


public class Database 
{
	static ArrayList<String> Items;
	static ArrayList<Double> Costs;
	static ArrayList<Integer> Quantities;
	static ArrayList<Double> totalPerItem;
	static double Total;
	
	public Database()
	{
		Items = new ArrayList<String>();
		Costs = new ArrayList<Double>();
		Quantities = new ArrayList<Integer>();
		totalPerItem = new ArrayList<Double>();
		Total = 0.0;
		
	}
}