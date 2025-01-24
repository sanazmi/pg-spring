package com.example.demo;
import java.security.SecureRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "https://github.com/sanazmi" , "https://pg-spring-production.up.railway.app"})
public class PasswordGeneratorController {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+[]{}|;:,.<>?";
    private final SecureRandom random = new SecureRandom();

    private String createRandomPassword(int length, boolean includeSpecialCharacters) {
        String characterSet = UPPER_CASE + LOWER_CASE + DIGITS + (includeSpecialCharacters ? SPECIAL_CHARACTERS : "");
        return random.ints(length, 0, characterSet.length())
                     .mapToObj(characterSet::charAt)
                     .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                     .toString();
    }

    @GetMapping("/generate-password")
    public String generatePassword(@RequestParam(defaultValue = "8") int length,
                                   @RequestParam(defaultValue = "true") boolean includeSpecialCharacters) {
        if (length < 1) {
            return "Password length must be greater than 0.";
        }
        return createRandomPassword(length, includeSpecialCharacters);
    }
}
