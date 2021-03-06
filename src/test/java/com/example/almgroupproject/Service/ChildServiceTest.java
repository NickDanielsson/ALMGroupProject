package com.example.almgroupproject.Service;

import com.example.almgroupproject.Models.Child;
import com.example.almgroupproject.Repository.IChildRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

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
        String firstName = "Anna";
        String lastName = "Andersson";
        Child mockChild = new Child(firstName, lastName);

        when(mockRepository.findAll())
                .thenReturn(Arrays.asList(mockChild));

        List<Child> actual = cs.getAllChildren();

        assertEquals(mockChild.getFirstname(), actual.get(0).getFirstname());
        assertEquals(mockChild.getLastname(), actual.get(0).getLastname());
        assertEquals(1, actual.size());

        verify(mockRepository).findAll();
    }

    // Nina
    @Test
    void getChild() {
        String firstName = "Sara";
        String lastName = "Holm";
        Child mockChild = new Child(firstName, lastName);

        when(mockRepository.save(any()))
                .thenReturn(mockChild);

        Child actual = cs.saveChild(new Child("Sara", "Holm"));

        assertEquals(mockChild.getFirstname(), actual.getFirstname());
        assertEquals(mockChild.getLastname(), actual.getLastname());

        verify(mockRepository).save(any());
    }

    // Peter
    @Test
    void saveChildSuccess() {
        String expectedFirstName = "Nils";
        String expectedLastName = "Persson";

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
        String expectedFirstName = "Kalle";
        String expectedLastName = "Andersson";

        Child savingChild = new Child();
        savingChild.setFirstname(expectedFirstName);
        savingChild.setLastname(expectedLastName);

        when(mockRepository.findChildByFirstnameAndLastname(savingChild.getFirstname(),savingChild.getLastname()))
                .thenReturn(savingChild);

        Child childToDelete = cs.deleteChild(savingChild);

        assertEquals(savingChild.getFirstname(), childToDelete.getFirstname());
        assertFalse(mockRepository.findChildByFirstnameAndLastname(childToDelete));
        verify(mockRepository).findChildByFirstnameAndLastname(savingChild.getFirstname(), savingChild.getLastname());

    }


    // Rune
    @Test //testar p?? barn som ??r n??rvarande respektive fr??nvarande.
    void isPresent() {

        Child mockChild = new Child("Mocke", "Mock");
        mockChild.setPresent(true);

        when(mockRepository.findChildByFirstnameAndLastname(mockChild.getFirstname(),mockChild.getLastname()))
                .thenReturn(mockChild);

        assertEquals("Mocke Mock ??r n??rvarande", cs.isPresent("Mocke", "Mock"));


        mockChild.setPresent(false);

        assertEquals("Mocke Mock ??r fr??nvarande", cs.isPresent("Mocke", "Mock"));


    }

    // Rune
    @Test //testar p?? barn som ??r sjukanm??lt respektive friskanm??lt.
    void isSick() {

        Child mockChild = new Child("Mocke", "Mock");
        mockChild.setSick(true);

        when(mockRepository.findChildByFirstnameAndLastname(mockChild.getFirstname(),mockChild.getLastname()))
                .thenReturn(mockChild);

        assertEquals("Mocke Mock ??r sjukanm??ld", cs.isSick("Mocke", "Mock"));


        mockChild.setSick(false);

        assertEquals("Mocke Mock ??r friskanm??ld", cs.isSick("Mocke", "Mock"));


    }

    // Thilander
    @Test
    void leaveChild() {
        // ARRANGE
        Child c = new Child("Donald", "Trump");
        c.setPresent(true);
        when(mockRepository.findChildByFirstnameAndLastname(c.getFirstname(),c.getLastname())).thenReturn(c);

        // ACT
        String actual = cs.leaveChild(c.getFirstname(), c.getLastname());

        // ASSERT
        assertEquals("Donald Trump ??r inl??mnad", actual);

    }

    // Thilander
    @Test
    void callInChildSick() {
        // ARRANGE
        Child c = new Child("Donald", "Trump");
        c.setSick(true);
        when(mockRepository.findChildByFirstnameAndLastname(c.getFirstname(),c.getLastname())).thenReturn(c);

        // ACT
        String actual = cs.callInChildSick(c.getFirstname(), c.getLastname());

        // ASSERT
        assertEquals("Donald Trump ??r sjukanm??ld", actual);

    }

    // Nick
    @Test
    @DisplayName("pickUpChild change isPresent to false")
    void pickUpChild() {

        Child c = new Child("Alex", "Svensson");
        c.setPresent(true);
        System.out.println(c);

        when(mockRepository.findChildByFirstnameAndLastname(c.getFirstname(),c.getLastname()))
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

        when(mockRepository.findChildByFirstnameAndLastname(c.getFirstname(),c.getLastname()))
                .thenReturn(c);

        Child actual = cs.isNotSick(c.getFirstname(),c.getLastname());
        System.out.println(actual);

        assertFalse(actual.isSick());
        assertEquals(c.getFirstname(),actual.getFirstname());
        assertEquals(c.getLastname(),actual.getLastname());
    }
}