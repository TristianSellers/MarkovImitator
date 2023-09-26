import java.util.*;
import java.io.*;
public class Imitator {
    public static void main(String [] args) {
        /*
        Implement the algorithm as a program that accepts a 
        book-length input given as a command line
        argument. Produces an imitation of 100-200 words. 
        Use prefixes of 2 or 3 words. Upload your solution
        to GitHub as a private repository, to which you add 
        raylangnola as a collaborator        
        */
        String fileName = "";
        int n = 3; // default
        if(args.length > 0) {
            fileName = args[0];
        }
        if(args.length > 1) {
            n = Integer.parseInt(args[1]);
        }

        List<String> words = FileReader.readTheFileToArrayList(fileName);
        Chain chain = new Chain(words, n);
        List<String> temp = chain.getPref();
        // System.out.println(temp);
        Map<List<String>, List<String>> markovMap = chain.build(words);
        // System.out.println("markovMap size: " + markovMap.size());

        List<String> prefix = getPrefix(words, n);
        System.out.println(prefix);
        String test = markov(markovMap, prefix);
    }
    public static List<String> getPrefix(List<String> list, int n) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            result.add(list.get(i));
        }
        return result;
    }
    public static String markov(Map<List<String>, List<String>> map, List<String> prefix) {
        Random random = new Random();
        String result = "";
        return result;
    }

    // private static  List<String> movePrefix(List<String> prefix, List<String> words) {
    //     List<String>
    // }
    // function(s)
}