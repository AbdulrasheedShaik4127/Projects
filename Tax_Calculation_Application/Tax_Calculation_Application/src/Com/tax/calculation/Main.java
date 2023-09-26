package Com.tax.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final String username1="admin";
	static String password1 = "admin";
	
	public static void main(String[] args) throws ExceptionClass
	{
		List<PropertyClass> pl= new ArrayList<PropertyClass>();
		List<VehicleClass> vl= new ArrayList<VehicleClass>();
		
		System.out.println("+----------------------------------------------+");
		System.out.println("| WELCOME TO TAXA(TAX CALCULATION APPLICATION) |");
		System.out.println("+----------------------------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE -");
		Scanner s = new Scanner(System.in);
		System.out.print("USERNAME - ");
		String username = s.next();
		System.out.print("PASSWORD - ");
		String password = s.next();
		ArrayList<PropertyClass> properties = new ArrayList<>();
        ArrayList<VehicleClass> vehicles = new ArrayList<>();
		if(username.equals(username1)&&password.equals(password1))
		{
			boolean condition=true;
			while(condition)
			{
				System.out.println("1.PROPERTY TAX\n2.VEHICLE TAX\n3.TOTAL\n4.EXIT");
				int choice1=s.nextInt();
				if(choice1<0)
				{
					throw new ExceptionClass("Enter only in range from 0");
				}
				
				boolean b=true;
				while(b)
				{
				switch(choice1)
				{
				case 1:
					PropertyOperations po = new PropertyOperations();
				System.out.println("1.ADD PROPERTY DETAILS\n2.CALCULATE PROPERTY TAX\n3.DISPLAY ALL PROPERTIES\n4.BACK TO MAIN MENU");
				switch (s.nextInt()) 
				{
				case 1:
					try {
						po.addProperty(properties);
					} catch (ExceptionClass e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						po.addProperty(properties);
					}
					break;
				case 2:
					try {
						po.setTax(properties);
					} catch (ExceptionClass e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						po.addProperty(properties);
					}
					break;
				case 3:
					po.displayDetails(properties);
					break;
				case 4:
					b = false;
					break;
				}
				break;
				case 2:
					while(b)
					{
						VehicleOperations vo = new VehicleOperations();
						System.out.println("1.ADD VEHICLE DETAILS\n2.CALCULATE VEHICLE TAX\n3.DISPLAY ALL VEHICLES\n4.BACK TO MAIN MENU");
						switch (s.nextInt()) 
						{
						case 1:
							try {
								vo.addVehicelDetails(vehicles);
							} catch (ExceptionClass e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							break;
						case 2:
							try {
								vo.setTax(vehicles);
							} catch (ExceptionClass e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							break;
						case 3:
							vo.displayVehicel(vehicles);
							break;
						case 4:
							b = false;
							break;
						}
					}
					break;
				case 3:
					while(b)
					{
					VehicleOperations to = new VehicleOperations();
					to.totalTax(properties, vehicles);
					b=false;
					}
					break;
				case 4:
					System.out.println("THANK YOU VISIT AGAIN");
					System.exit(0);
					break;
					default:
						System.out.println("Invalid choise");
				}
					}
				}
				}
		else
		{
			System.out.println("Invalid username/password");
		}
		

	}

}
