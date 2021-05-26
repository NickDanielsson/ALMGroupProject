package com.example.almgroupproject.Controller;

import com.example.almgroupproject.Models.Child;
import com.example.almgroupproject.Service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ChildController {

    private final ChildService childService;

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/savechild")
    public void saveChild(@RequestBody Child child){

        childService.saveChild(child);
    }
    @PostMapping("/deletechild")
    public void deleteChild(@RequestBody Child child) {

        childService.deleteChild(child);

    }
}
