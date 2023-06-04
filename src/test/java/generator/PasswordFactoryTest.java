package generator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class PasswordFactoryTest {
    PasswordFactory passwordFactory = new PasswordFactory();

    @Test
    public void testMain() {
        PasswordFactory.main(new String[]{"args"});
    }

    @Test
    public void testGenerateSecurePassword_returnsRandomPassword() {
        String result = PasswordFactory.generateSecurePassword();
        // test regex to ensure random password is generated
        Assert.assertTrue(result.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{32}$"));
    }


    @Test
    public void testGetRandomSpecialChars() {
        Stream<Character> result = PasswordFactory.getRandomSpecialChars(0);
        Assert.assertEquals(result, null);
    }

    @Test
    public void testGetRandomNumbers_returnsRandomNumbers() {
        Stream<Character> result = PasswordFactory.getRandomNumbers(0);
        Assert.assertEquals(result, null);
    }

    @Test
    public void testGetRandomAlphabets() {
        Stream<Character> result = PasswordFactory.getRandomAlphabets(0, true);
        Assert.assertEquals(result, null);
    }

    @Test
    public void testToString() {
        String result = passwordFactory.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }
}
