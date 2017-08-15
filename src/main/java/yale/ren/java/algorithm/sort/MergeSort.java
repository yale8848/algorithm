package yale.ren.java.algorithm.sort;

/**
 * Created by word on 2017/8/15.
 * http://flyingcat2013.blog.51cto.com/7061638/1281026
 *http://www.cnblogs.com/jingmoxukong/p/4308823.html
 *
 */
public class MergeSort<T extends  Comparable> extends  BaseSort<T> {

    public void sort() {
        T[] tmp = (T[]) new Object[mArray.length];
        divide(mArray,tmp,0,mArray.length-1);
    }

    private void divide(T [] array ,T [] tmp,int left,int right){
        if (left<right){
            int mid = (left+right)/2;
            divide(array,tmp,left,mid);
            divide(array,tmp,mid+1,right);
            merge(array,tmp,left,mid,right);
        }
    }

    private void merge(T[] array,T [] tmp,int left,int mid,int right){

        int i = left;
        int j = mid+1;
        int k = 0;
        while (i<mid&&j<right){
            if (array[i].compareTo(array[j])<0){
                tmp[k++] = array[i++];
            }else{
                tmp[k++] = array[j++];
            }
        }
        while (i<=mid){
            tmp[k++] = array[i++];
        }
        while (j<=right){
            tmp[k++] = array[j++];
        }
        for (i = 0;i<k;i++){
            array[left+i] = tmp[k];
        }
    }
}
