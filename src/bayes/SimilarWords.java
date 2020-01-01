package bayes;

import java.util.*;

public class SimilarWords {
    static final String ALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    // 获取距离word编辑距离为1的所有单词
    public Set<String> getSimilarWords(String word, Map<String, Integer> model){
        Set<String> set = new HashSet<>();
        Set<String> set1 = addLetter(word);
        Set<String> set2 = deleteLetter(word);
        Set<String> set3 = changeLetter(word);
        Set<String> set4 = exchangeLetter(word);
        set.addAll(set1);
        set.addAll(set2);
        set.addAll(set3);
        set.addAll(set4);
        set.retainAll(model.keySet());  // 取合法单词
        Set<String> sortSet = new TreeSet<>((o1, o2) -> model.get(o2).compareTo(model.get(o1)));    // 按频率排序
        sortSet.addAll(set);
        Set<String> sortSliceSet = new TreeSet<>((o1, o2) -> model.get(o2).compareTo(model.get(o1)));    // 切片
        Iterator<String> it = sortSet.iterator();
        if(model.containsKey(word)){
            sortSliceSet.add(word);
        }
        int count = 0;
        while(it.hasNext()&&count<10){
            count++;
            sortSliceSet.add(it.next());
        }
        return sortSliceSet;
    }

    private Set<String> addLetter(String word){
        Set<String> addSet = new HashSet<>();
        for(int i=0;i<word.length()+1;i++){
            for(int j=0;j<ALL_LETTERS.length();j++){
                addSet.add(word.substring(0,i) + ALL_LETTERS.charAt(j) + word.substring(i));
            }
        }
        return addSet;
    }
    private Set<String> deleteLetter(String word){
        Set<String> deleteSet = new HashSet<>();
        for(int i=0;i<word.length();i++){
            deleteSet.add(word.substring(0,i) + word.substring(i+1));
        }
        return deleteSet;
    }
    private Set<String> changeLetter(String word){
        Set<String> changeSet = new HashSet<>();
        for(int i=0;i<word.length();i++){
            for(int j=0;j<ALL_LETTERS.length();j++){
                changeSet.add(word.substring(0,i) + ALL_LETTERS.charAt(j) + word.substring(i+1));
            }
        }
        return changeSet;
    }
    private Set<String> exchangeLetter(String word){
        Set<String> exchangeSet = new HashSet<>();
        for(int i=0;i<word.length()-1;i++){
            exchangeSet.add(word.substring(0,i) + word.charAt(i+1) + word.charAt(i) + word.substring(i+2));
        }
        return exchangeSet;
    }
}
