import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JUnittest {
String message = "BrowserStack is the intended message";

@Test 
public void testMessage() {
    System.out.println("Inside testMessage()");
    Bank b;
    b = new Bank(2);
    Player player = new Player("Bob", 18, 2); 
    b.giveMoney(player,1);
    assertEquals(3,player.account.getBalance());
    }
}