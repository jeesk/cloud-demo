package com.shanjiancaofu.userserver.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private Long id;
    private String name;

}
