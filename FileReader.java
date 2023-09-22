import java.util.*;
import java.io.*;
public class FileReader {
    public static void main(String [] args) {
        if(args.length == 0) {
            System.out.println("Please enter your file name.");
            System.exit(0);
        }
        String fileName = args[0];
        System.out.println("The filename is: " + fileName);

        ArrayList<String> fileContents = readTheFileToArrayList(fileName);

        System.out.println("fileContent File content size: \n" + fileContents.size());

    }
    // functions
    public static ArrayList<String> readTheFileToArrayList(String fileName) {
            ArrayList<String> contents = new ArrayList<>();
            try (Scanner fileReader = new Scanner(new File(fileName))) {
                // this part execures if try succeeds
                while(fileReader.hasNext()) {
                    String oneWord = fileReader.next();
                    contents.add(oneWord);
                }
            } catch (FileNotFoundException e) {
                // executes when try fails
                System.out.println("Could not open the file. The file name was: " + fileName);
                System.exit(0);
            }
            return contents;
    }
}