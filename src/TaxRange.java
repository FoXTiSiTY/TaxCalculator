
public class TaxRange
{
	private double firstValue;
	private double secondValue;
	
	private int overAndAboveValue;
	private double percentage;
	
	private int higherValue;
	
	public TaxRange(double firstValue, double secondValue, int overAndAboveValue, double percentage, int higherValue)
	{
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.overAndAboveValue = overAndAboveValue;
		this.percentage = percentage;
		this.higherValue = higherValue;
	}
	
	public boolean isInRange(double value)
	{
		return (value >= firstValue && value <= secondValue);
	}
	
	public double calculateTax(double annualGrossIncome)
	{
		return ((annualGrossIncome - higherValue) * (percentage / 100)) + overAndAboveValue;
	}
}
