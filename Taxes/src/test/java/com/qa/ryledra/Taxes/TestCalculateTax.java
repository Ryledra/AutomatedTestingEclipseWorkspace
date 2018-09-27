package com.qa.ryledra.Taxes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCalculateTax {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] {{7500,0},{17000,1700},{25000,3750},{37000, 7400},{50000,12500}});
	}
	
	private int input;
	private int expected;
	
	public TestCalculateTax(int input, int expected)	{
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void test()	{
		Taxes tax = new Taxes();
		
		try	{
		String fail = "Input " + input + " returns " + tax.calculatedTax(input) + " expected " + expected + "\n";
		assertEquals(fail, expected, tax.calculatedTax(input));
		} catch (SalaryLessThanZeroException slzx)	{
			fail();
		}
	}
}
