package org.example.calculator.operators;

public class PositiveNumber {
    //양수라는 것을 보장할 수 있는 클래스
    private final  int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNegativeNumber(value)){
            throw  new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt(){
        return value;
    }
}
