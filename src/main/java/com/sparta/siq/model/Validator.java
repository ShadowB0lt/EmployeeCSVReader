package com.sparta.siq.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean validate(String[] employeeFields) {
        if (PatternCheck("^[0-9]*$", employeeFields[0]) &&
                PatternCheck("[a-zA-Z]+\\.*$", employeeFields[1]) &&
                PatternCheck("[a-zA-Z]*$", employeeFields[2]) &&
                PatternCheck("[A-Z]*$", employeeFields[3]) &&
                PatternCheck("[a-zA-z]*$", employeeFields[4]) &&
                PatternCheck("[A-Z]*$", employeeFields[5]) &&
                PatternCheck("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", employeeFields[6]) &&
                PatternCheck("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4,4}$", employeeFields[7]) &&
                PatternCheck("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4,4}$", employeeFields[8]) &&
                PatternCheck("^[0-9]*$", employeeFields[9])
        ) {
            return true;
        } else {
            return false;

        }
    }
    private boolean PatternCheck(String regex, String employeeField) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employeeField);
        return matcher.matches();

    }

}