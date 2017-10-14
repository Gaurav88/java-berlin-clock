package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.exception.BerlinClockException;
import org.junit.Test;

public class TimeFormatValidatorTest {

    @Test(expected = BerlinClockException.class)
    public void testValidateNegative() throws BerlinClockException {
        TimeFormatValidator timeFormatValidator = new TimeFormatValidator();
        timeFormatValidator.validate("28:45:30");
    }

    @Test
    public void testValidatePositive() throws BerlinClockException {
        TimeFormatValidator timeFormatValidator = new TimeFormatValidator();
        timeFormatValidator.validate("22:45:30");
    }
}
