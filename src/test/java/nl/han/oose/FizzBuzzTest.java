package nl.han.oose;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void testThatFizzIsReturnedIfNumberIsMultipleOfThree() {
        assertEquals("Fizz", fizzBuzz.printWordOnPosition(3));
    }

    @Test
    public void testThatBuzzIsReturnedIfNumberIsMultipleOfFive() {
        assertEquals("Buzz", fizzBuzz.printWordOnPosition(10));
    }

    @Test
    public void testThatFizzBuzzIsReturnedIfNumberIsMultipleOfFiveAndThree() {
        assertEquals("FizzBuzz", fizzBuzz.printWordOnPosition(15));
    }

    @Test
    public void testThatNumberIsReturnedIfNumberIsNotMultipleOfFiveOrThree() {
        assertEquals("2", fizzBuzz.printWordOnPosition(2));
    }

    @Test
    public void testThatPlayerCanBeAdded() {
        fizzBuzz.addPlayer("Player1");
        assertEquals("Player1", fizzBuzz.players.get(0));
    }

    @Test
    public void testThatExceptionIsThrownIfNoPlayers() throws Exception {
        thrown.expect(FizzBuzzException.class);
        thrown.expectMessage("No players found.");
        fizzBuzz.play(1);
    }

    @Test
    public void testThatPlayerIndexIsZero() {
        fizzBuzz.players.add("Player1");
        fizzBuzz.players.add("Player2");

        assertEquals(0, fizzBuzz.calculatePlayerIndex(1));
        assertEquals(1, fizzBuzz.calculatePlayerIndex(2));
        assertEquals(0, fizzBuzz.calculatePlayerIndex(3));

    }
}