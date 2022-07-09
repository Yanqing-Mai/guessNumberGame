package serviceTest;

import com.ym.guessnumber.service.StartGameService;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class StartGameServiceTest {


    StartGameService startGameService = new StartGameService();
    @Test
    public void generateAnswerTest(){
        int num = startGameService.generateAnswer();
        Set<Integer> set = new HashSet<>();
        while(num > 0){
            int pop = num % 10;
            num /= 10;
            set.add(pop);
        }
        Assert.assertEquals(4,set.size());
    }
}
