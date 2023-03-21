package net.javaguides.sms;

import net.javaguides.sms.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdaApplication {

    @Autowired
    private OrganizationRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SdaApplication.class, args);
    }

}