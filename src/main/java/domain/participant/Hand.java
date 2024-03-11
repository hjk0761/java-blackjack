package domain.participant;

import domain.PlayingCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.BlackJackGame.BLACKJACK_CONDITION;

public class Hand {
    private final List<PlayingCard> playingCards;

    private Hand(final List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    public static Hand init() {
        return new Hand(new ArrayList<>());
    }

    public int getCardsNumberSum() {
        int result = 0;
        for (PlayingCard playingCard : playingCards) {
            result += playingCard.getValue(result);
        }
        return result;
    }

    public boolean isNotBurst() {
        return getCardsNumberSum() <= BLACKJACK_CONDITION;
    }

    public void addCard(final PlayingCard card) {
        playingCards.add(card);
    }

    public List<PlayingCard> getPlayingCards() {
        return Collections.unmodifiableList(playingCards);
    }

    public boolean isNotMaximum() {
        return getCardsNumberSum() != BLACKJACK_CONDITION;
    }
}
