import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();
    @Test
    public void givenEmptyStringShouldReturnZero() throws Exception {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void givenNumbersShouldReturnSameNumber() throws Exception {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void givenTwoCommaSeperatedNumbersShouldReturnTheirSum() throws Exception {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void givenUnknownCommaSeperatedNumbersShouldReturnTheirSum() throws Exception {
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }

    @Test
    public void givenUnkownCommaAndNewlineSeperatedNumbersShouldReturnTheirSum() throws Exception {
        assertEquals(10, stringCalculator.add("1,2\n3,4"));
    }

    @Test
    public void givenDelimeterSeperatedNumbersReturnTheirSum() throws Exception {
        assertEquals(10,stringCalculator.add("//;\n1;2;3;4"));
    }

    @Test
    public void forNegativeNumberReturnException() throws Exception
    {
        try {assertEquals("negatives not allowed [-1]",stringCalculator.add("-1"));
        }
        catch (Exception e)
        {
            assertEquals("negatives not allowed [-1]",e.getMessage());
        }
    }

    @Test
    public void forMultipleNegativeNumberReturnException() throws Exception
    {
        try {assertEquals("negatives not allowed [-2,-3]",stringCalculator.add("1,-2,-3"));
        }
        catch (Exception e)
        {assertEquals("negatives not allowed [-2,-3]",e.getMessage());
        }

    }

    @Test
    public void forDelimeterReturnSumOfNumberSeperatedByThem() throws Exception
    {
        assertEquals(3,stringCalculator.add("//[*]\n1*2"));

    }
    @Test
    public void forDelimeterWithVariableLengthReturnSumOfNumberSeperatedByThem() throws Exception
    {
        assertEquals(3,stringCalculator.add("//[***]\n1***2"));

    }

    @Test
    public void forNumberofDelimeterReturnSumOfNumberSeperatedByThem() throws Exception
    {
        assertEquals(6,stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void forNumberofDelimeterWithVariableLengthReturnSumOfNumberSeperatedByThem() throws Exception
    {
        assertEquals(6,stringCalculator.add("//[**][%%]\n1**2%%3"));
    }

    @Test
    public void getTheCountThatReturnsHowManyTimesAddMethodWasInvoked() throws Exception {
        assertEquals(1,stringCalculator.add("1"));
    }

    @Test
    public void SumOfNumbersNotGreaterWhereNumberIsNotGreaterThan1000() throws Exception {
        assertEquals(2,stringCalculator.add("1000,2"));
    }


}

