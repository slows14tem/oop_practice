package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcdefgh";  //8글자 생성하는 올바르게 구동되는 passwordGenerator
    }
}
