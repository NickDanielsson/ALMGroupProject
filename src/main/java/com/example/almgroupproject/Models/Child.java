package com.example.almgroupproject.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {

    private String id;
    private String firstname;
    private String lastname;
    private boolean isPresent = false;
    private boolean isSick = false;

    public Child (String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
}
