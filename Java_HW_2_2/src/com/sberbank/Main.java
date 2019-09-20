package com.sberbank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String typeRefactor(String currentString) {
        int firstIndex = currentString.indexOf('{');
        int finalIndex = currentString.indexOf('}');
        return currentString.substring(firstIndex + 1, finalIndex);
    }

    public static void main(String[] args) {
        // get file name
        Scanner scan = new Scanner(System.in);
        String fileName = scan.nextLine();
        // create arrays for types and prices of input date
        List<String> arrayTypes = new ArrayList<>();
        List<String> arrayPrices = new ArrayList<>();
        List<Trade> arrayTrades = new ArrayList<>();
        try {
            FileReader fr = new FileReader(new File(fileName));
            // InputStreamReader fr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            // create regular expression and patterns for types and prices
            String regexFirst = "^.*type.*$";
            String regexSecond = "^.*price.*$";
            Pattern firstPattern = Pattern.compile(regexFirst);
            Pattern secondPattern = Pattern.compile(regexSecond);

            // parse input txt file
            while (line != null) {
                Matcher currentMatcher = firstPattern.matcher(line);
                if (currentMatcher.find())
                    arrayTypes.add(typeRefactor(line));

                currentMatcher = secondPattern.matcher(line);
                if (currentMatcher.find()) {
                    arrayPrices.add(typeRefactor(line));
                }
                line = reader.readLine();
            }
            for (int i = 0; i < arrayPrices.size(); i++) {
                TradeType currentType = TradeType.valueOf(arrayTypes.get(i));
                arrayTrades.add(currentType.CreateTrade(Double.parseDouble(arrayPrices.get(i))));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
