package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/*
* 비밀번호는 최소 8자 이상 12자 이하여야 한다.
  비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
• 경계조건에 대해 테스트 코드를 작성해야 한다.(여기서는 7자 혹은 13자)
* */
public class PasswordValidatorTest {
    @DisplayName("비밀번호가 최소 8자 이상 12자 이하면 예외가 발생하지 않는다.")
    //테스트코드의 의도를 나타낼 수 있음
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();    //위의 함수가 실행되었을 떄 어떠한 오류도 발생하지 않음
    }

    @DisplayName("비밀번호가 8자리 미만 또는 12자 초과하는 경우 IllegalArgumentException예외가 발생한다.")
    @ParameterizedTest  //경계값에 대한 테스트 코드(링크 보면서 사용법 공부)
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}


//test code
//generate 단축키 alt + insert
//ParameterizedTest 사용법 = https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-parameterized-tests/