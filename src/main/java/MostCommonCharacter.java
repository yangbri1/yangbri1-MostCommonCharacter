import java.util.Map;

import java.util.HashMap;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

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
        // Note: Map can NOT take in primitive types -- need to use Wrapper Classes to autobox (int -> Integer) for their Object equivalent
        Map<Character, Integer> charCount = new HashMap<>();

        // convert given String 'str' to char[] array
        char[] strToAry = str.toCharArray();

        // create a Set --- no duplicates allowed
        Set<Character> charSet = new HashSet<Character>();

        int i = 0;
        // loop through char[] ary representation of given 'str'
        while(i < strToAry.length){
            // retrieve Character at given iterator/index i
            Character key = strToAry[i];

            charSet.add(key);

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

        // create an empty int[] array w/ declared size being set to charCount
        // char[] keys = new char[charCount.size()];  

        int j = 0;
        // iterate via HashMap of key-value pairs for Character & their Integer counts
        while(j < charCount.size()){
            // upon finding the maxValue within HashMap 'charCount'
            if(charCount.containsValue(maxValue)){
                // return charCount[j];    // bracket notation only seems to work for array
                // stop the loop
                break;
            }
            // increment by 1 to keep loop going
            ++j;
            // charCount.get()
        }
        
        // utilizing .toArray() method in Set to convert 'charSet' of keys into an Character[] array of keys
        // Note: 'new Character[0]' or 'new Character[charSet.size()]' is explicitly teling Java to return it as a 'Character[]' converted from 'Object[]'
        // https://stackoverflow.com/questions/43696716/type-mismatch-cannot-convert-from-element-type-object-to-stringgenerics
        Character[] keys = charSet.toArray(new Character[0]);

        // attempting to return precise key at instance when maxValue was found ...
        char maxKey = keys[j+1];
        return maxKey;

        /* Note: Does the order in a Set preserved when .toArray() is called to convert it to an Array?
         * How about the order within an HashMap compared to a Set? 
         */
    }
}
