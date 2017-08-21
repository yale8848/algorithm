package yale.ren.java.algorithm.sort;

/**
 * Created by yale on 2017/8/16.
 */
public class ShellSort<T extends Comparable> extends BaseSort<T> {

    public void sort() {

        int gap = mArray.length/2;
        while (gap>=1){
            for (int i =0 ;i<gap;i++){

                int j = i+gap;

                for (;j<mArray.length;j +=gap){
                    T tmp = mArray[j];
                    int k = j-gap;
                    for (;k>=0;k-=gap){
                        if (tmp.compareTo(mArray[k])<0){
                            mArray[k+gap] = mArray[k];
                        }else{
                            break;
                        }
                    }
                    mArray[k+gap] = tmp;
                }
            }
            gap /= 2;
        }
    }
}
