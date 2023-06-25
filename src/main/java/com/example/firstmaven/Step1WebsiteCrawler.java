package com.example.firstmaven;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Step1WebsiteCrawler {
    public static void main(String[] args) {
        String url = "https://www.mmafighting.com/";  // Replace with the actual URL of the website you want to crawl

        try {
            // Send a GET request to the website and retrieve the HTML content
            Document document = Jsoup.connect(url).get();

            // Find the HTML elements containing the headlines
            Elements headlineElements = document.select("h2");  // Adjust the CSS selector based on the structure of the website

            // Extract the headlines
            for (Element headlineElement : headlineElements) {
                String headline = headlineElement.text().trim();
                System.out.println(headline);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
