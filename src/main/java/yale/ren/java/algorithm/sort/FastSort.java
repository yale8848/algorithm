package yale.ren.java.algorithm.sort;

/**
 * Created by yale on 2017/8/15.
 * http://developer.51cto.com/art/201403/430986.htm
 * http://blog.csdn.net/morewindows/article/details/6684558
 *
 * O(nlogn) 不稳定
 */
public class FastSort<T extends  Comparable> extends BaseSort<T> {

    public void sort() {
        sort(mArray,0,mArray.length-1);
    }

    public int pritation(T[] array,int start,int end){
        int i = start;//前哨兵
        int j = end;//后哨兵
        T v = array[start];

        while (i<j){
            while (i<j&&v.compareTo(array[j])<=0){//后哨兵向前走,遇见小的退出
                j--;
            }
            while (i<j&&v.compareTo(array[i])>=0){//前哨兵向后走，遇见大的退出
                i++;
            }
            if (i<j){
                swap(i,j);
            }
        }
        array[start] = array[i];
        array[i] = v;
        return i;
    }
    private void sort(T[] array,int start,int end){

        if (start>end){
            return;
        }
        int i = pritation(array,start,end);
        sort(array,start,i-1);
        sort(array,i+1,end);
    }
}
