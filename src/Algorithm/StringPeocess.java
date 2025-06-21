package Algorithm;

import java.util.*;

public class StringPeocess {
    public static void process(String s) {
        StringBuilder sb=new StringBuilder();
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }
        System.out.println("去重后的字符串为："+sb);
        System.out.println("反转后的字符串为："+sb.reverse());

        Map<Character,Integer> map=new HashMap<>();
        for(char c:sb.toString().toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        /**
         * 经典的遍历图的写法，写很多次了
         */
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        }
    }

    public static void main(String[] args) {
        String string="aaabbbcccdddddddddd";
        process(string);
    }
}
