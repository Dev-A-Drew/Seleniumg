package junit5Test;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {

    @BeforeAll
    void beforeAll(){
        System.out.println("--This is the before All method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----This is the before Each method");
    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the after All method");
    }

    @AfterEach
    void afterEach(){
        System.out.println("----This is the After Each method");
    }

    @Test
    //@Order(2)
    @DisplayName("5th test")
    void firstMethod(){
        System.out.println("this is the first test method ");
    }

    @Test
    @DisplayName("SecondMethod - TC1 - This method is the second one ")
    void secondMethod(){
        System.out.println("This is the second test method ");
    }

    @Test
    //@Order(1)
    @DisplayName("Firsts Method")
    void thirdTest(){
        System.out.println("This is the third test method");
    }

}
