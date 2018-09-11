package nl.han.oose;

import org.ajbrown.namemachine.NameGenerator;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    List<String> players = new ArrayList<>();
    private NameGenerator nameGenerator = new NameGenerator();

    public void addPlayer(String name) {
        this.players.add(name);
    }

    public void addRandomPlayer() {
        players.add(nameGenerator.generateName().getFirstName());
    }

    public void play(int limit) throws FizzBuzzException {
        if (players.isEmpty()) {
            throw new FizzBuzzException("No players found.");
        }

        for (int i = 1; i <= limit; i++) {
            System.out.println(players.get(calculcatePlayerIndex(i)) + " says " + printWordOnPosition(i));
        }

    }

    int calculcatePlayerIndex(int number) {
        return (number - 1) % players.size();
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
