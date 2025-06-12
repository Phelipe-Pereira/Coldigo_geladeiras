package com.example.projetotrilhawebinte.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.example.projetotrilhawebinte.rest");
    }
} 