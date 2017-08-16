package yale.ren.java.algorithm.sort;

/**
 * Created by yale on 2017/8/16.
 */
public class ChoseSort<T extends  Comparable> extends  BaseSort<T> {


    public void sort() {

        for (int i = 0 ;i<mArray.length-1;i++){
            T max  = mArray[i];
            int maxPos = i;
            for (int j = i+1;j<mArray.length;j++){
                if (max.compareTo(mArray[j])>0){
                    max = mArray[j];
                    maxPos = j;
                }
            }
            mArray[maxPos] = mArray[i];
            mArray[i] = max;
        }
    }
}
