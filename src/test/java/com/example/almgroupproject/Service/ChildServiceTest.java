package com.example.almgroupproject.Service;

import com.example.almgroupproject.Models.Child;
import com.example.almgroupproject.Repository.IChildRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ChildServiceTest {

    ChildService cs;

    @Mock
    IChildRepository mockRepository;

    @BeforeEach
    public void beforeEach() {cs = new ChildService(mockRepository); }

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
    void saveChildSuccess() {
        String expectedFirstName = "Johan";
        String expectedLastName = "Rune";

        Child savingChild = new Child();
        savingChild.setFirstname(expectedFirstName);
        savingChild.setLastname(expectedLastName);

        when(mockRepository.save(any()))
                .thenReturn(savingChild);

        Child actual = cs.saveChild(savingChild);

        assertEquals(savingChild.getFirstname(), actual.getFirstname());
        assertEquals(savingChild.getLastname(), actual.getLastname());

        verify(mockRepository).save(any());
        verify(mockRepository).findChildByFirstnameAndLastname(anyString(), anyString());
    }
    // Peter
    @Test
    void deleteChild() {
        String expectedFirstName = "Johan";
        String expectedLastName = "Rune";

        Child savingChild = new Child();
        savingChild.setFirstname(expectedFirstName);
        savingChild.setLastname(expectedLastName);

        Child childToDelete=savingChild;

        cs.deleteChild(childToDelete);

        assertFalse(mockRepository.findChildByFirstnameAndLastname(savingChild));

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
    @DisplayName("pickUpChild change isPresent to false")
    void pickUpChild() {

        Child c = new Child("Alex", "Svensson");
        c.setPresent(true);
        System.out.println(c);

        when(childRepository.findChildByFirstnameAndLastname(c.getFirstname(),c.getLastname()))
                .thenReturn(c);

        Child actual = cs.pickUpChild(c.getFirstname(),c.getLastname());
        System.out.println(actual);

        assertFalse(actual.isPresent());
        assertEquals(c.getFirstname(),actual.getFirstname());
        assertEquals(c.getLastname(),actual.getLastname());


    }
    // Nick
    @Test
    @DisplayName("isSick changes to false when isNotSick is called")
    void isNotSick() {

        Child c = new Child("Alice", "Svensson");
        c.setSick(true);
        System.out.println(c);

        when(childRepository.findChildByFirstnameAndLastname(c.getFirstname(),c.getLastname()))
                .thenReturn(c);

        Child actual = cs.isNotSick(c.getFirstname(),c.getLastname());
        System.out.println(actual);

        assertFalse(actual.isPresent());
        assertEquals(c.getFirstname(),actual.getFirstname());
        assertEquals(c.getLastname(),actual.getLastname());
    }
}