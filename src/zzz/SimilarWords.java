package src.zzz;

import java.util.HashSet;
import java.util.Set;

public class SimilarWords {
    static final String ALL_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public Set<String> getSimilarWords(String word){
        Set<String> set = new HashSet<>();
        Set<String> set1 = addLetter(word);
        Set<String> set2 = deleteLetter(word);
        Set<String> set3 = changeLetter(word);
        Set<String> set4 = exchangeLetter(word);
        set.addAll(set1);
        set.addAll(set2);
        set.addAll(set3);
        set.addAll(set4);
        return set;
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
                changeSet.add(word.substring(0,i) + ALL_LETTERS.charAt(j) + word.substring(i));
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
