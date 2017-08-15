package yale.ren.java.algorithm.sort;

/**
 * Created by word on 2017/8/15.
 */
public abstract class BaseSort<T extends Comparable> {
    protected T[] mArray;
    public  void setData(T [] data){
        mArray = data;
    }
    public abstract void sort();
}
