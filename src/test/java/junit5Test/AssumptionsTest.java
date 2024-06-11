package junit5Test;

import org.junit.jupiter.api.Assumptions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionsTest {

    @ParameterizedTest(name = "Run:{index} - value:{arguments}")
    @ValueSource(ints ={1,5,6})
    void intValues(int theParam){
        Assumptions.assumeTrue(theParam>4);
        System.out.println("theParam = "+ theParam);
    }

    @ParameterizedTest
    @CsvSource(value={"steve,Rogers","captain,marvel","bucky,barnes"})
    void csvSource_StringString(String param1, String param2){
        Assumptions.assumeFalse(param1.equals("steve"),"The assumption failed for the following param2: "+param2);
        System.out.println("param1= "+ param1+ " param2= "+param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true","Captian,21,false","Bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        Assumptions.assumingThat(param2>20,() -> System.out.println("This code ran"));
        System.out.println("Param1= "+param1+"Param2= "+param2+"Param3= "+param3);
    }


}
