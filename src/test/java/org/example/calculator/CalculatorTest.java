package org.example.calculator;

import org.example.calculator.operators.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
요구사항
간단한 사칙연산을 할 수 있다.
양수로만 계산할 수 있다.
나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
MVC패턴(Model-View-Controller) 기반으로 구현한다.
*/
public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculatorTest(int operand1, String operator, int operand2, int result) {
        //calculator에게 계산 작업을 위임
        int calculatorResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        assertThat(calculatorResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

    //PositiveNumber에서 음수 체크 해주기 때문에 필요없어진 test code
//    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
//    @Test
//    void calculateExceptionTest() {
//        assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("0으로 나눌 수 없습니다.");
//    }
}

//'assertThat'까지만 치면 import가 안뜬다. 'assertThat()'까지 처야됨