import java.util.*;
import java.io.*;
public class Chain {
    private List<String> prefix;

    public Chain() {
        prefix = new ArrayList<>();
    }

    public Chain(List<String> list, int n) {
        prefix = new ArrayList<>();
        for(String x : list) {
            if(prefix.size() == n) {
                break;
            }
            else {
                prefix.add(x);
            }
        }
    }

    public List<String> getPrefix() {
        return prefix;
    }

    public Map<List<String>, List<String>> build(List<String> words, int n) {
        Map<List<String>, List<String>> result = new HashMap<>();
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
                // if(currVList.size() > 1) {
                //     System.out.println(currVList.size());
                // }
            }
        }
        return result;
    }

    public List<String> createImitator(Map<List<String>, List<String>> map) {
        List<String> result = new ArrayList<>();
        for(String x : prefix) {
            result.add(x);
        }
        for(Map.Entry<List<String>, List<String>> x : map.entrySet()) {
            List<String> currentList = map.get(prefix);
            int randomIndex = random.nextInt(currentList.size());
            
        }
        return result;
        }
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
