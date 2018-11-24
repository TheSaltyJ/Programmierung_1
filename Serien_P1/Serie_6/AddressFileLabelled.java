import java.util.*;

public class AddressFileLabelled extends AddressFile{

    public AddressFileLabelled(String filename){
        super(filename);
    }



    protected Address parseLine(String line){

        String id_label = "id";
        String name_label = "name";
        String street_label = "stret";
        String zip_label = "zip";
        String city_label = "city";

        Scanner scan = new Scanner(line);
        int id = Integer.parseInt(scan.findInLine(id_label + "[\\s] * : [\\s] * ([^;]*)").trim());
        int zip = Integer.parseInt(scan.findInLine(zip_label + "[\\s] * : [\\s] * ([^;]*)").trim());
        String name = scan.findInLine(name_label + "[\\s] * : [\\s] * ([^;]*)").trim();
        String street = scan.findInLine(street_label + "[\\s] * : [\\s] * ([^;]*)").trim();
        String city = scan.findInLine(city_label + "[\\s] * : [\\s] * ([^;]*)").trim();


        Address addr = new Address(id, name, street, zip, city );

        return addr;

    }
        }