package com.panda.pattern.proxy.staticproxy;/**
 * Created by My on 2019-12-20.
 */

import com.panda.pattern.proxy.Person;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:38:36 2019-12-20
 * @Modified By:
 */
public class Father implements Person{
    private Person person;
    public Father(Person person){
        this.person = person;
    }

    public void findLove(){
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意，确立关系");
    }
}
