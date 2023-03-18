package org.example.grade;

import java.util.List;

//일급 컬랙션 이란
/* Collection을 Wrapping하면서, 그 외 다른 멤버 변수가 없는 상태를 일급 컬렉션이라 합니다.
Wrapping 함으로써 다음과 같은 이점을 가지게 됩니다.

비지니스에 종속적인 자료구조
Collection의 불변성을 보장
상태와 행위를 한 곳에서 관리
이름이 있는 컬렉션 */
//https://jojoldu.tistory.com/412
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
