package testng_knowledge;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _10_Parameterization {

    @Parameters({"username", "password"})
    @Test
    public void login(String username, String password){
        System.out.println("Username comes from xml = " + username);
        System.out.println("Password comes from xml = " + password);
    }
}
