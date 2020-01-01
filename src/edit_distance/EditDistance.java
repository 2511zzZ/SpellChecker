package edit_distance;

import java.util.*;

public class EditDistance {
    private int min(int...array){
        int min = Integer.MAX_VALUE;
        for(int num: array){min = Math.min(num, min);}
        return min;
    }

    private int edit_distance(String a,String b){
        int lengthA = a.length();
        int lengthB = b.length();
        int[][] distance = new int[lengthA+1][lengthB+1];

        // 边界
        for(int i=0;i<lengthA+1;i++){distance[i][0] = i;}
        for(int j=0;j<lengthB+1;j++){distance[0][j] = j;}

        for(int i=0;i<lengthA;i++){
            for(int j=0;j<lengthB;j++){
                if(a.charAt(i) == b.charAt(j)){
                    distance[i+1][j+1] = distance[i][j];
                }else{
                    distance[i+1][j+1] = min(distance[i][j+1]+1,distance[i+1][j]+1,distance[i][j]+1);
                }
            }
        }
        return distance[lengthA][lengthB];
    }

    private int compare(int a, int b){
        return a < b ? -1 : 1;
    }

    public Set<String> getSimilarWords(String word, Map<String, Integer> model){
        // compare返回0时 TreeSet会认为两个值相等而不添加到set中
        Set<String> sortSet = new TreeSet<>((o1, o2) -> compare(edit_distance(o1, word), edit_distance(o2, word)));    // 按频率排序
        sortSet.addAll(model.keySet());
        Set<String> sortSliceSet = new TreeSet<>((o1, o2) -> compare(edit_distance(o1, word), edit_distance(o2, word)));
        Iterator<String> it = sortSet.iterator();
        int count = 0;
        while(it.hasNext()&&count<10){    // 切片
            count++;
            sortSliceSet.add(it.next());
        }
        return sortSliceSet;
    }
}
