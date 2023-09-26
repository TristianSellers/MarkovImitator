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

        Map<List<String>, List<String>> markovMap = chain.build(words, n);
    }
}