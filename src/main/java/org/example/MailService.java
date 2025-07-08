package org.example;

public interface MailService {
    public static void sendTo(String email) {
        System.out.println("Email sent to " + email);
    }
}