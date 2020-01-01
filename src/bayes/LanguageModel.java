package bayes;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LanguageModel{
    private static final String path = "./static/BIG.txt";
    public Map<String, Integer> model;

    // 单例
    private static LanguageModel lm = new LanguageModel(path);
    private LanguageModel(String path){this.model = getLanguageModel(path); }
    public static LanguageModel getInstance(){return lm;}

    private Map<String, Integer> getLanguageModel(String path){
        Map<String, Integer> model = new HashMap<>();
        File file = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int lineCount = 0;
            while((line = reader.readLine()) != null){
                lineCount++;
                if(lineCount%10000 == 0){
                    System.out.println("已统计"+lineCount+"行");
                }
                String[] wordList = line.split(" ");
                for(String word : wordList){
                    word = word.replaceAll("[^a-zA-Z]+","");
                    if(model.containsKey(word)){
                        model.put(word, model.get(word)+1);
                    }else{
                        model.put(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.entrySet().removeIf(item -> item.getValue() == 1);    // 去噪
        model.remove(null);
        return model;
    }
}