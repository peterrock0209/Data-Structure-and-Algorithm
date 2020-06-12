package Hw3_18001166;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Hw3_18001166.SimpleArrayList;
import Hw3_18001166.WordCount;

public class WordCountExample {

    /*public static String openFile(String fileName){
        String text = "";
        Scanner sc;
        try {
            sc = new Scanner(new File(fileName));
            while(sc.hasNextLine()){
                text += sc.nextLine();
            }
        sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static SimpleArrayList<WordCount> count(String text){
        SimpleArrayList<WordCount> wc = new SimpleArrayList<>();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            String word = matcher.group();
            WordCount wordObj = new WordCount(word);
            if(wc.isContain(wordObj)){
                //wordObj = wc.get(wordObj);
                wordObj.setCount(wordObj.getCount() + 1);
            }
            else {
                wc.add(wordObj);
            }
        }

        return wc;
    }*/
    public static void main(String[] args) {
        String text = " \"Word Count :\r\n" + 
        		"- I : 5\r\n" + 
        		"- program : 3\r\n" + 
        		"- java : 6\r\n" + 
        		"- project : 2";
        //SimpleArrayList<WordCount> wcs = count(text);
        //for (WordCount wordCount : wcs) {
            System.out.println(text);
        }
    }
