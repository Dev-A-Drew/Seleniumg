package junit5Test;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class AssertionsTests {

    @Test
    void assertEqualTest() {
        assertEquals("firstString", "secondString", "The String"+"values were not equals");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firtsString","secondString","thirdString");
        List<String> actualValues = Arrays.asList("firtsString","secondString","thirdString");
        assertEquals(expectedValues,actualValues);
    }

    @Test
    void assertArraysEaulasTest(){
        int[] expectedValues = {1,2,3};
        int[] actualValues ={1,2,3};
        assertArrayEquals(expectedValues,actualValues);
    }

    @Test
    void assertTrueAssertion(){
        assertFalse(false, "This boolean contition did evaluate to false");
        assertTrue(true,"This boolean condition did not evaluate to true");
    }

    @Test
    void assertThrowTest(){
        assertThrows(NullPointerException.class,null);
    }

    @Test
    void assertAllTest(){
        assertAll(
                () -> assertEquals("firstString", "secondString", "The String"+"values were not equals"),
                () -> assertThrows(NullPointerException.class,null),
                () -> assertTrue(false, "This boolean condition did not evaluate to true"));

    }

                                                //HARMCREST
    @Test
    void assertForMapTest(){
        Map<String, Integer> theMap= new HashMap<>();
        theMap.put("firstKey",1);
        theMap.put("secondKey",2);
        theMap.put("thirdKey",3);

        assertThat(theMap, hasValue(2));
        assertThat(theMap, hasKey("secondKey"));
    }

    @Test
    void assertForList(){
        List<String> theList = Arrays.asList("firstString", "secondString","thirdString");

        assertThat(theList, hasItem("thirdString"));
    }


    @Test
    void assertForAnyOf(){
        List<String> theList = Arrays.asList("firstString", "secondString","thirdString");
        assertThat(theList, anyOf(hasItem("firstString"), hasItem("noString")));
    }


    @Test
    void assertForAnyOrder(){
        List<String> theList = Arrays.asList("firstString", "secondString","thirdString");
        assertThat(theList, containsInAnyOrder("firstString","thirdString","secondString"));


    }


}
