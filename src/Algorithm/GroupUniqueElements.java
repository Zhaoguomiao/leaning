package Algorithm;

import java.util.*;

public class GroupUniqueElements {
    public static List<List<Integer>> function(int[] arr, int k){
        Set<Integer> set = new HashSet<>();
        for(int i:arr){
            set.add(i);
        }
        System.out.println(set);

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);
        System.out.println(list);

        List<List<Integer>> result = new ArrayList<>();
        int i=0;
        while (i<list.size()){
            int end=Math.min(i+k,list.size());
            List<Integer> group = list.subList(i, end);
            result.add(new ArrayList<>(group));
            i=i+k;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 4, 3, 5};
        int k = 2;
        List<List<Integer>> result = function(arr, k);
        System.out.println(result);
    }
}
