package yale.ren.java.algorithm;

import yale.ren.java.algorithm.hmm.Viterbi;

import static yale.ren.java.algorithm.Main.Activity.clean;
import static yale.ren.java.algorithm.Main.Activity.shop;
import static yale.ren.java.algorithm.Main.Activity.walk;
import static yale.ren.java.algorithm.Main.Weather.Rainy;
import static yale.ren.java.algorithm.Main.Weather.Sunny;

/**
 * Created by root on 17-8-7.
 */
public class Main {
    static enum Weather
    {
        Rainy,
        Sunny,
    }
    static enum Activity
    {
        walk,
        shop,
        clean,
    }
    static int[] states = new int[]{Rainy.ordinal(), Sunny.ordinal()};
    static int[] observations = new int[]{walk.ordinal(), shop.ordinal(), clean.ordinal()};
    static double[] start_probability = new double[]{0.6, 0.4};
    static double[][] transititon_probability = new double[][]{
            {0.7, 0.3},
            {0.4, 0.6},
    };
    static double[][] emission_probability = new double[][]{
            {0.1, 0.4, 0.5},
            {0.6, 0.3, 0.1},
    };

    public static void main(String[] args)
    {
        int[] result = Viterbi.compute2(observations, states, start_probability, transititon_probability, emission_probability);
        for (int r : result)
        {
            System.out.print(Weather.values()[r] + " ");
        }
        System.out.println();
    }
}
