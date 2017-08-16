package yale.ren.java.algorithm.sort;

/**
 * Created by yale on 2017/8/15.
 * http://www.cnblogs.com/skywang12345/p/3602162.html
 * O(nlogn) 不稳定
 */
public class HeapSort<T extends  Comparable> extends BaseSort<T> {

    public void sort(){
        int start = (mArray.length/2)-1;
        for (int i = start;i>=0;i--){
            create(i,mArray.length-1);
        }
        changePos();
    }
    private void changePos(){
        int start = mArray.length-1;
        for (int i = start;i>=0;i--){
            swap(i,0);
            create(0,i-1);//注意从第一个开始创建
        }
    }

    //创建堆
    private void create(int start,int end){
        T tmp = mArray[start];
        int curPos = start;
        int childPos = 2*curPos+1;


        for (;childPos<=end;curPos = childPos,
                childPos = 2*curPos+1){
            if (childPos<end&&mArray[childPos].
                    compareTo(mArray[childPos+1])<0){
                childPos++;
            }
            if (tmp.compareTo(mArray[childPos])<0){
                mArray[curPos] = mArray[childPos];
                mArray[childPos] = tmp;
            }else{
                break;
            }
        }
    }
}
