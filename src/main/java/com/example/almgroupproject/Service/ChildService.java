package com.example.almgroupproject.Service;


import com.example.almgroupproject.Models.Child;
import com.example.almgroupproject.Repository.IChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

   public String saveChild(String firstname, String lastname) {
       Child child = new Child(firstname,lastname);
       childRepository.save(child);
       return "Nytt barn sparat med namn " +firstname + " " +lastname;
   }

   public String deleteChild (String firstname, String lastname) {
       Child childToRemove = getChild(firstname,lastname);
       childRepository.delete(childToRemove);
       return "Barnet " + firstname + " " +lastname + " togs bort från databasen";
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
        return firstname + " " + lastname + " är inlämnat";
    }

    public String callInChildSick (String firstname, String lastname){
        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        currentChild.setSick(true);
        childRepository.save(currentChild);
        return firstname + " " + lastname + " är sjukanmäld";
    }

    public String pickUpChild (String firstname, String lastname){
        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        currentChild.setPresent(false);
        childRepository.save(currentChild);
        return firstname + " " + lastname + " är hämtad";
    }

    public String isNotSick (String firstname, String lastname){
        Child currentChild = childRepository.findChildByFirstnameAndLastname(firstname,lastname);
        currentChild.setSick(false);
        childRepository.save(currentChild);
        return firstname + " " + lastname + " är friskanmäld";
    }

}
