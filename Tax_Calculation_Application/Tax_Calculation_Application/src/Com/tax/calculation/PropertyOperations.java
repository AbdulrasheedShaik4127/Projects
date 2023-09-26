package Com.tax.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropertyOperations {
	PropertyClass pc = new PropertyClass();
	List<PropertyClass> pl = new ArrayList<PropertyClass>();
	Scanner s = new Scanner(System.in);
	public void addProperty(ArrayList<PropertyClass> pl) throws ExceptionClass
	{
		System.out.println("ENTER THE PROPERTY DETAILS -");
		System.out.print("ENTER THE BASE VALUE OF LAND - ");
		double basevalue=s.nextDouble();
		if(basevalue<=0)
		{
			throw new ExceptionClass("Base value should be non zero and positive only");
		}else
		{
		pc.setValue(basevalue);
		}
		System.out.print("ENTER THE BUILT-UP AREA OF LAND - ");
		pc.setBuilt_up_area(s.nextInt());
		System.out.print("ENTER THE AGE OF LAND - ");
		int age=s.nextInt();
		if(age<=0)
		{
			throw new ExceptionClass("Age of building should be non-zero positive");
		}
		else	
		{
		pc.setAge_of_land(age);
		}
		System.out.print("IS THE LAND LOCATED IN CITY?(Y:YES,N:NO) - ");
		String located=s.next();
		if(located.equals("y") || located.equals("n") || located.equals("Y")||located.equals("N"))
		{
			pc.setLocated(located);
			
		}
		else
		{
			throw new ExceptionClass("Enter only y for YES and n for NO");
		}
		PropertyClass pc1 = new PropertyClass(pc.getValue(), pc.getBuilt_up_area(), pc.getAge_of_land(),
				pc.getLocated());
		pl.add(pc1);
		
	}

	
	  public void setTax(ArrayList<PropertyClass> pl) throws ExceptionClass {
	  
	  System.out.println("ENTER THE PROPERTY ID TO CALCULATE THE TAX - ");
	  int id =s.nextInt();
	  if(pl.size()==0)
	  {
		  throw new ExceptionClass("List is empty");
	  }
	  if(id<0 && id>pl.size())
	  {
		  throw new ExceptionClass("Id value must be starting from 1");
	  }
	  else
	  {
		 if(pl.get(id-1).located.equalsIgnoreCase("y"))
		 {
			 pl.get(id-1).tax=(pl.get(id-1).built_up_area*pl.get(id-1).age_of_land*pl.get(id-1).value)+(0.5*pl.get(id-1).built_up_area);
		 }
		 else
		 {
			 pl.get(id-1).tax=(pl.get(id-1).built_up_area*pl.get(id-1).age_of_land*pl.get(id-1).value); 
		 }
		 System.out.println("PROPERTY TAX FOR PROPERTY ID - "+id+" IS "+pl.get(id-1).tax);
	  }
	  }

	 
	public void displayDetails(ArrayList<PropertyClass> pl)
	{
		System.out.println("====================================================================");
		System.out.println("ID\t\tBUILT-UP AREA\tBASE PRICE\tAGE(YEARS)\tIN CITY\t\tPROPERTY TAX");
		System.out.println("====================================================================");
		int i=1;
		for (PropertyClass pc : pl) {
			System.out.print(i+"\t\t");
			System.out.print(pc.built_up_area+ "\t\t");
			System.out.print(pc.value + "\t\t");
			System.out.print(pc.age_of_land + "\t\t\t");
			System.out.print(pc.located+"\t\t");
			System.out.print(pc.tax);
			System.out.println();
			i++;
		}
	}

}
