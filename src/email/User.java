package email;

import java.util.Scanner;
import java.util.Random;

public class User {
    private String userName;
    private String companyName;
    private int yearOfJoining;
    private String email;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String userName, String companyName, int yearOfJoining) {
        this.userName = userName;
        this.companyName = companyName;
        this.yearOfJoining = yearOfJoining;
        this.email = createUserEmail();
        this.password = createUserPassword();
    }

    public int generateRandomIntegerFromLimit(int limit) {
        return (int) (Math.random() * limit);
    }

    private char generateRandomCharacter() {
        int randomNumberUpto26 = generateRandomIntegerFromLimit(26);
        return (char) ('a' + randomNumberUpto26);
    }

    public String createUserEmail() {
        return String.format("%s_%d@%s.com", getUserName().toLowerCase(), getYearOfJoining(), getCompanyName().toLowerCase());
    }

    private String getFirst5CharactersFromUserName() {
        if (getUserName().length() < 5) {
            int difference = 5 - getUserName().length();
            StringBuilder tempName = new StringBuilder(getUserName());
            for (int i = 0; i < difference; i++) {
                tempName.append("0");
            }
            return tempName.toString();
        } else {
            return getUserName().substring(0, 5);
        }
    }

    private char generateRandomSpecialSymbol() {
        char[] specialSymbols = {'!', '@', '#', '%', '$', '^', '&', '*', '(', ')', '{', '}',
                '[', ']', '|', '\\', ';', ':', '\'', '\"'};
        int randomInteger = generateRandomIntegerFromLimit(specialSymbols.length);
        return specialSymbols[randomInteger];
    }

    public String createUserPassword() {
        StringBuilder sb = new StringBuilder();
        sb.append(generateRandomCharacter());
        for (int i = 0; i < 4; i++) {
            sb.append(generateRandomIntegerFromLimit('0'));
        }
        sb.append(getFirst5CharactersFromUserName());
        sb.append(generateRandomSpecialSymbol());
        return sb.toString();
    }
}

class UserEntry {
    public static void main(String[] args) {
        User obj = new User("Chandrika", "Amazon", 2022);
        System.out.println(obj.getEmail());
        System.out.println(obj.getPassword());
    }
}
