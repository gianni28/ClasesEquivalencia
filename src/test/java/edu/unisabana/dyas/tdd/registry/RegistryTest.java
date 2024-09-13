package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class RegistryTest {
    private Registry registry;
    private Set<Integer> registeredIds;

    @Before
    public void setUp() {
        registry = new Registry();
        registeredIds = new HashSet<>();
    }

    @Test
    public void testUnderagePerson() {
        Person person = new Person("John Doe", 123456, 17, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void testDeceasedPerson() {
        Person person = new Person("Jane Doe", 654321, 30, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void testInvalidAgePerson() {
        Person person = new Person("John Doe", 12345, -1, Gender.MALE, true); // Edad inválida (-1)
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result); // Esperado INVALID_AGE
    }


    @Test
    public void testValidPerson() {
        Person person = new Person("Valid Person", 222222, 25, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void testDuplicatedId() {
        Person person1 = new Person("First Person", 333333, 40, Gender.FEMALE, true);
        Person person2 = new Person("Second Person", 333333, 30, Gender.MALE, true);
        registry.registerVoter(person1);
        RegisterResult result = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
}
