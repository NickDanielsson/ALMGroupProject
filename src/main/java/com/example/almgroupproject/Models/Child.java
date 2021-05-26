package com.example.almgroupproject.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {

    @Id
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
