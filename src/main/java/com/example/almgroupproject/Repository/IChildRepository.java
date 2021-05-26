package com.example.almgroupproject.Repository;

import com.example.almgroupproject.Models.Child;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IChildRepository extends MongoRepository<Child, String> {

     Child findChildByFirstnameAndLastname(String firstname, String lastname);

     Child findChildByPresentIs(boolean isPresent);

     boolean findChildByFirstnameAndLastname(Child childToDelete);

}
