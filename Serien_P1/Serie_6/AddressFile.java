import java.util.Scanner

public class AddressFile{
    String filename;
    String comma_string;
    String parsed_string;



     public AddressFile(String filename){
        this.filename = filename;
    }

    private String toLine(Address addr){
         // Gets all the information of an Address Object and puts them together as string with comma seperated
        String comma_string = String.valueOf(addr.getId()) + "," + addr.getName() + "," + addr.getStreet() + "," + String.valueOf(addr.getZipCode()) + "," + addr.getCity();

        return comma_string;
    }

    private parseLine(String line){
         line.trim()


    }

}