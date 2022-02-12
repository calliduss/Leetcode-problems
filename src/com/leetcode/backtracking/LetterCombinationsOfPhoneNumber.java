package com.leetcode.backtracking;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * Level: Medium
 * topics: backtrack, recursion, String
 **/
public class LetterCombinationsOfPhoneNumber {

    private final Map<Character, char[]> phoneKeyboard = propagatePhoneKeyboard();
    private List<String> combinations = new ArrayList<>();
    private String enteredDigits;

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) { return combinations; }
        enteredDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        if(path.length() == enteredDigits.length()) {
            combinations.add(path.toString());
            return;
        }
        var possibleLetters = phoneKeyboard.get(enteredDigits.charAt(index));
        for(char letter : possibleLetters) {
            path.append(letter);
            backtrack(index + 1, path);
            path.deleteCharAt(path.length() - 1); //recently added
        }
    }

    private HashMap<Character, char[]> propagatePhoneKeyboard() {
        HashMap<Character, char[]> phoneKeyboard = new HashMap<>();
        int startLowerCase = 97;
        int REDIX = 10; // redix 10 is for decimal number
        int startPhoneKey = 2;

        for (int i = startPhoneKey; i < 10; i++) {
            if (i == 7 || i == 9) { // 7 and 9 contains 4 letters
                char[] list = new char[4];
                for (int j = 0; j < list.length; j++) {
                    list[j] = (char) startLowerCase++;
                }
                phoneKeyboard.put(Character.forDigit(i,REDIX), list);
            } else {
                char[] list = new char[3];
                for (int j = 0; j < list.length; j++) {
                    list[j] = (char) startLowerCase++;
                }
                phoneKeyboard.put(Character.forDigit(i,REDIX), list);
            }
        }
        return phoneKeyboard;
    }
}