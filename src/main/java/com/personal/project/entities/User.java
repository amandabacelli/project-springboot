package com.personal.project.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
}
