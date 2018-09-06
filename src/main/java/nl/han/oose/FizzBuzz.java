package nl.han.oose;

import org.ajbrown.namemachine.NameGenerator;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    private List<String> players = new ArrayList<>();
    private NameGenerator nameGenerator = new NameGenerator();

    public void addPlayer(String name) {
        this.players.add(name);
    }

    public void addRandomPlayer() {
        players.add(nameGenerator.generateName().getFirstName());
    }

    public void play(int limit) {
        if (players.isEmpty()) {
            IllegalStateException exception = new IllegalStateException("No players found.");
            throw exception;
        }

        for (int i = 1; i <= limit; i++) {
            int index = (i - 1) % players.size();
            System.out.println(players.get(index) + " says " + printWordOnPosition(i));
        }

    }

    String printWordOnPosition(int number) {
        if (numberIsMultipleOfThree(number) && numberIsMultipleOfFive(number)) {
            return "FizzBuzz";
        } else if (numberIsMultipleOfFive(number)) {
            return "Buzz";
        } else if (numberIsMultipleOfThree(number)) {
            return "Fizz";
        } else {
            return Integer.toString(number);
        }
    }

    private boolean numberIsMultipleOfFive(int number) {
        return number % 5 == 0;
    }

    private boolean numberIsMultipleOfThree(int number) {
        return number % 3 == 0;
    }


}
