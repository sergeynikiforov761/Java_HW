package com.sberbank;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static TradeType getType(String outerString){
        for(TradeType type: TradeType.values()){
            if(type.getString().equals(outerString)){
                return type;
            }
        }
        return TradeType.DEFAULT;
    }
    public static String typeRefactor(String currentString){
        int firstIndex = currentString.indexOf('{');
        int finalIndex = currentString.indexOf('}');
        return currentString.substring(firstIndex + 1, finalIndex);
    }
    public static void main(String[] args){
        // get file name
        Scanner scan = new Scanner(System.in);
        String fileName = scan.nextLine();
        // create arrays for types and prices of input date
        List<String> arrayTypes = new ArrayList<>();
        List<String> arrayPrices = new ArrayList<>();
        try {
            FileReader fr = new FileReader(new File(fileName));
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
                if(currentMatcher.find())
                    arrayTypes.add(typeRefactor(line));

                currentMatcher = secondPattern.matcher(line);
                if(currentMatcher.find()){
                    arrayPrices.add(typeRefactor(line));
                }
                line = reader.readLine();
            }
            for(int i = 0; i < arrayPrices.size(); i++){
                TradeType currentType = getType(arrayTypes.get(i));
                currentType.CreateTrade(Double.parseDouble(arrayPrices.get(i)));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
