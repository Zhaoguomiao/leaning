package Algorithm;

import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        List<String> result=countWordFrequency(text);
        System.out.println(result);
    }
    public static List<String> countWordFrequency(String text) {//在集合的构造函数中，可以传入一个collection来初始化
        Set<Character> punctuation=new HashSet<>(Arrays.asList(',','.','!','?',';',':','"','/'));
        Map<String,Integer> frequencyMap=new HashMap<>();
        StringBuilder wordBuilder=new StringBuilder();

        for(char c:text.toCharArray()){
            if(Character.isLetter(c)){
                wordBuilder.append(Character.toLowerCase(c));
            } else if (punctuation.contains(c)) {

            } else if (wordBuilder.length()>0) {
                //说明wordBuilder中最起码已经有一个单词了
                String word=wordBuilder.toString();
                frequencyMap.put(word,frequencyMap.getOrDefault(word,0)+1);
                wordBuilder.setLength(0);//清空当前的StringBuilder
            }
        }
        if(wordBuilder.length()>0){
            String word=wordBuilder.toString();
            frequencyMap.put(word,frequencyMap.getOrDefault(word,0)+1);
        }

        List<Map.Entry<String,Integer>> entryList=new ArrayList<>(frequencyMap.entrySet());

        entryList.sort((a,b)->{
            if(a.getValue().equals(b.getValue())){
                return a.getKey().compareTo(b.getKey());//按照字母表进行排序，字母单词均可以比
            }else {
                return b.getValue()-a.getValue();//因为本身b就代表第二个参数
            }
        });//entry 是一个对象

        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:entryList){
            result.add(entry.getKey()+":"+entry.getValue());
        }
        return result;
    }
}
