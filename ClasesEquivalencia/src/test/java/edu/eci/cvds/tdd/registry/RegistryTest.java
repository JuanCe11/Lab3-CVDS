package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();
/*
    @Test
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        fail(Assert.assertEquals(RegisterResult.VALID, result));
    }
   */ 
    @Test
    public void validarPersonaViva() {

        Person person = new Person("Sebastian Herrera", 123, 20 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validarPersonaMuerta() {

        Person person = new Person("Sebastian Herrera", 123, 20 , Gender.MALE, false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    
    @Test
    public void validarPersonaNoNacida() {

        Person person = new Person("Sebastian Herrera", 123, -20 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void validarPersonaNoNacidaLimite() {

        Person person = new Person("Sebastian Herrera", 123, 0 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test
    public void validarPersonaMenorEdad() {

        Person person = new Person("Sebastian Herrera", 123, 2 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    
    @Test
    public void validarPersonaEdaden17() {

        Person person = new Person("Sebastian Herrera", 123, 17 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    
    @Test
    public void validarPersonaEdaden18() {

        Person person = new Person("Sebastian Herrera", 123, 18 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validarPersonaMayordeEdad() {

        Person person = new Person("Sebastian Herrera", 123, 50 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validarIDValido() {

        Person person = new Person("Sebastian Herrera", 123, 50 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validarIDInvalido() {

        Person person = new Person("Sebastian Herrera", -123, 50 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_ID, result);
    }
    
    @Test
    public void validarIDInvalidoLimite() {

        Person person = new Person("Sebastian Herrera", 0, 50 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_ID, result);
    }
    
    @Test
    public void validarNombreInvalido() {

        Person person = new Person("Sebastian", 20, 50 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_NAME, result);
    }
    
    @Test
    public void validarNombreInvalidoLimite() {

        Person person = new Person("Sebastian ", 20, 50 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_NAME, result);
    }
    
    @Test
    public void validarNombreValido() {

        Person person = new Person("Sebastian Herrera", 20, 50 , Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
}