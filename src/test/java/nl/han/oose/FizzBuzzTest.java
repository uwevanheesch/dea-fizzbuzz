package nl.han.oose;

import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void testThatFizzBuzzReturnsFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.printWordOnPosition(3));
        // expecting Fizz
    }

    @Test
    public void testThatFizzBuzzReturnsBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.printWordOnPosition(5));
        // expecting Buzz
    }


    @Test
    public void testThatFizzBuzzReturnsFizzBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.printWordOnPosition(15));
        // expecting FizzBuzz
    }

    @Test
    public void testThatFizzBuzzReturnsOtherNumber() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.printWordOnPosition(2));
        // expecting 2
    }

}