package junit5Test;


import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTests {

    @RepeatedTest(5)
    void repetedtwo(){
        System.out.println("this is a test");
    }

    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}.  Total is: {totalRepetitions}")
    @DisplayName(value = "This is a repeated test method")
    void repeatedthree(){
        System.out.println("repeate a test");
    }

    @RepeatedTest(3)
    void thirdMethod(RepetitionInfo repetitionInfo){
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition()==3,() -> System.out.println("This code only runs for repetition 3"));
    }

    @RepeatedTest(7)
    void fourthTest(){
        System.out.println("this is the fourth test");
    }
}
