package lee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap<>(10,0.75F,true);
        map.put("11a","sss");
        map.put("22b","sss");
        map.put("11b","sss");
        map.put("1","sss");
        map.put("11c","sss");
        System.out.println(map.get("11b"));
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(map);
    }
}
