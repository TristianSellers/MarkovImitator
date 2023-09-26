import java.util.*;
import java.io.*;
public class Chain {
    private List<String> pref;

    public Chain() {
        pref = new ArrayList<>();
    }

    public Chain(List<String> list, int n) {
        pref = new ArrayList<>();
        for(String x : list) {
            if(pref.size() == n) {
                break;
            }
            else {
                pref.add(x);
            }
        }
    }

    public List<String> getPref() {
        return pref;
    }

    public Map<List<String>, List<String>> build(List<String> list) {
        Map<List<String>, List<String>> result = new HashMap<>();
        result.put(pref, new ArrayList<>());
        for(int i = 0; i < list.size(); i++) {
            String curr = list.get(i);
            // System.out.printf("curr after assignment from list.get(%d): %s\n",
                        // i,curr);
            if(!pref.contains(curr)){
                // System.out.println(pref);
                if(result.get(pref) == null) {
                    result.put(pref, new ArrayList<>());
                }
                List<String> valueList = result.get(pref);
                // System.out.println(valueList);
                valueList.add(curr);
                // System.out.println(valueList);
                result.put(pref, valueList);
                pref.remove(0);
                pref.add(curr);
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
        return pref == c.getPref();
    }

    @Override
    public int hashCode() {
        return Objects.hash(pref);
    }

}
