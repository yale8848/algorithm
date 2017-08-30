package yale.ren.java.algorithm.sort;

import java.util.Arrays;

/**
 * Created by yale on 2017/8/15.
 */
public abstract class BaseSort<T extends Comparable> {
    protected T[] mArray;
    public  void setData(T [] data){
        mArray = data;
        log("before: "+ Arrays.toString(data));
    }
    private void log(String text){
        System.out.println(text);
    }
    protected void swap(int i,int j){
        T tmp = mArray[i];
        mArray[i] = mArray[j];
        mArray[j] = tmp;
    }
    public abstract void sort();
    protected  void sort(Class<T> cls){

    }

    public void printSort(){
        log("after: "+Arrays.toString(mArray));
    }
}
