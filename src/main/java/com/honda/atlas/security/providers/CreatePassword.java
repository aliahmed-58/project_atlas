package com.honda.atlas.security.providers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CreatePassword {

    public static void main(String[] args) {

        BCryptPasswordEncoder x =  new BCryptPasswordEncoder();
        String pass = "test";
        String z = x.encode(pass);
        System.out.println(z);
        System.out.println(x.matches(pass, "$2a$10$Y37ke6jI7KgKzM5Kl21vZ.3q1k4rHhCFyC34Elf43T.WRbQ4Tb4VS"));
    }
}
