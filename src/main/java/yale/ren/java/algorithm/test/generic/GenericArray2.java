package yale.ren.java.algorithm.test.generic;

/**
 * Created by yale on 2017/8/30.
 */
public class GenericArray2<T> {
    private Object[] array;  //维护Object[]类型数组
    public GenericArray2(int sz) {
        array = new Object[sz];
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) { return (T)array[index]; }//数组对象出口强转
    public T[] rep() { return (T[])array; } //运行时无论怎样都是Object[]类型
    public static void main (String[] args){
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        // Integer[] ia = gai.rep(); //依旧ClassCastException
        Object[] oa = gai.rep(); //只能返回对象数组类型为Object[]
        gai.put(0,11);
        System.out.println(gai.get(0)); // 11 ,出口成功转型
    }
}