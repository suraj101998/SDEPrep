package Streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortDescOnValuesLength {
    public static void main(String[] args){
        Map<String, String> playerFranchise = new HashMap<>();
        playerFranchise.put("Dhoni", "CSK"); 
        playerFranchise.put("Virat", "RCB"); 
        playerFranchise.put("Rohit", "Mumbai"); 
        playerFranchise.put("Pant", "Delhi"); 
        playerFranchise.put("Gill", "Gujarat");
        
        List<Map.Entry<String, String>> list = new ArrayList<>(playerFranchise.entrySet());
        list.sort((entry1, entry2) -> Integer.compare(entry2.getValue().length(), entry1.getValue().length()));
        for(Map.Entry<String, String> entry : list){
            System.out.println(entry.getKey() + " => " + entry.getValue());
        } 
    }
}
