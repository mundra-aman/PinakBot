package com.example.firstmaven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebsiteCrawler2 {
    public static void main(String[] args) {
        String url = "https://www.mmafighting.com/";  // Replace with the actual URL of the website you want to crawl

        try {
            // Send a GET request to the website and retrieve the HTML content
            Document document = Jsoup.connect(url).get();

            // Find the HTML elements containing the articles
            Elements articleElements = document.select("article");  // Adjust the CSS selector based on the structure of the website

            // Extract the headlines and published time
            for (Element articleElement : articleElements) {
                Element headlineElement = articleElement.selectFirst("h2");  // Adjust the CSS selector for the headline element
                Element timeElement = articleElement.selectFirst(".publish-time");  // Adjust the CSS selector for the time element

                if (headlineElement != null && timeElement != null) {
                    String headline = headlineElement.text().trim();
                    String timePublished = timeElement.text();

                    System.out.println("Headline: " + headline);
                    System.out.println("Published Time: " + timePublished);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
