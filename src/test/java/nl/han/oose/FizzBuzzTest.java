package nl.han.oose;

import org.ajbrown.namemachine.Gender;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private NameGenerator nameGeneratorMock;


    private PrintStream originalSysOut;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @InjectMocks
    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        this.originalSysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalSysOut);
    }

    @Test
    public void testThatFizzBuzzReturnsFizz() {
        assertEquals("Fizz", fizzBuzz.printWordOnPosition(3));
    }

    @Test
    public void testThatFizzBuzzReturnsBuzz() {
        assertEquals("Buzz", fizzBuzz.printWordOnPosition(5));
    }

    @Test
    public void testThatFizzBuzzReturnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.printWordOnPosition(15));
    }

    @Test
    public void testThatFizzBuzzReturnsOtherNumber() {
        assertEquals("2", fizzBuzz.printWordOnPosition(2));
    }

    @Test
    public void testThatPlayerWithNameCanBeAdded() {
        fizzBuzz.addPlayer("Player1");
        assertEquals("Player1", fizzBuzz.players.get(0));
    }

    @Test
    public void testThatRandomNameCanBeAdded() {
        Name name = new Name("Hans", "Wurst", Gender.MALE);
        Mockito.when(nameGeneratorMock.generateName()).thenReturn(name);
        fizzBuzz.addRandomPlayer();
        assertEquals("Hans", fizzBuzz.players.get(0));
    }

    @Test
    public void testCalculatePlayerIndex() {
        fizzBuzz.players.add("Player1");
        fizzBuzz.players.add("Player2");

        assertEquals(0, fizzBuzz.calculcatePlayerIndex(1));
        assertEquals(1, fizzBuzz.calculcatePlayerIndex(2));
        assertEquals(0, fizzBuzz.calculcatePlayerIndex(3));
        assertEquals(1, fizzBuzz.calculcatePlayerIndex(4));
    }

    @Test
    public void testPlayOutputIsCorrect() throws Exception {
        fizzBuzz.players.add("Player1");
        fizzBuzz.play(2);
        assertTrue(outContent.toString().contains("Player1 says 1"));
        assertTrue(outContent.toString().contains("Player1 says 2"));
    }

    @Test(expected = FizzBuzzException.class)
    public void testExceptionWhenPlayIsCalledWOPlayers() throws Exception {
        fizzBuzz.play(1);
    }

    @Test
    public void testExceptionMessageWhenPlayIsCalledWOPlayers() throws Exception {
        thrown.expect(FizzBuzzException.class);
        thrown.expectMessage("No players found.");
        fizzBuzz.play(1);
    }

    @Test
    public void testFizzBuzzCanBePlayedForOneRound() throws FizzBuzzException {
        fizzBuzz.players.add("Uwe");
        fizzBuzz.play(1);
    }
}