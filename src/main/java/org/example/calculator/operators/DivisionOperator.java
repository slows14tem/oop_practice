package org.example.calculator.operators;

public class DivisionOperator implements NewArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        //PositiveNumber에서 양수 검사를 해주기 때문에 필요없어진 코드
//        if(operand2.toInt() == 0){
//            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
//        }
        return operand1.toInt() / operand2.toInt();
    }
}
