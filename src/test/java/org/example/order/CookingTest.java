package org.example.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CookingTest {

    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {

        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("돈까스", 5000);

        Cook cook = cooking.makeCook(menuItem);

        //객체들 끼리 비교할때는 equals() and hashCode()가 있어야 함.
        //Cook class에서 alt + insert -> equals() and hashCode()
        assertThat(cook).isEqualTo(new Cook("돈까스", 5000));

    }
}
