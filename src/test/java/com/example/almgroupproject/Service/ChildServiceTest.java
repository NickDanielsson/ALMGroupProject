package com.example.almgroupproject.Service;

import com.example.almgroupproject.Repository.IChildRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
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
    @Test
    void isPresent() {
    }
    // Rune
    @Test
    void isSick() {
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