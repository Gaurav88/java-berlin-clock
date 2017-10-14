package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.exception.BerlinClockException;

import java.util.ArrayList;
import java.util.List;

public class BerlinClockValidator implements Validator {
    private List<Validator> validators;

    public BerlinClockValidator() {
        validators = new ArrayList<>();
        Validator timeFormatValidator = new TimeFormatValidator();
        validators.add(timeFormatValidator);
    }

    /**
     * @param aTime
     * @throws BerlinClockException
     */
    @Override
    public void validate(String aTime) throws BerlinClockException {
        for (Validator validator : validators) {
            validator.validate(aTime);
        }
    }
}
