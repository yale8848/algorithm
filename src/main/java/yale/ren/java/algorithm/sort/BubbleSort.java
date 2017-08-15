package yale.ren.java.algorithm.sort;

/**
 * Created by word on 2017/8/15.
 */
public class BubbleSort<T extends Comparable> extends BaseSort<T> {


    public void sort() {

        for (int i =0 ;i<mArray.length;i++){
            for (int j = 0;j<mArray.length-i-1;j++){
                if (mArray[j].compareTo(mArray[j+1])>0){
                    T tmp = mArray[j];
                    mArray[j] = mArray[j+1];
                    mArray[j+1] = tmp;
                }
            }
        }
    }
}
