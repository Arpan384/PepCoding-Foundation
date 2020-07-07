import java.util.*;

public class hashmapUsage {

    public static void main(String[] args) {

        // write your code here.
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 135);
        map.put("China", 150);
        map.put("USA", 200);

        System.out.println(map.get("India"));
        System.out.println(map.put("India", 140));
        System.out.println(map.containsKey("India"));
        System.out.println(map.get("Nepal"));
        System.out.println(map);

        for (String key : map.keySet()) {
            System.out.println(key + "->" + map.get(key));
        }

    }
}