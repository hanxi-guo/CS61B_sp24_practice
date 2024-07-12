import java.util.*;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> treeMap = new TreeMap<>(); //using Character instead char in C programming
        for (int i = 97; i <= 122; i++) {
            char ch = (char) i; // translate ascii code to characters
            treeMap.put(ch, i-96);
        }
        return treeMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map< Integer, Integer> treeMap = new TreeMap<>();
        for (Integer num : nums ){ // here you need to specify the type of elements that the collection contains in Java
            int temp = (int)Math.pow(num, 2); // the type of return value is double
            treeMap.put(num, temp);
        }
        return treeMap;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String word : words) {
            int sum = 0;
            for (String word_sub : words) {
                if (word_sub.equals(word)) {
                    sum ++;
                }
            }
            treeMap.put(word, sum);
        }
        return treeMap;
    }
//    public static void main(String[] args) {
//        List<Integer> nums1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        List<String> words = new ArrayList<>(List.of("sushi", "pasta", "avocado", "sushi", "sushi","avocado" ));
//        System.out.println(letterToNum());
//        System.out.println(squares(nums1));
//        System.out.println(countWords(words));
//    }
}


