package com.qa.ryledra.BlackJack;

public class BlackJack {
	public int blackjack(int a, int b)	{
		if (a <= 21 && b <= 21)	{
			if (a > b) return a;
			else return b;
		}
		else if (b <= 21) return b;
		else if (a <= 21) return a;
		else return 0;
	} 
}
