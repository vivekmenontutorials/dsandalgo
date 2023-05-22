package dsandalgo.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer, Long> fibMap = new HashMap<>();


    public long fibonacci(int i) {


        if (i < 0) {
            throw new RuntimeException("input should be a positive integer.");
        }

        if (fibMap.get(i) != null) {
            return fibMap.get(i);
        }


        if (i == 0 || i == 1) {
            return i;
        }

        fibMap.put(i - 1, fibonacci(i - 1));
        fibMap.put(i - 2, fibonacci(i - 2));

        return fibMap.get(i - 1) + fibMap.get(i - 2);
    }


}
