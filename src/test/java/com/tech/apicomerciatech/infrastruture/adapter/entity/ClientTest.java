package com.tech.apicomerciatech.infrastruture.adapter.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClientTest {

    @Test
    void testClient() {
        Client client = new Client(1L);
        client.setName("John Doe");
        client.setLoyaltyPoints(100);
        assertAll(
                () ->  assertEquals(1L, client.getId()),
                ()-> assertEquals("John Doe", client.getName()),
                ()-> assertEquals(100, client.getLoyaltyPoints())
        );
    }

}