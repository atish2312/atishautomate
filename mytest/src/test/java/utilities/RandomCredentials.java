package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomCredentials {
    private final String randomString;
    private final String randomNumber;

    public RandomCredentials(int stringLength, int numberLength) {
        this.randomString = generateRandomString(stringLength);
        this.randomNumber = generateRandomNumber(numberLength);
    }

    private String generateRandomString(int length) {
        return RandomStringUtils.random(length,true,false);
    }

    private String generateRandomNumber(int length) {
        return RandomStringUtils.random(length, false, true);
    }

    public String getRandomString() {
        return randomString;
    }

    public String getRandomNumber() {
        return randomNumber;
    }


}
