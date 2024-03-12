package domain;

import domain.constant.GameResult;
import domain.participant.Dealer;
import domain.participant.Participant;
import domain.participant.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackJackGame {
    public static final int BLACKJACK_CONDITION = 21;

    private final Deck deck;

    public BlackJackGame(final Deck deck) {
        this.deck = deck;
    }

    public void firstDraw(final Dealer dealer, final List<Player> players) {
        for (int gameCount = 0; gameCount < 2; gameCount++) {
            players.forEach(player -> player.draw(deck));
            dealer.draw(deck);
        }
    }

    public void drawForParticipant(final Participant participant) {
        participant.draw(deck);
    }

    public GameResults getGameResults(final Dealer dealer, final List<Player> players) {
        Map<Player, GameResult> playerGameResults = new HashMap<>();

        players.forEach(player -> match(dealer, player, playerGameResults));

        return new GameResults(playerGameResults);
    }

    private void match(final Dealer dealer, final Player player, final Map<Player, GameResult> playerGameResults) {
        if (dealer.isDealerWin(player)) {
            dealerWin(player, playerGameResults);
            return;
        }
        dealerLose(player, playerGameResults);
    }

    private void dealerWin(final Player player, final Map<Player, GameResult> playerGameResults) {
        playerGameResults.put(player, GameResult.LOSE);
    }

    private void dealerLose(final Player player, final Map<Player, GameResult> playerGameResults) {
        if (player.isBlackJack()){
            playerGameResults.put(player, GameResult.WIN_BY_BLACKJACK);
        }
        playerGameResults.put(player, GameResult.WIN);
    }
}
