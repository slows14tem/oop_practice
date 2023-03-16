package org.example.calculator;

import org.example.calculator.operators.*;

import java.util.List;

public class Calculator {

    //1. 계산을 수행하지 않고 ArithmeticOperator라는 enum을 만들어 다시 작업을 ArithmeticOperator의 calculate에 위임해서 계산된 값을 리턴
    //객체끼리의 협력 구조
//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1, operator, operand2);
//    }


    //2. addition, subtraction, multiplication, division 4개의 구현체를 NewArithmeticOperator 인터페이스로 받는다.
    //calculate method에 입력된 operator에 맞는 구현체를 찾아서 그 구현체에게 calculate작업을 위임한다.
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))  //filter에서 arithmeticOperators.supports(operator)가 true인것만 필터링
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))    //필터링 된 값에 calculate 계산 수행
                .findFirst()    //filter 조건에 일치하는 element 1개를 Optional로 리턴, 일치 요소 없으면 empty 리턴
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
