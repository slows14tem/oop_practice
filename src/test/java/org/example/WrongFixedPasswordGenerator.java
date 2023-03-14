package org.example;

public class WrongFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {

        return "ab";  //8글자 생성하는 올바르게 구동되는 passwordGenerator
    }
}
