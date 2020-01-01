import bayes.LanguageModel;
import bayes.SaveModel;
import bayes.SimilarWords;
import edit_distance.EditDistance;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
//        Map<String, Integer> model = LanguageModel.getInstance().model;
        SaveModel sm = new SaveModel();
        File file = new File("./static/model.txt");
        if(!file.exists()){sm.saveModel();}
        Map<String, Integer> model = sm.getModel();

        System.out.println("请输入要查询的单词:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println("按单词使用频率排序:");
        SimilarWords sw = new SimilarWords();
        for(String word : sw.getSimilarWords(input, model)){
            System.out.print(word+" ");
        }
        System.out.println();

        System.out.println("按单词相似度排序:");
        EditDistance ed = new EditDistance();
        for(String word : ed.getSimilarWords(input, model)){
            System.out.print(word+" ");
        }
    }
}