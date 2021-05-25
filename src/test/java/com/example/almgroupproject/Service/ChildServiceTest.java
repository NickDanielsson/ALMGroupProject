package com.example.almgroupproject.Service;

import com.example.almgroupproject.Models.Child;
import com.example.almgroupproject.Repository.IChildRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ChildServiceTest {

    ChildService cs;

    @Mock
    IChildRepository childRepository;

    @BeforeEach
    public void beforeEach() {cs = new ChildService(childRepository); }

    // Nina
    @Test
    void getAllChildren() {
    }
    // Nina
    @Test
    void getChild() {
    }
    // Peter
    @Test
    void saveChild() {
    }
    // Peter
    @Test
    void deleteChild() {
    }
    // Rune
    @Test //testar på barn som är närvarande respektive frånvarande.
    void isPresent() {

        Child mockChild = new Child("Mocke", "Mock");
        mockChild.setPresent(true);

        when(childRepository.findChildByFirstnameAndLastname(mockChild.getFirstname(),mockChild.getLastname()))
                .thenReturn(mockChild);

        assertEquals("Mocke Mock är närvarande", cs.isPresent("Mocke", "Mock"));


        mockChild.setPresent(false);

        assertEquals("Mocke Mock är frånvarande", cs.isPresent("Mocke", "Mock"));


    }

    // Rune
    @Test //testar på barn som är sjukanmält respektive friskanmält.
    void isSick() {

        Child mockChild = new Child("Mocke", "Mock");
        mockChild.setSick(true);

        when(childRepository.findChildByFirstnameAndLastname(mockChild.getFirstname(),mockChild.getLastname()))
                .thenReturn(mockChild);

        assertEquals("Mocke Mock är sjukanmäld", cs.isSick("Mocke", "Mock"));


        mockChild.setSick(false);

        assertEquals("Mocke Mock är friskanmäld", cs.isSick("Mocke", "Mock"));


    }
    // Thilnader
    @Test
    void leaveChild() {
    }
    // Thilander
    @Test
    void callInChildSick() {
    }
    // Nick
    @Test
    void pickUpChild() {
    }
    // Nick
    @Test
    void isNotSick() {
    }
}