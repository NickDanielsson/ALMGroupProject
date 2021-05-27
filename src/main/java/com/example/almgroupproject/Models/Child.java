package com.example.almgroupproject.Models;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {

    private String id;
    private String firstname;
    private String lastname;
    private boolean isPresent;
    private boolean isSick;

    public Child(String firstname, String lastname, boolean isPresent, boolean isSick) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.isPresent = isPresent;
        this.isSick = isSick;
    }

    public Child (String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }


}
