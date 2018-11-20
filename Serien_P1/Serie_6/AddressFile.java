import java.util.Scanner;

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
    // Frage: Wann nutzt man bspw. String.valueOf(int) und wann wie unten line.trim()? Warum nicht String.trim(line)?
    /*Diese Methode liest einen String ein, löscht alle Leerzeichen mit trim() und geht dann mit next durch den String und zieht mit dem delimiter "," alles raus. Daraus wird dann ein
     * Address Object gebaut. */
    private Address parseLine(String line){
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
    private void save(ArrayList<Address> addresses){

    }


}