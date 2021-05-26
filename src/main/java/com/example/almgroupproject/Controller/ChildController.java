package com.example.almgroupproject.Controller;

import com.example.almgroupproject.Models.Child;
import com.example.almgroupproject.Service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChildController {

    private final ChildService childService;

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/savechild")
    public String saveChild(@RequestBody Child child){

        childService.saveChild(child);
        return "Barn sparat";
    }

    @GetMapping("/getall")
    public List<Child> getAllChildren() {
        return childService.getAllChildren();
    }

    @GetMapping("/pickupchild")
    public Child pickUpChild(@RequestParam String firstname,@RequestParam String lastname){

       return childService.pickUpChild(firstname,lastname);

    }

    @GetMapping("/ispresent")
    public String isPresent(@RequestParam String firstname, @RequestParam String lastname){
        return childService.isPresent(firstname, lastname);
    }

    @GetMapping("/issick")
    public String isSick(@RequestParam String firstname, @RequestParam String lastname){
        return childService.isSick(firstname, lastname);
    }
  
    @GetMapping("/isnotsick")
    public Child isNotSick(@RequestParam String firstname,@RequestParam String lastname){

        return childService.isNotSick(firstname,lastname);

    }
}
