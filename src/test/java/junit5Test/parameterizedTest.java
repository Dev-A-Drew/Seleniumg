package junit5Test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class parameterizedTest {


                    //Parameterized test using Data
    @ParameterizedTest(name = "Run:{index} - value:{arguments}")
    @ValueSource(ints ={1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = "+ theParam);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings ={"First String","Second String"})
    void stringValues(String strings){
        System.out.println("theParam: "+strings);
    }

    @ParameterizedTest
    @CsvSource(value={"steve,Rogers","captain,marvel","bucky,barnes"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1= "+ param1+ " param2= "+param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true","Captian,21,false","Bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("Param1= "+param1+"Param2= "+param2+"Param3= "+param3);
    }
    @ParameterizedTest
    @CsvSource(value = {"captian america,'Steve, Rogers'", "Winter Soldier,"+"'Bucky, Barnes'"})
    void csv_Source_StringWithComa(String param1, String param2){
        System.out.println("Param1= "+param1+" Param2= "+param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"Steve?Rogers","Bucky?Barnes"},delimiter = '?')
        void csvSource_StringWithDiffDelimiter(String param1, String param2){
            System.out.println("Param1= "+param1+", Param2= "+param2);

    }

                        //Parameterized Test Using CVS files

    @ParameterizedTest
    @CsvFileSource(files ={"src/test/resources/params/shoppinglist.csv","src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name,double price,int qty, String uom, String provider){
        System.out.println("name = "+name+",price = "+price+",qty = "+qty+",uom = "+uom+",provider = "+provider);
    }

    @ParameterizedTest
    @CsvFileSource(files ="src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1,delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name,double price,int qty, String uom, String provider){
        System.out.println("name = "+name+",price = "+price+",qty = "+qty+",uom = "+uom+",provider = "+provider);
    }


                                                        //Parameterized Test

    @ParameterizedTest
    @MethodSource(value ="sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = "+param1);
    }


    List<String> sourceString() {
        //Processing done here
    return Arrays.asList("tomato","carrot","cabbage");
    }


    @ParameterizedTest
    @MethodSource(value ="sourceStringAsSteam")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = "+param1);
    }
    Stream<String> sourceStringAsSteam(){
        return Stream.of("beetroot","apple", "pear");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1 = "+param1+" , param2 = "+param2);
    }


    List<Arguments> sourceList_StringDouble(){
        return Arrays.asList(arguments("tomatoes", 2.0),
                             arguments("carrots", 4.5),
                             arguments("cabbage", 7.8));
    }
}
