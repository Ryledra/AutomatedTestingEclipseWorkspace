package com.qa.WebScraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import org.jsoup.select.Elements;
import org.junit.Test;

public class ScraperTest {
	
	@Test
	public void scrape() throws IOException	{
		
		ExcelUtils data = new ExcelUtils();
		
		for (int i = 1; i < data.getPhysicalNumberOfRows(); i++)	{
			Document doc = Jsoup.connect(data.getCellString(i, 0)).get();
			
			Elements featured = doc.select(data.getCellString(i, 1));
			
			
//			Elements newsHeadlines = doc.select("#mp-itn b a");
//			for (Element headline : newsHeadlines) {
//			  System.out.println(headline.attr("title") +  " - "  + headline.absUrl("href"));
//			}
		}
	}
	

}
