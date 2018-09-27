package com.qa.ryledra.Taxes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTaxBands {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] {{-300, "slzx"},{7500,15},{17000,10},{25000,15},{37000, 20},{50000,25}});
	}
	
	private int input;
	private int expected;
	private String expectedEx;
	
	
	public TestTaxBands(int input, Object expected)	{
		this.input = input;
		if (expected.getClass().toString().equals(Integer.class.toString()))
			this.expected = (Integer)expected;
		else {
			this.expected = 0;
			expectedEx = expected.toString();
		}
	}
	
	@Test
	public void testTaxBand()	{
		Taxes tax = new Taxes();
		
		try	{
			String fail = "Input " + input + " returns " + tax.taxBand(input) + " expected " + expected + "\n";
			assertEquals(fail, expected, tax.taxBand(input));
		}
		catch (SalaryLessThanZeroException slzx)	{
			boolean exExpected = false;
			if (expectedEx == "slzx")	{
				exExpected = true;
			}
			assertTrue("Exception not expected",exExpected);
		}
	}

}
