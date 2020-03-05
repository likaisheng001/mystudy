package com.panda.study.JDKSRC;

import java.util.Calendar;

/**
 * Created by Administrator on 2019/7/28.
 */
public class Factory {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        //注意月份下标从0开始，所有取月份要+1
        System.out.println("年："+cal.get(Calendar.YEAR));
        System.out.println("月："+ (cal.get(Calendar.MARCH)+1));
        System.out.println("日："+cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时："+cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分："+cal.get(Calendar.MINUTE));
        System.out.println("秒："+cal.get(Calendar.SECOND));
    }
}
