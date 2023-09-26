package Com.tax.calculation;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleOperations {
	VehicleClass vc = new VehicleClass();
	Scanner s = new Scanner(System.in);
	
	List<VehicleClass> vl = new ArrayList<VehicleClass>();
	public void addVehicelDetails(ArrayList<VehicleClass> vl) throws ExceptionClass
	{
		System.out.print("ENTER THE VEHICLE REGISTRATION NUMBER");
		int reg_number=s.nextInt();
		int dummy=reg_number;
		int count=0;
		while(dummy!=0)
		{
			dummy/=10;
			count++;
		}
		if(count!=4||reg_number==0000)
		{
			throw new ExceptionClass("Please enter the valid registration number");
		}else
		{
		vc.setRegistration_number(reg_number);
		}
		System.out.print("ENTER THE BRAND OF THE VEHICLE");
		String brand=s.next();
		vc.setBrand(brand);
		System.out.print("ENTER THE MAXIMUM VELOCITY OF THE VEHICLE(KMPH) - ");
		int velocity=s.nextInt();
		if(velocity<120 || velocity>300 )
		{
			throw new ExceptionClass("Velocity must be in a range between 120kmph-300kmph");
		}else
		{
		vc.setMax_velocity(velocity);
		}
		System.out.print("ENTER CAPACITY(NUMBER OF SEATS) OF THE VEICLE - ");
		int seats=s.nextInt();
		if(seats<2 || seats >50)
		{
			throw new ExceptionClass("Seats range should be 2 to 50");
		}
		else
		{
		vc.setNo_of_seats(seats);
		}
		System.out.print("CHOOSE THE TYPE OF VEHICLE - \n1.PETROL DRIVEN\n2.DIESEL DRIVEN\n3.CNG/LPG DRIVEN");
		int vchoice=s.nextInt();
		if(vchoice<0 || vchoice>3)
		{
			throw new ExceptionClass("Select with the range only");
		}
		else
		{
		switch(vchoice)
		{
		case 1:vc.setType_of_vehicle("PETROL");
		break;
		case 2:vc.setType_of_vehicle("DIESEL");
		break;
		case 3:vc.setType_of_vehicle("CNG/LPG");
		break;
		}
		}
		System.out.print("ENTER THE PURCHASE COST OF THE VEHICLE-");
		double cost=s.nextDouble();
		if(cost<50000 || cost >100000)
		{
			throw new ExceptionClass("cost must be within range of 50000 - 100000");
		}
		else
		{
			vc.setPurchase_cost(cost);
		}
		
		vl.add(new VehicleClass(vc.getRegistration_number(),vc.getBrand(),vc.getMax_velocity(),vc.getNo_of_seats(),vc.getType_of_vehicle(),vc.getPurchase_cost(),vc.getVehicle_tax()));
	}
	public void setTax(ArrayList<VehicleClass> vl) throws ExceptionClass
	{   if(vl.size()==0)
	{
		throw new ExceptionClass("Cannot perform on empty list");
	}
	else
	{
		System.out.print("ENTER THE REGISTRATION NO OF VEHICLE TO CALCULATE TAX - ");
		int reg_no=s.nextInt();
		for(VehicleClass vc1:vl)
		{
			if(vc1.registration_number == reg_no)
			{
				if(vc1.type_of_vehicle.equals("PETROL"))
				{
					vc1.vehicle_tax=Math.round(vc1.max_velocity+0.1*vc1.purchase_cost);
				}
				else if(vc1.type_of_vehicle.equals("DIESEL"))
				{
					vc1.vehicle_tax=Math.round(vc1.max_velocity+0.11*vc1.purchase_cost);
				}
				else if(vc1.type_of_vehicle.equals("CNG/LPG"))
				{
					vc1.vehicle_tax=Math.round(vc1.max_velocity+0.12*vc1.purchase_cost);
				}
				System.out.println("VEHICLE TAX FOR REGISTRATION NO - "+reg_no + " IS "+vc1.vehicle_tax);
			}
			else
			{
				System.out.println("Reg number not Found");
				
			}
			
		}
	}
	}
	public void displayVehicel(ArrayList<VehicleClass> vl)
	{
		System.out.println("========================================");
		System.out.println("| REGISTRATION_NO\tBRAND\tMAX.VELOCITY\tNO.OF.SEATS\tVEHICLE TYPE\tPURCHASE COST\tVEHICLE TAX |");
		System.out.println("====================================");
		for (VehicleClass vc : vl) {
			System.out.print(vc.registration_number+ "\t\t");
			System.out.print(vc.brand + "\t\t");
			System.out.print(vc.max_velocity + "\t\t\t");
			System.out.print(vc.no_of_seats+"\t\t");
			System.out.print(vc.type_of_vehicle+"\t\t");
			System.out.print(vc.purchase_cost+"\t\t");
			System.out.print(vc.vehicle_tax);
			System.out.println();
	}
	}
	public void totalTax(ArrayList<PropertyClass> pl,ArrayList<VehicleClass> vl)
		{
			double propertytax=0;
			double vehicletax=0;
			for(PropertyClass pc:pl)
			{
				
				propertytax+=pc.tax;
			}
			for(VehicleClass vc:vl)
			{
				
				vehicletax+=vc.vehicle_tax;
			}
			System.out.println("+---------------------------------------------------+");
			System.out.println("| SR. NO. PARTICULAR\t\tQUANTITY\tTAX |");
			System.out.println("+---------------------------------------------------+");
			System.out.print("|   1\t");
			System.out.print("PROPERTIES\t\t");
	        System.out.print(pl.size()+"\t\t");
	        System.out.print(propertytax+"  |\t\t");
	        System.out.println();
	        System.out.print("|    2\t");
	        System.out.print("VEHICLES\t\t");
	        System.out.print(vl.size()+"\t\t");
	        System.out.println(vehicletax+"  |\t\t");
		
	        System.out.println("+---------------------------------------------------+");
	        System.out.println("| TOTAL-------------"+(pl.size()+vl.size())+"\t"+(propertytax+vehicletax)+" |");
			System.out.println("+---------------------------------------------------+");
}
}
