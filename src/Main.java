package src;

import src.zzz.LanguageModel;
import src.zzz.SimilarWords;

import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        SimilarWords words = new SimilarWords();
        Map<String, Integer> model = LanguageModel.getInstance().model;

        System.out.println("请输入要查询的单词:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        for(String word : words.getSimilarWords(input, model)){
            System.out.println(word);
        }
    }
}