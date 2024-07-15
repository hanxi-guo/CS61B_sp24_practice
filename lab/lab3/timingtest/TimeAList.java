package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // create 4 new ALists
        AList<Integer> temp = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};

        for (int size : sizes){

            // use Stopwatch to record the time
            Stopwatch clock = new Stopwatch();
            for (int i = 0; i < size; i++){
                temp.addLast(0);
            }
            double time = clock.elapsedTime();

            // record the total time in need
            times.addLast(time);

            //copy the sizes array
            opCounts.addLast(size);
            Ns.addLast(size);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
