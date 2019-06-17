package com.digipet.prototype.api.twitter;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwitterManagerTest {

    @Test
    public void tweet() {
        TwitterManager.tweet("Hola Twitter!");
    }
}