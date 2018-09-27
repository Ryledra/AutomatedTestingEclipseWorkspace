package com.qa.ryledra.BlackJack;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;

import org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class TestBlackJack {

	@Parameters
	public static Collection<Object[]> data() {
		// obj = { input1, input2, expected };
		return Arrays.asList(
				new Object[][] { { 20, 5 , 20}, { 22, 5, 5 }, { 20, 21 , 21 }, { 12, 22, 12 }, { 22, 22, 0 }});
	}

	private int input1;
	private int input2;
	private int expected;

	public TestBlackJack(int input1, int input2, int expected) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = expected;
	}

	@Test
	public void test1() {

		BlackJack jack = new BlackJack();
		
		assertEquals(expected, jack.blackjack(input1, input2));
	}
}
