package Multithreading.Synchronizers.ExchangerExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class RockPaperScissors {
    private static final Exchanger<Action> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        List<Action> firstPlayersActions = new ArrayList<>();
        firstPlayersActions.add(Action.SCISSORS);
        firstPlayersActions.add(Action.PAPER);
        firstPlayersActions.add(Action.SCISSORS);

        List<Action> secondPlayersActions = new ArrayList<>();
        secondPlayersActions.add(Action.PAPER);
        secondPlayersActions.add(Action.ROCK);
        secondPlayersActions.add(Action.ROCK);

        new Player("Ilya", firstPlayersActions, exchanger);
        new Player("Vitaliy", secondPlayersActions, exchanger);

    }
}


class Player extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    private final String name;
    private final List<Action> myActions;
    private final Exchanger<Action> exchanger;

    public Player(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    @Override
    public void run() {
        Action reply;
        for (Action action: myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    private void whoWins(Action myAction, Action friendsAction) {
        if ((myAction == Action.ROCK && friendsAction == Action.SCISSORS)
        ||  (myAction == Action.SCISSORS && friendsAction == Action.PAPER)
        ||  (myAction == Action.PAPER && friendsAction == Action.ROCK)) {
            logger.info(name + " WINS!!!");
        }
    }
}


enum Action {
    ROCK,
    SCISSORS,
    PAPER
}