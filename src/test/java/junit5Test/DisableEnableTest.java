package junit5Test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Locale;

public class DisableEnableTest {

    @Test
    @Disabled(value = "Disable for demo of @disabled")
    void firstTest(){
        System.out.println("This is the fists test method ");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS,disabledReason = "Disable for demo of @Disable")
    void secondTest(){
        System.out.println("This is the second test method ");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "Disabled for demo @Disable")
    void thirdTest(){
        System.out.println("This is the third test method ");
    }

    @Test
    @DisabledIf(value = "provider",disabledReason = "Disabled for demo of @DisableIf")
    void fourthTest(){
        System.out.println("This is the fourth test method ");
    }

    @Test
    void fifthTest(){
        System.out.println("This is the fifth test method ");
    }

    boolean provider(){
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.THURSDAY);
    }

    @RepeatedTest(5)
    void firstRepeatedTestMethod(){
        System.out.println("We are repeating this test");
    }
}
