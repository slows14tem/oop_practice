package org.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

/* • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
• MVC패턴(Model-View-Controller) 기반으로 구현한다.
• 일급 컬렉션 사용 */
public class GradeCalculatorTest {
    //1. 도메인을 구성하는 객체에 어떤 것들이 있는지 고민
        //학점 계산기에 필요한 도메인 : 이수한 과목, 학점 계산기 (모든 객체를 다 도출하지 않음)
    //2. 객체들 간의 관계를 고민
        //이수한 과목으로 학점 계산??
    //3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
        //객체지향 프로그래밍, 자료구조, 중국어회화 (동적 객체) -> 과목(코스) 클래스(정적 타입)로 표현 가능
    //4. 객체들을 포괄하는 타입에 적절한 책임을 할당
        //이수한 과목을 인자로 전달하여 평균학점 계산 요청 -> 학점 계산기 -> (학점수+교과목 평점)의 합계 -> 과목(코스)에게 계산 요청


    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP",3,"A+"),
                new Course("자료구조",3,"A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }
}

//먼저 테스트가 통과되도록 만든 후에 본래의 로직을 채워넣는 순서