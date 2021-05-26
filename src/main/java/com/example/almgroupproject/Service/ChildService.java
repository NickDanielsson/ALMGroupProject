package com.example.almgroupproject.Service;


import com.example.almgroupproject.Models.Child;
import com.example.almgroupproject.Repository.IChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChildService {
   private final IChildRepository childRepository;

    public List<Child> getAllChildren(){
       return childRepository.findAll();
   }

   public Child getChild (String firstname, String lastname) {
       return childRepository.findChildByFirstnameAndLastname(firstname, lastname);
   }

   public Child saveChild(Child child) {
       Child found = childRepository.findChildByFirstnameAndLastname(child.getFirstname(), child.getLastname());
       if (found==child) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Child already exists.");
       }
       return childRepository.save(child);
   }

   public Child deleteChild (Child child) {
       Child found = childRepository.findChildByFirstnameAndLastname(child.getFirstname(), child.getLastname());
       if (found==null) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Child dont exist.");
       }
       childRepository.delete(found);
       return found;
   }

   public String isPresent(String firstname, String lastname){
       Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
       if (currentChild.isPresent()){
           return firstname + " " + lastname + " är närvarande";
       }
       return firstname + " " + lastname + " är frånvarande";
   }

    public String isSick(String firstname, String lastname){
        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        if (currentChild.isSick()){
            return firstname + " " + lastname + " är sjukanmäld";
        }
        return firstname + " " + lastname + " är friskanmäld";
    }

    public String leaveChild (String firstname, String lastname){
        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        currentChild.setPresent(true);
        childRepository.save(currentChild);
        return firstname + " " + lastname + " är inlämnad";
    }

    public String callInChildSick (String firstname, String lastname){
        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        currentChild.setSick(true);
        childRepository.save(currentChild);
        return firstname + " " + lastname + " är sjukanmäld";
    }

    public Child pickUpChild (String firstname, String lastname){

        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        if (currentChild == null){
            throw new NullPointerException("Child could not be found");
        }
        currentChild.setPresent(false);
        childRepository.save(currentChild);
        return currentChild;
    }

    public Child isNotSick (String firstname, String lastname){
        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        if (currentChild == null){
            throw new NullPointerException("Child could not be found");
        }
        currentChild.setSick(false);
        childRepository.save(currentChild);
        return currentChild;
    }

}
