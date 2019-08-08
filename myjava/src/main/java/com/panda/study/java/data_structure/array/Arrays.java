package com.panda.study.java.data_structure.array;

/**
 * 定于数组的运算
 * 基础运算：增加、删除、修改、删除
 */
public class Arrays {
    /**
     * 数组的添加，无法处理八大基本数据类型的数组 [实现该方法意义不大，反倒是影响了数组的灵活性]
     * @param arr
     * @param t
     * @param <T>
     * @return
     */
    public static <T> int add(T[] arr,T t){
        if (arr == null || arr.length == 0){
            throw new RuntimeException("传入的数组非法");
        }
        if (t == null){
            throw new RuntimeException("插入的元素没有意义");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null){
                arr[i] = t;
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组的修改，无法处理八大基本数据类型的数组 [实现该方法意义不大，反倒是影响了数组的灵活性]
     * @param arr
     * @param t
     * @param <T>
     * @return
     */
    public static <T> void update(T[] arr,T t,int idx){
        if (arr == null || arr.length == 0){
            throw new RuntimeException("传入的数组非法");
        }
        if (idx < 0 && idx >= arr.length){
            throw new RuntimeException("传入的下标非法");
        }
        arr[idx] = t;
    }
    /**
     * 按下标删除数组中元素
     * @param arr
     * @param idx
     * @param <T>
     */
    public static <T> void remove(T[] arr,int idx){
        if (idx < 0 && idx >= arr.length){
            throw new RuntimeException("传入的下标非法");
        }
        for (int i = idx; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = null;
    }

    /**
     * 检索数组中是否存在某个元素，找到即返回元素在数组中的下标，找不到返回-1
     * @param arr
     * @param target
     * @param <T>
     */
    public static <T> int search(T[] arr,T target){
        if (target == null){
            throw new RuntimeException("传入的参数不能为空");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target || target.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }
}
