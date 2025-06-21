package huishuo;

import java.util.ArrayList;
import java.util.List;

public class quanpailie {
    static int[] nums=new int[]{1,2,3};

    static void backtrack(int[] array,List<Integer> path,List<List<Integer>> resultList){
        if(path.size()==array.length){
            resultList.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<array.length;i++){
            if(path.contains(array[i])){
                continue;
            }
            path.add(array[i]);
            backtrack(array,path,resultList);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> resultList=new ArrayList<>();

        List<Integer> path=new ArrayList<>();

        backtrack(nums,path,resultList);

        System.out.println(resultList);
    }
}
