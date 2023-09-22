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
            if(!pref.contains(curr)){
                List<String> valueList = result.get(pref);
                System.out.println(valueList);
                valueList.add(curr);
                System.out.println(valueList);
                result.put(pref, valueList);
                pref.remove(0);
                pref.add(curr);
            }
        }
        return result;
    } 

}
