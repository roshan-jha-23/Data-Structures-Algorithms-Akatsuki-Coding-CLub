import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            wordSet.remove(word); // Remove the current word from the set temporarily
            if (canFormConcatenatedWord(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word); // Add the word back to the set
        }
        
        return result;
    }

    private boolean canFormConcatenatedWord(String target, Set<String> wordSet) {
        if (wordSet.isEmpty()) {
            return false;
        }

        boolean[] dp = new boolean[target.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= target.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(target.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[target.length()];
    }
}
