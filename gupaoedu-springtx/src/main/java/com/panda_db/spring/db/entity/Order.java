package com.panda_db.spring.db.entity;/**
 * Created by My on 2019-12-20.
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:02:07 2019-12-20
 * @Modified By:
 */
@Entity
@Table(name="t_order")
@Data
public class Order implements Serializable{
    private Long id;
    //@Column(name="mid")
    private Long memberId;
    private String detail;
    private Long createTime;
    private String createTimeFmt;
}
