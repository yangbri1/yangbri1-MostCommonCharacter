import java.util.Map;

import java.util.HashMap;
import java.util.Collections;

public class MostCommonCharacter {
    /**
     * Find the most common character in str.
     * You could use a HashMap that maps a Character key to an Int value to represent how many times a Character has
     * been spotted.
     * @param str A String.
     * @return the most common character within str.
     */
    public char recurringChar(String str) {
        // create a Map to map a Character key w/ an Integer value
        Map<Character, Integer> charCount = new HashMap<>();

        // convert given String 'str' to char[] array
        char[] strToAry = str.toCharArray();

        int i = 0;
        // loop through char[] ary representation of given 'str'
        while(i < strToAry.length){
            // retrieve Character at given iterator/index i
            Character key = strToAry[i];
            // if Map charCount does NOT already holds 'key'
            if(!charCount.containsKey(key)){
                // .put() key-value pair into Map charCount as an element
                charCount.put(key, 1);
            }
            // otw if Map charCount already DOES have the 'key'
            else{
                // update existing key-value pair's value
                charCount.put(key, charCount.get(key) + 1);
            }
            // increment by 1 to keep loop going
            ++i;
        }
        // https://stackoverflow.com/questions/49470423/get-the-highest-values-in-a-hashmap-in-java
        // extracts max value from charCount
        int maxValue = Collections.max(charCount.values());

        int j = 0;
        while(j < charCount.size()){
            if(charCount.containsValue(maxValue)){
                return charCount[j];    // bracket notation only seems to work for array
            }
            ++j;
        }
        return maxValue;
    }
}
