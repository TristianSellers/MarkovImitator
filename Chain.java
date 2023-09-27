import java.util.*;
import java.io.*;
public class Chain {
    private List<String> prefix;

    public Chain() {
        prefix = new ArrayList<>();
    }

    public Chain(List<String> list, int n) {
        prefix = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(prefix.size() == n) {
                break;
            }
            else {
                prefix.add(list.get(i));
            }
            // System.out.println(prefix);
        }
    }

    public List<String> getPrefix() {
        return prefix;
    }

    public void setPrefix(List<String> list) {
        prefix = list;
    }

    public Map<List<String>, List<String>> build(List<String> words, int n) {
        // List<String> currentPrefix = prefix;
        Map<List<String>, List<String>> result = new HashMap<>();
        result.put(prefix, new ArrayList<>());
        for(int i = 0; i < words.size(); i++) {
            // System.out.println(prefix);
            int ndx = i + n;
            if(ndx >= words.size()) {
                break;
            }
            else {
                if(!result.containsKey(prefix)) {
                    // System.out.println(prefix);
                    result.put(prefix, new ArrayList<>());
                }
                List<String> currVList = result.get(prefix);
                currVList.add(words.get(ndx));
                List<String> temp = new ArrayList<>();
                temp.add(prefix.get(1));
                temp.add(prefix.get(2));
                temp.add(words.get(ndx));
                prefix = temp;
                // System.out.println(currVList.size());
            }
        }
        // System.out.println(result);
        return result;
    }

    public List<String> createImitator(Map<List<String>, List<String>> map) {
        Random random = new Random();
        List<String> currentPrefix = prefix;
        List<String> result = new ArrayList<>();
        for(String x : currentPrefix) {
            result.add(x);
        }
        while(result.size() <= 150) {
            List<String> currentList = map.get(currentPrefix);
            System.out.println("Prefix: " + currentPrefix + "\n\nList: \n" + currentList);
            if(currentList.size() > 1) {
                int randomIndex = random.nextInt(currentList.size());
                String randomWord = currentList.get(randomIndex);
                result.add(randomWord);
                currentPrefix.add(randomWord);
                currentPrefix.remove(0);
            }
            else {
                String word = currentList.get(0);
                result.add(word);
                currentPrefix.add(word);
                currentPrefix.remove(0);
            }
        }
        return result;
    }

    @Override
    public boolean equals (Object o) {
        if(this == o) {return true;}
        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Chain c = (Chain)o;
        return prefix.equals(c.getPrefix());
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix);
    }

}
