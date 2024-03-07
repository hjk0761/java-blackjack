package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @DisplayName("트럼프 카드 덱을 초기화한다.")
    @Test
    void initDeckTest() {
        // When
        Deck deck = Deck.init();

        // Then
        assertThat(deck).isNotNull();
    }

    @DisplayName("카드를 한 장 건네준다.")
    @Test
    void drawnTest() {
        // Given
        Deck deck = Deck.init();

        // When
        PlayingCard card = deck.drawn();

        // Then
        assertThat(card).isNotNull();
    }

    @DisplayName("덱에 카드가 모두 소진되었다면 true를 반환한다.")
    @Test
    void isEmptyTest() {
        // Given
        Deck deck = new Deck(List.of());

        // When
        boolean isEmpty = deck.isEmpty();

        // Then
        Assertions.assertThat(isEmpty).isTrue();
    }
}
