package yale.ren.java.algorithm.sort;

/**
 * Created by yale on 2017/8/16.
 */
public class InsertSort<T extends Comparable> extends BaseSort<T> {


    public void sort() {

        for (int i =1;i<mArray.length;i++){

            int j = i-1;
            T tmp = mArray[i];

            for (;j>=0;j--){
                if (tmp.compareTo(mArray[j])<0){
                    mArray[j+1] = mArray[j];
                }else{
                    break;
                }
            }
            mArray[j+1] = tmp;
        }
    }
}
