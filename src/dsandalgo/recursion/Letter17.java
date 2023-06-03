package dsandalgo.recursion;

import java.util.ArrayList;
import java.util.List;

public class Letter17 {

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }

        helper(digits, "", results);

        return results;
    }

    private void helper(String digits, String partialResult, List<String> results) {

        if (digits.length() == 0) {
            results.add(partialResult);
            return;
        }

        char currentDigit = digits.charAt(0);
        String[] letters = digitToStrArr(currentDigit);

        for (int i = 0; i < letters.length; i++) {
            helper(digits.substring(1), partialResult + letters[i], results);
        }

    }

    private String[] digitToStrArr(char digit) {
        switch (digit) {
            case '0':
            case '1':
                return new String[]{};
            case '2':
                return new String[]{"a", "b", "c"};
            case '3':
                return new String[]{"d", "e", "f"};
            case '4':
                return new String[]{"g", "h", "i"};
            case '5':
                return new String[]{"j", "k", "l"};
            case '6':
                return new String[]{"m", "n", "o"};
            case '7':
                return new String[]{"p", "q", "r", "s"};
            case '8':
                return new String[]{"t", "u", "v"};
            case '9':
                return new String[]{"w", "x", "y", "z"};
        }
        return null;
    }


}
