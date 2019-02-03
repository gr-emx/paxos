package com.gaurav.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractIntegrationTest {
    @Autowired
    PaxosApplication paxosApplication;

    @Test
    public void testFooHashing() {
        String hash = paxosApplication.getHashAndStoreInRepository("foo");
        String expectedHash = "2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae";
        Assert.assertTrue(hash.equals(expectedHash));

        String original = paxosApplication.getOriginalMessage(expectedHash);
        Assert.assertEquals(original,"foo");
    }
}
