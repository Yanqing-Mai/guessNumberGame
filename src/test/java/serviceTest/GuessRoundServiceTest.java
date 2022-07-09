package serviceTest;

import com.ym.guessnumber.service.GuessRoundService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GuessRoundServiceTest {

    GuessRoundService guessRoundService = new GuessRoundService();

    @Test
    public void calculateResultTest() {
        String result = guessRoundService.calculateResult("1234", "1357");

        Assert.assertEquals("E:P:0:0", result);
    }


}
