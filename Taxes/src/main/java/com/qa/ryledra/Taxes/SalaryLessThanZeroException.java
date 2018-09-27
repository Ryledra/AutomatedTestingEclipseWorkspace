package com.qa.ryledra.Taxes;

public class SalaryLessThanZeroException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5692808387313037470L;

	public String toString()	{
		return "Salary must be greater than or equal to 0";
	}
}
