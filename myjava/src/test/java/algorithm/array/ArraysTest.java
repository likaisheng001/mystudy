package algorithm.array;

import org.junit.Test;

/**
 * Created by Administrator on 2019/8/8.
 */
public class ArraysTest {
    @Test
    public void test01(){
        Integer[] arr = new Integer[10];
//        Arrays.remove(arr,1);
        Arrays.add(arr,10);
        Arrays.add(arr,101);
        Arrays.add(arr,110);
        Arrays.add(arr,100);
        Arrays.update(arr,1000,1);
        int search = Arrays.search(arr, 110);
        System.out.println("search = " + search);
        System.out.println("arr="+java.util.Arrays.toString(arr));
    }
}
