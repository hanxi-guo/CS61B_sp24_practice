import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        for (int num : L) {
            sum += num;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : L) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        return evenNumbers;
    }

    /** Returns a list containing the common items of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // Iterator<Integer> iterator = L1.iterator();
        L1.removeIf(num -> !L2.contains(num)); // using removeIf method instead of while loop
//        while (iterator.hasNext()) {
//            int num = iterator.next();
//            if (!L2.contains(num)) {
//                iterator.remove();
//            }
//        }
        return L1;
    }



    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int occurrences = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c){
                    occurrences++;
                }
            }
        }
        return occurrences;
    }

//    public static void main(String[] args) {
//        List<String> words = new ArrayList<>(List.of("sushi", "pasta", "avocado", "coffee"));
//        List<Integer> nums1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
//        List<Integer> nums2 = new ArrayList<>(List.of(3, 4, 5, 6, 7));
//        List<Integer> nums3 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//        System.out.println(countOccurrencesOfC(words, 'a'));
//        System.out.println(common(nums1,nums2));
//        System.out.println(sum(nums2));
//        List<Integer> evenNumbers = evens(nums3);
//        System.out.println(evenNumbers);
//    }
}
