package com.qa.ryledra.Taxes;

public class Taxes {
	public int taxBand(int salary) throws SalaryLessThanZeroException {
		if (salary < 0) throw new SalaryLessThanZeroException();
		else if (salary < 15000) return 0;
		else if (salary < 20000) return 10;
		else if (salary < 30000) return 15;
		else if (salary < 45000) return 20;
		else return 25;
	}
	
	public int calculatedTax(int salary) throws SalaryLessThanZeroException {
		int output = salary * taxBand(salary) / 100;
		// System.out.println("Tax to be paid: " + output);
		return output;
	}
}
