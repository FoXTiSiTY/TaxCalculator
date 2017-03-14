package com.taxcalculator;
import java.util.LinkedList;
import java.util.List;

public class TaxTable
{
	private List<TaxRange> rangesList = new LinkedList<>();
	private double primaryTaxRebate;
	private double secondaryTaxRebate;
	private double tertiaryRebate;
	
	private double below65TaxThreshold;
	private double above65AndOverTaxThreshold;
	private double above75AndOverTaxThreshold;
	private int age;
	
	public TaxTable(int taxYear, int age)
	{
		this.age = age;
		loadTables(taxYear);
	}
	
	private void loadTables(int taxYear)
	{
		rangesList.add(new TaxRange(0.00, 189880.00, 0, 18, 0));
		rangesList.add(new TaxRange(189880.01, 296540.00, 34178, 26, 189880));
		rangesList.add(new TaxRange(296540.01, 410460.00, 61910, 31, 296540));
		rangesList.add(new TaxRange(410460.01, 555600.00, 97225, 36, 410460));
		rangesList.add(new TaxRange(555600.01, 708310.00, 149475, 39, 555600));
		rangesList.add(new TaxRange(708310.01, 1500000.00, 209032, 41, 708310));
		rangesList.add(new TaxRange(1500000.01, Double.MAX_VALUE, 533625, 45, 1500000));
		
		primaryTaxRebate = 13635;
		secondaryTaxRebate = primaryTaxRebate + 7479;
		tertiaryRebate = secondaryTaxRebate + 2493;
		
		below65TaxThreshold = 75750;
		above65AndOverTaxThreshold = 117300;
		above75AndOverTaxThreshold = 131150;
	}
	
	public double calculateTax(double monthlyGrossIncome)
	{
		// Annualize the gross earnings
		double annualGrossIncome = monthlyGrossIncome * 12;
		
		if (annualGrossIncome < getAgeThresholdValue())
			return 0;
		
		for (TaxRange range : rangesList)
		{
			if (range.isInRange(annualGrossIncome))
				return Math.max(range.calculateTax(annualGrossIncome) - getAgeTaxRebate(), 0);
		}
		
		return 0;
	}
	
	private double getAgeThresholdValue()
	{
		if (age >= 75)
			return above75AndOverTaxThreshold;
		else if (age >= 65)
			return above65AndOverTaxThreshold;
		else 
			return below65TaxThreshold;
	}
	
	private double getAgeTaxRebate()
	{
		if (age >= 75)
			return tertiaryRebate;
		else if (age >= 65)
			return secondaryTaxRebate;
		else 
			return primaryTaxRebate;
	}
}
