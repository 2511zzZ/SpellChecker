package bayes;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveModel {
    private static final String MODEL_PATH = "./static/model.txt";

    public void saveModel(){
        Map<String, Integer> model = LanguageModel.getInstance().model;
        File modelFile = new File(MODEL_PATH);
        try{
            if(!modelFile.exists()){modelFile.createNewFile();}
            FileWriter writer = new FileWriter(modelFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(String word: model.keySet()){
                bufferedWriter.write(word + ":" + model.get(word));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getModel(){
        File modelFile = new File(MODEL_PATH);
        Map<String, Integer> model = new HashMap<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(modelFile));
            String line;
            while((line = reader.readLine()) != null){
                model.put(line.split(":")[0], Integer.parseInt(line.split(":")[1]));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return model;
    }
}
