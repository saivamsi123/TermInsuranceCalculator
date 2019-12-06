package com.insurancecalculator.terminsurancecalculator.support.main;

import java.util.List;
import java.util.Scanner;

import com.insurancecalculator.terminsurancecalculator.support.dao.DBRiderDAO;
import com.insurancecalculator.terminsurancecalculator.support.daoModel.DBRider;

public class TestCalculator {
	public static void main(String args[])
	{
		String option = null, name = null;
		Double percentOfPremium = 0d;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("You want to give input(yes/no): ");
			option = sc.next();
			if(option.equals("yes"))
			{
				System.out.println("Enter the name");
				name = sc.next();
				System.out.println("Enter the percentOfPremium");
				percentOfPremium = sc.nextDouble();
			}
			else
			{
				break;
			}
		}
		
		DBRiderDAO dao = new DBRiderDAO();
		DBRider dbRider = new DBRider();
		dbRider.setName(name);
		dbRider.setPerCentOfPremium(percentOfPremium);
		if(dao.addAllRiders(dbRider))
		{
			System.out.println("Added successfully....");
		}
		List<DBRider> printList = dao.getAllRiders();
		System.out.println("list of Riders");
		for(DBRider dbPrintList : printList)
		{
			System.out.println(dbPrintList.getId()+" "+dbPrintList.getName()+" "+dbPrintList.getPerCentOfPremium());
		}
	}

}
