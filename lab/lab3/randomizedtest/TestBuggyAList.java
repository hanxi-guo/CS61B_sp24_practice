package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by hug.
 */
public class TestBuggyAList {

    public static int RandomGenerator(int min, int max) {
        int n = 10;

        // method uniform would return a random integer between 0 and (n - 1)
        // so we need to use (max + 1) here
        return StdRandom.uniform(min, max + 1);
    }

    @Test
    public void testThreeAddThreeRemove() {
        int Addarray[] = new int[3];
        boolean testpass = true;
        AListNoResizing<Integer> NoBugList = new AListNoResizing<>();
        BuggyAList<Integer> BuggyList = new BuggyAList<>();
        for (int i = 0; i < Addarray.length; i++) {
            Addarray[i] = RandomGenerator(0, 9);
        }
        for (int index_first : Addarray) {
            NoBugList.addLast(index_first);
            BuggyList.addLast(index_first);
        }

        // use assertEquals() method instead of using != sign
        for (int index_last = 2; index_last >= 0; index_last--) {
            assertEquals(NoBugList.removeLast(), BuggyList.removeLast());
        }
  }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> NobugL = new AListNoResizing<>();
        AListNoResizing<Integer> BuggyL = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                NobugL.addLast(randVal);
                BuggyL.addLast(randVal);
            } else if (operationNumber == 3) {
                testThreeAddThreeRemove();
            }
            else{
                if (NobugL.size() == 0 || BuggyL.size() == 0) {
                    continue;
                }
                assertEquals(NobugL.getLast(), BuggyL.getLast());
                assertEquals(NobugL.removeLast(), BuggyL.removeLast());
            }
        }
    }
}
