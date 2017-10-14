package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.exception.BerlinClockException;

public interface Validator {

    /**
     * @param aTime
     * @throws BerlinClockException
     */
    void validate(String aTime) throws BerlinClockException;
}
