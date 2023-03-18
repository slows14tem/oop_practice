package org.example.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class Menutest {

    @DisplayName("메뉴판에서 메뉴 이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        MenuItem menuItem = menu.choose("돈까스");

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
    }

    @DisplayName("메뉴판에 없는 메뉴를 선택할 시 예외를 반환한다.")
    @Test
    void chooesTest2() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        assertThatCode(() -> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");   //이 메세지가 choose메소드의 메세지와 다르면 오류가 발생함.
    }
}
