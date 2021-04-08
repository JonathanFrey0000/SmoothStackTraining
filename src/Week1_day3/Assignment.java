package Week1_day3;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * @author  Jonathan Frey
 */
public class Assignment {

    public static void listNamesOfDirectories(String directory_path) {
        System.out.println("All directory and file names present in " + directory_path + " are: ");

        Path path = Paths.get(directory_path);
        List<Path> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile).collect(Collectors.toList());
            result.forEach(x -> System.out.print(x.getFileName() + ", "));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void appendToFile(String file_path, String text) {

        try (PrintWriter output_stream = new PrintWriter(new FileOutputStream(file_path, true))){
            output_stream.println(text);
            System.out.println("Text appended successfully.");
        }
        catch(FileNotFoundException e){
            System.out.println("File cannot be found.");
        }

    }
    public static String countCharOccurrence(String file_path, char x){

        int counter =0 ;
        try(Scanner input_stream = new Scanner(new FileInputStream(file_path))){
            while(input_stream.hasNextLine()){
                String line = input_stream.nextLine();
                for(int i=0; i<line.length();i++){
                    if(line.charAt(i) == x) counter++;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File cannot be found.");
        }
        return "There are " + counter + " occurrences of '" + x + "' in " + file_path;
    }

    public static void main(String[] args)  {
        System.out.println("1)");
        listNamesOfDirectories("src/Week1_day3/test_directory");

        System.out.println("2)");
        appendToFile("src/Week1_day3/test_directory/file1","abacadae");

        System.out.println("3)");
        System.out.println(countCharOccurrence("src/Week1_day3/test_directory/file1",args[0].charAt(0)));

    }
}

