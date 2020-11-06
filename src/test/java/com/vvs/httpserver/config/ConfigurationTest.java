package com.vvs.httpserver.config;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.vvs.httpserver.config.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    private Configuration config = new Configuration();

    @Test
    void setPort() {
        config.setPort(5000);
        assertEquals(5000,config.getPort());
    }

    @Test
    void getPort() {
        config.setPort(8080);
        assertEquals(8080,config.getPort());
    }

    @Test
    void setWebroot() {
        config.setWebroot("webroot");
        assertEquals("webroot",config.getWebroot());
    }

    @Test
    void getWebroot() {
        config.setWebroot("tmp");
        assertEquals("tmp",config.getWebroot());
    }

    @After
    public void free() {
        config = null;
    }
}