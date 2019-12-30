package src;

import src.zzz.LanguageModel;
import src.zzz.SimilarWords;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args){
        String path = "./static/BIG.txt";
        LanguageModel LangModel = new LanguageModel();
        SimilarWords words = new SimilarWords();
        Map<String, Integer> model = LangModel.getModel(path);

        System.out.println("请输入要查询的单词:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println(model.get(input));
        for(String word : words.getSimilarWords(input)){
            System.out.println(word);
        }
    }
}