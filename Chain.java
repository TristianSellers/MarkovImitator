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

    public Map<List<String>, List<String>> build(List<String> words, int n, List<String> prefix) {
        prefix = this.prefix;
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
                    result.put(prefix, new ArrayList<>());
                }
                List<String> currVList = result.get(prefix);
                currVList.add(words.get(ndx));
                prefix.add(words.get(ndx));
                prefix.remove(0);
            }
        }
        return result;
    }

    public List<String> createImitator(Map<List<String>, List<String>> map, List<String> prefix) {
        Random random = new Random();
        prefix = this.prefix;
        List<String> result = new ArrayList<>();
        for(String x : prefix) {
            result.add(x);
        }
        while(result.size() <= 150) {
            List<String> currentList = map.get(prefix);
            System.out.println("Prefix: " + prefix + "\n\nList: \n" + currentList);
            if(currentList.size() > 1) {
                int randomIndex = random.nextInt(currentList.size());
                String randomWord = currentList.get(randomIndex);
                result.add(randomWord);
                prefix.add(randomWord);
                prefix.remove(0);
            }
            else {
                String word = currentList.get(0);
                result.add(word);
                prefix.add(word);
                prefix.remove(0);
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
        return prefix == c.getPrefix();
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix);
    }

}
