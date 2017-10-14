package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.exception.BerlinClockException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeFormatValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String TIME24HOURS_PATTERN =
            "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";

    public TimeFormatValidator() {
        pattern = Pattern.compile(TIME24HOURS_PATTERN);
    }


    /**
     * @param aTime
     * @throws BerlinClockException
     */
    @Override
    public void validate(String aTime) throws BerlinClockException {
        matcher = pattern.matcher(aTime);
        if (!matcher.matches()) {
            throw new BerlinClockException("Invalid Time Format");
        }
    }
}
