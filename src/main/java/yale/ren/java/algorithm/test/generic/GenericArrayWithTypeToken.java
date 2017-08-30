package yale.ren.java.algorithm.test.generic;

import java.lang.reflect.Array;

/**
 * Created by yale on 2017/8/30.
 */

public class GenericArrayWithTypeToken<T> {
    private T[] array;
    //@SuppressWarning("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);//通过反射在运行时构出实际类型为type[]的对象数组，避免了类型擦除，从而转换成功，无ClassCastException
    }
    public void put(int index, T item){
        array[index] = item;
    }
    public T get(int index) { return array[index]; }
    public T[] rep() { return array; }  //能成功返回了~
    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gawtt = new GenericArrayWithTypeToken(Integer.class, 10);
        Integer[] ia = gawtt.rep(); //能成功返回了！
    }
}