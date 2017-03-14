package com.taxcalculator.tables;

import java.util.LinkedList;
import java.util.List;

import com.taxcalculator.TaxRange;

public class YearTables
{
	public static List<TaxRange> fetchRangesForTaxYear(int taxYear)
	{
		List<TaxRange> rangeList = new LinkedList<>();
		
		switch (TaxYears.findValueById(taxYear))
		{
			case YEAR_2018:
			{
				rangeList.add(new TaxRange(0.00, 189880.00, 0, 18, 0));
				rangeList.add(new TaxRange(189880.01, 296540.00, 34178, 26, 189880));
				rangeList.add(new TaxRange(296540.01, 410460.00, 61910, 31, 296540));
				rangeList.add(new TaxRange(410460.01, 555600.00, 97225, 36, 410460));
				rangeList.add(new TaxRange(555600.01, 708310.00, 149475, 39, 555600));
				rangeList.add(new TaxRange(708310.01, 1500000.00, 209032, 41, 708310));
				rangeList.add(new TaxRange(1500000.01, Double.MAX_VALUE, 533625, 45, 1500000));
				
				break;
			}
		}
		
		return rangeList;
	}
	
	public static enum TaxYears
	{
		YEAR_2018(2018);
		
		public final int taxYear;
		
		private TaxYears(int taxYear)
		{
			this.taxYear = taxYear;
		}
		
		public static TaxYears findValueById(int taxYear)
		{
			for (TaxYears year : values())
			{
				if (year.taxYear == taxYear)
					return year;
			}
			return null;
		}
	}
}
