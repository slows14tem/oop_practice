package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        //given
        User user = new User();

        //when
//        user.initPassword(new CorrectFixedPasswordGenerator());
        //PasswordGenerator 인터페이스가 하나의 함수를 가지는 FunctionalInterface라서 위처럼 할필요 없이 람다를 사용가능
        user.initPassword(() -> "abcdefgh");

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화 되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();

        //when
//        user.initPassword(new WrongFixedPasswordGenerator());
        user.initPassword(() -> "ab");

        //then
        assertThat(user.getPassword()).isNull();
    }
}