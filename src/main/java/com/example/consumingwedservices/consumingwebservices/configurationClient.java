package com.example.consumingwedservices.consumingwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class configurationClient {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.example.ws.numberconversion");
        return marshaller;
    }

    @Bean
    public convertClient book(Jaxb2Marshaller marshaller) {
        convertClient client = new convertClient();
        client.setDefaultUri("http://www.dataaccess.com/webservicesserver/");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}