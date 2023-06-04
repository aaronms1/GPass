package generator;

import org.testng.Assert;
import org.testng.annotations.Test;
public class PasswordFactoryTest {
    generator.PasswordFactory passwordFactory= new generator.PasswordFactory();

    @Test
    public void testMain(){
        PasswordFactory.main(new java.lang.String[]{"args"});
    }

    @Test
    public void testGenerateSecurePassword(){
        java.lang.String result = PasswordFactory.generateSecurePassword();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetRandomSpecialChars(){
        java.util.stream.Stream<java.lang.Character> result = PasswordFactory.getRandomSpecialChars(0);
        Assert.assertEquals(result, null);
    }

    @Test
    public void testGetRandomNumbers(){
        java.util.stream.Stream<java.lang.Character> result = PasswordFactory.getRandomNumbers(0);
        Assert.assertEquals(result, null);
    }

    @Test
    public void testGetRandomAlphabets(){
        java.util.stream.Stream<java.lang.Character> result = PasswordFactory.getRandomAlphabets(0, true);
        Assert.assertEquals(result, null);
    }

    @Test
    public void testToString(){
        java.lang.String result = passwordFactory.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme