import java.io.*;
import java.nio.*;
import java.util.*;
public class mainClass{
    public void main(String [] args){
        System.out.println("Input String");
        String inputString = "";
        transToLeet(inputString);
    }


    public String transToLeet(String input){
        String leetString = "";

        csvToArrayList(input);
        

        

        return leetString;
    }
    public int stringToInt(String input, int i){
    int output = 0;
    
    char currentChar = input.charAt(i);
    int csvNumber = Character.getNumericValue(currentChar);
    output = csvNumber;
    return output;
    }

    private int[][] csvToArrayList(String csv){
    int lineCount = 0;
    
    //first pass, populate 1D array
    try (BufferedReader reader = new BufferedReader(new FileReader("/csv/" + csv))) {
    String line;

    while ((line = reader.readLine()) != null) {
        lineCount++;
    }
    }catch (Exception e){
        System.out.println("Error: CSV file not found");
        return new int[0][0];
    }
    int[][] CSVarray = new int [lineCount][];
    //second pass, use 1D array to populate 2d Array
    try (BufferedReader reader = new BufferedReader(new FileReader("/csv/" + csv))) {
    String line;
    int row = 0;

    while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            CSVarray[row] = new int[values.length];
        for (int col = 0; col < values.length; col++) {
                CSVarray[row][col] = Integer.parseInt(values[col].trim());
            }
        row++;
    }

    }catch (Exception e){
        System.out.println("Error: CSV file not found");
        return new int[0][0];
    }

    return CSVarray;
}
}
