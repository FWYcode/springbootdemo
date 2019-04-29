package com.it.pojo.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 2019/4/22 0022.
 */
@Data
@Table(name="student")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuid;
    @Column(name = "sname")
    private String sname;
    @Column(name = "score")
    private int score;
    @Column(name = "sex")
    private boolean sex;

}
