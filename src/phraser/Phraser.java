package phraser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Build verb phrases. Badly.
 * 
 * @author maxg
 */
public class Phraser {
    
    private Phrase ph = new Phrase();
    
    /**
     * Add an adjective to the current phrase.
     */
    public void adjective(String adjective) {
        ph.adjectives.add(adjective);
    }
    
    /**
     * Add a noun to the current phrase.
     */
    public void noun(String noun) {
        ph.nouns.add(noun);
    }
    
    /**
     * Add a verb to the current phrase.
     * If it already had a verb, return it and start a new one.
     */
    public String verb(String verb) {
        if (ph.verb != null) {
            if (ph.nouns.isEmpty()) {
                throw new IllegalStateException("Over-verbed");
            }
            String result = ph.toString();
            ph = new Phrase();
            ph.verb = verb;
            return result;
        }
        ph.verb = verb;
        return null;
    }
}

class Phrase {
    
    List<String> adjectives = new ArrayList<String>();
    List<String> nouns = new ArrayList<String>();
    String verb = null;
    
    /**
     * Return verb phrase.
     * E.g. "kick the red ball" or "kick the big, red ball and the big, red apple".
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(verb);
        for (Iterator<String> it = nouns.iterator(); it.hasNext(); ) {
            result.append(" the");
            for (Iterator<String> jt = adjectives.iterator(); jt.hasNext(); ) {
                result.append(" " + jt.next());
                if (jt.hasNext()) {
                    result.append(",");
                }
            }
            result.append(" " + it.next());
            if (it.hasNext()) {
                result.append(" and");
            }
        }
        return result.toString();
    }
}
