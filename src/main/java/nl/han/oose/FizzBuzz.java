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
            System.out.println(players.get(calculatePlayerIndex(i)) + " says " + printWordOnPosition(i));
        }
    }

    int calculatePlayerIndex(int fizzBuzzNumber) {
        return (fizzBuzzNumber - 1) % players.size();
    }

    String printWordOnPosition(int number) {
        if (isMultipleOfThree(number) && isMultipleOfFive(number)) {
            return "FizzBuzz";
        } else if (isMultipleOfFive(number)) {
            return "Buzz";
        } else if (isMultipleOfThree(number)) {
            return "Fizz";
        } else {
            return Integer.toString(number);
        }
    }

    private boolean isMultipleOfFive(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOfThree(int number) {
        return number % 3 == 0;
    }


}
