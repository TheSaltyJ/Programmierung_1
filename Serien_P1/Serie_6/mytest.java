import java.util.Scanner;

public class mytest{

    public static void main(String[] args){
        Address addr = new Address( 1, "Max Muster", "Neubrückstr. 10", 3012, "Bern" );
        String string = "1, Max Muster   , Neubrückstrasse.10 , 3012, Bern";


        parseLine(string);
        System.out.println(parsed_address);



    }
    public Address parseLine(String line){
        Scanner s = new Scanner(line.trim()).useDelimiter(",");
        // Scans the next until "," and parses it as int
        int id = Integer.parseInt(s.next());
        String name = s.next();
        String street = s.next();
        int zip = Integer.parseInt(s.next());
        String city = s.next();

        Address parsed_address = new Address( id, name, street, zip, city );
        return parsed_address;
    }

}