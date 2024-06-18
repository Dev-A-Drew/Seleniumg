package junit5Test;

import org.junit.jupiter.api.*;

public class MsicTest {

    @Test
    @Timeout(5)
    void timeout() throws InterruptedException {
        System.out.println("This is the test with the Time Out");
        Thread.sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is the nice method")
    @Tag("The tag")
    void annotatedMethod1(){
        System.out.println("This is the annotated method");
    }



    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest {
        @BeforeAll
        void beforeAll(){
            System.out.println("Before all in nested test");
        }

    @Test
    void nestedTestMethod(){
        System.out.println("Nested test method");
    }
    }

}
