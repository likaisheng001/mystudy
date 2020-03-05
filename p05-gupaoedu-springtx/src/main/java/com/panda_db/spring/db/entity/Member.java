package com.panda_db.spring.db.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:45:00 2019-12-20
 * @Modified By:
 */
@Entity
@Table(name="t_member")
@Data
public class Member implements Serializable{
    @Id private Long id;

    private String name;
    private String addr;
    private Integer age;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }
}
