package Streams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class sortByValue {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 4);
        map.put("B",1);
        map.put("C", 3);
        map.put("D",2);

        LinkedHashMap<String, Integer> sortedMap = sortByValue(map);

        for(Map.Entry<String, Integer> entry: sortedMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static LinkedHashMap<String, Integer> sortByValue(HashMap<String, Integer> map){
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : entryList){
            sortedMap.put(entry.getKey(),entry.getValue());
        }
        return sortedMap;
    }
}
