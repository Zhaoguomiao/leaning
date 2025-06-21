package AAAAA;

import java.util.*;

public class StringProcess {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text=scanner.nextLine();
        List<String> result=countWordFrequence(text);
        System.out.println(result.subList(0,result.size()-1));
    }
    public static List<String> countWordFrequence(String text){
        Set<Character> punctuation=new HashSet<>(Arrays.asList(',','.','!','?',':','"','/'));
        Map<String,Integer> frequencyMap=new HashMap<>();
        StringBuilder wordBuilder=new StringBuilder();
        for(char c:text.toCharArray()){
            if(Character.isLetter(c)){
                wordBuilder.append(Character.toLowerCase(c));
            }else {
                if (!wordBuilder.isEmpty()){
                    String word=wordBuilder.toString();
                    frequencyMap.put(word,frequencyMap.getOrDefault(word,0)+1);
                    wordBuilder.setLength(0);
                }
            }
        }
        /**
         * 考虑程序执行的过程，当最后以一个字母结尾 程序 将其添加到 wordBuilder之后并没有将其添加到 map中
         */
        if(!wordBuilder.isEmpty()){
            String word=wordBuilder.toString();
            frequencyMap.put(word,frequencyMap.getOrDefault(word,0)+1);
            wordBuilder.setLength(0);
        }
        List<Map.Entry<String,Integer>> entryList=new ArrayList<>(frequencyMap.entrySet());
        /**
         * a-b是升序，b-a是降序
         * 小减大升序     前-后 升序
         * 大减小降序     后-前 降序
         */
        entryList.sort((a,b)->{
            if(a.getValue().equals(b.getValue())){
                return a.getKey().compareTo(b.getKey());
            }else {
                return b.getValue()-a.getValue();//按照具体的频率大小
            }
        });
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:entryList){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        return result;

    }
}
