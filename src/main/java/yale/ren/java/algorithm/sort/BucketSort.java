package yale.ren.java.algorithm.sort;

/**
 * Created by yale on 2017/8/17.
 */
public class BucketSort<T extends Comparable<T>> extends BaseSort<T> {

    public void sort() {
        int MAX  = 10;
        Node bucket[] = new Node[MAX+1];
       for (int i = 0;i<mArray.length;i++){
           Integer v = (Integer) mArray[i];
           if (bucket[v]==null){
               bucket[v] =new Node<Integer>(v,null,null);
           }else{
               bucketInnerSort(bucket,v);
           }
       }
    }

    public void bucketInnerSort(Node bucket[] ,Integer v){

    }
    private Node pritation(Node start,Node end){

        Node tmp = start;
        Node i=start.next,j=end;

        while (i!=j){

            while (i!=j&&tmp.value.compareTo(i.value)<=0){
                i  = i.next;
            }
            while (i.next!=j&&tmp.value.compareTo(j.value)>=0){
                j = j.pre;
            }
            if (i!=j){
                T t = (T) i.value;
                i.value = j.value;
                j.value = t;
            }
        }
        return i;


    }
    private void fastSort(Node start,Node end){

    }

    class Node<T extends Comparable>{

        public Node next;
        public T value;
        public Node pre;

        public Node(T value,Node pre,Node next){
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }
}
