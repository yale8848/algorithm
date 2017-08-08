package yale.ren.java.algorithm.hmm;

/**
 * Created by root on 17-8-7.
 */
public class Viterbi {



    public static int[] compute2(int[] obs, int[] states, double[] start_p, double[][] trans_p, double[][] emit_p){

        int ret[] = new int[obs.length];

        double vf[][]=new double[obs.length][states.length];

        int i = 0;
        double m = -Integer.MIN_VALUE;
        for (int st:states){
            vf[i][st] = (start_p[st]*emit_p[st][obs[i]]);
            if (vf[i][st]>m){
                m = vf[i][st];
                ret[i] = st;
            }
        }
        i++;

        for (int j = i;j<obs.length;j++){

            double m1 = -Integer.MIN_VALUE;
            for (int st1: states) {

                double m2 = -Integer.MIN_VALUE;
                for (int st2 :states){
                    vf[j][st1] = vf[j-1][st1]*trans_p[st1][st2];

                    if (vf[j][st1]>m2){
                        m2 = vf[j][st1];
                    }
                }
                double m3 = m2*emit_p[st1][j];
                vf[j][st1] = m3;
                if (m3>m1){
                    m1 = m3;
                    ret[j] = st1;
                }
            }


        }

        return  ret;

    }


    /**
     * 求解HMM模型
     * @param obs 观测序列
     * @param states 隐状态
     * @param start_p 初始概率（隐状态）
     * @param trans_p 转移概率（隐状态）
     * @param emit_p 发射概率 （隐状态表现为显状态的概率）
     * @return 最可能的序列
     */
    public static int[] compute(int[] obs, int[] states, double[] start_p, double[][] trans_p, double[][] emit_p)
    {
        double[][] V = new double[obs.length][states.length];
        int[][] path = new int[states.length][obs.length];

        for (int y : states)
        {
            V[0][y] = start_p[y] * emit_p[y][obs[0]];
            path[y][0] = y;
        }

        for (int t = 1; t < obs.length; ++t)
        {
            int[][] newpath = new int[states.length][obs.length];

            for (int y : states)
            {
                double prob = -1;
                int state;
                for (int y0 : states)
                {
                    double nprob = V[t - 1][y0] * trans_p[y0][y] * emit_p[y][obs[t]];
                    if (nprob > prob)
                    {
                        prob = nprob;
                        state = y0;
                        // 记录最大概率
                        V[t][y] = prob;
                        // 记录路径
                        System.arraycopy(path[state], 0, newpath[y], 0, t);
                        newpath[y][t] = y;
                    }
                }
            }

            path = newpath;
        }

        double prob = -1;
        int state = 0;
        for (int y : states)
        {
            if (V[obs.length - 1][y] > prob)
            {
                prob = V[obs.length - 1][y];
                state = y;
            }
        }

        return path[state];
    }
}
