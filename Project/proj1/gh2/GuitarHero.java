package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    private static double transfer(int order) {
        return 440.0 *  Math.pow(2, (order - 24) / 12.0);
    }

    public static void main(String[] args) {
            int length = keyboard.length();

            GuitarString[] guitarStrings = new GuitarString[keyboard.length()];
            for(int i = 0; i < guitarStrings.length; i++){
                double frequency = transfer(i);
                guitarStrings[i] = new GuitarString(frequency);
            }
            while (true){
                if (StdDraw.hasNextKeyTyped()) {
                    char key = StdDraw.nextKeyTyped();
                    int index = keyboard.indexOf(key);
                    if (index >= 0){
                        guitarStrings[index].pluck();
                    }
                }
                double sample = 0.0;
                for (GuitarString guitarString : guitarStrings){
                    sample += guitarString.sample();
                }
                StdAudio.play(sample);

                for (GuitarString s : guitarStrings){
                    s.tic();
                }
            }
    }


}
