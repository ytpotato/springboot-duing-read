package com.duing.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -942312135048096498L;

    private Long id;
    private String name;
    private String password;
    private Integer age;
}
