package com.taxcalculator;

import com.taxcalculator.TaxTable;

public class TaxCalculator
{
	public TaxCalculator()
	{
		TaxTable table = new TaxTable(2018, 25);
		System.out.println(table.calculateTax(16000.00)); 
	}
	
	public static void main(String[] args)
	{
		TaxCalculator calc = new TaxCalculator();
	}
}
