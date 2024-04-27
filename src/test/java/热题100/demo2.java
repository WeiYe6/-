package 热题100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo2 {

//    public static void main(String[] args) {
//        /*输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]*/
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        HashMap<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//
//        }
//    }


    /**
     * 注意 groupingBy 算子计算完以后，返回的是一个 Map<String, List<String>>，map 的键是每种排序后的字符串，值是聚合的原始字符串，
     * 我们只关心值，所以我们最后 new ArrayList<>(map.values())。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        // str -> split -> stream -> sort -> join
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> Stream.of(str.split(""))
                .sorted().collect(Collectors.joining()))).values());
    }


    public List<List<String>> groupAnagrams3(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    int[] counter = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        counter[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                        if (counter[i] != 0) {
                            sb.append((char) ('a' + i));
                            sb.append(counter[i]);
                        }
                    }
                    return sb.toString();
                })).values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //将当前字符串str转换为字符数组chr。
            char[] chr = str.toCharArray();
            //对字符数组chr进行排序，使得相同字母组成的单词具有相同的顺序。
            Arrays.sort(chr);
            //将排序后的字符数组chr转换回字符串，并将其存储在名为key的变量中。
            String key = new String(chr);
            //从map中获取与key关联的值。如果没有找到对应的值，则使用一个新的空ArrayList作为默认值。
            List<String> list = map.getOrDefault(key, new ArrayList());
            //将当前字符串str添加到列表list中。
            list.add(str);
            //将key和list作为键值对放入map中。
            map.put(key, list);
        }
        //将map中所有的值转换为一个列表，并返回该列表作为方法的结果。此列表包含了按照相同字母组成的单词分组的字符串列表
        return (List<List<String>>) map.values();
    }


    /**
     * ----需求：----
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 相同字母的分为同一组。（随机组合）
     **/

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        char[] charArray;
        //用map接收
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //将字符串转换成字符数组
            charArray = str.toCharArray();
            //对字符数组进行排序，注意：相同字符的即ASCLL表中的值是相等的，所以他们的顺序是相同的
            Arrays.sort(charArray); //aet、aet、ant、aet、ant、abt
            //将排序后的字符数组，转换回字符串
            String key = new String(charArray);//aet、aet、ant、aet、ant、abt
            //点睛之笔：从map中获取与key关联的值并放在同一集合中 || 获取key相同的同一个集合(包括里面本来就存有的数值)，
            // 如果key不同，默认开一个新的集合，---并存放key对应的值 在下面的list.add(str)完成。
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);//[eat] [tea] [tan] [ate] [nat] [bat]
            map.put(key,list);
            //System.out.println(map);

        }
        //注意我要的是map中的value值，是以key为一组，组成的集合。
        Collection<List<String>> values = map.values();
        System.out.println(values);
        //return null;
    }

    public List<List<String>> groupAnagrams10(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chr = str.toCharArray();
            Arrays.sort(chr);
            String key = new String(chr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
