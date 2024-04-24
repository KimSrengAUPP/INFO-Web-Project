package com.example.project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {
	public static String generateBcryptPassword(String plainTextPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(plainTextPassword);
    }
    
    public static void main(String[] args) {
        String password = "admin";
        
        String hashedPassword = generateBcryptPassword(password);
        
        System.out.println("Original password: " + password);
        System.out.println("Hashed password: " + hashedPassword);
    }
}
