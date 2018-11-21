import java.util.*; // Imports Scanner + ArrayList
import java.io.*; // For FileWriter and IOException and File

public class AddressFile{
    String filename;
    String comma_string;
    String parsed_string;



    public AddressFile(String filename){
        this.filename = filename;
    }

    public String toLine(Address addr){
         // Gets all the information of an Address Object and puts them together as string with comma seperated
        String comma_string = String.valueOf(addr.getId()) + "," + addr.getName() + "," + addr.getStreet() + "," + String.valueOf(addr.getZipCode()) + "," + addr.getCity();

        return comma_string;
    }
    // Frage: Wann nutzt man bspw. String.valueOf(int) und wann wie unten line.trim()? Warum nicht String.trim(line)?
    /*Diese Methode liest einen String ein, löscht alle Leerzeichen mit trim() und geht dann mit next durch den String und zieht mit dem delimiter "," alles raus. Daraus wird dann ein
     * Address Object gebaut. */
    private Address parseLine(String line){

        Scanner s = new Scanner(line).useDelimiter(",");
        String id_s = s.next();
        id_s = id_s.trim();
        int id = Integer.parseInt(id_s);
        String name = s.next();
        name = name.trim();
        String street = s.next();
        street = street.trim();
        String zip_s = s.next();
        zip_s = zip_s.trim();
        int zip = Integer.parseInt(zip_s);
        String city = s.next();
        city = city.trim();

        Address parsed_address = new Address( id, name, street, zip, city );
        return parsed_address;
    }

    public void save(ArrayList<Address> addresses) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);

        for (Address i : addresses) {
            fileWriter.write(toLine(i) + "\n");
        }
        fileWriter.close();

    }
    /* Diese Methode liest die Datei filename Zeile für Zeile ein und wandelt jede Zeile mit Hilfe der Methode parseLine in ein Address Objekt um. Die Gesamtheit soll dann in einem
    ArrayList zurückgegeben werden.
     */

    public ArrayList<Address> load() throws IOException{

        Scanner sc = new Scanner(new File(filename));
        ArrayList<Address> list = new ArrayList<Address>();

        while (sc.hasNextLine()) {
            list.add(parseLine(sc.nextLine()));
        }
        return list;
    }




}