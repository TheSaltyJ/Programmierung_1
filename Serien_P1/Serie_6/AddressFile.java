/* ************************************************************************* *\
*                Programmierung 1 HS 2018 - Serie 6-1                         *
*		Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)	              *
\* ************************************************************************* */


import java.util.*; // Imports Scanner + ArrayList
import java.io.*; // For FileWriter and IOException and File

public class AddressFile{
    String filename;
    String comma_string;
    String parsed_string;



    public AddressFile(String filename){
        this.filename = filename;
    }

    protected String toLine(Address addr){
         // Gets all the information of an Address Object and puts them together as string with comma seperated
        String comma_string = String.valueOf(addr.getId()) + "," + addr.getName() + "," + addr.getStreet() + "," + String.valueOf(addr.getZipCode()) + "," + addr.getCity();

        return comma_string;
    }
    // Frage: Wann nutzt man bspw. String.valueOf(int) und wann wie unten line.trim()? Warum nicht String.trim(line)?
    /*Diese Methode liest einen String ein, löscht alle Leerzeichen mit trim() und geht dann mit next durch den String und zieht mit dem delimiter "," alles raus. Daraus wird dann ein
     * Address Object gebaut. */
    protected Address parseLine(String line){
        Scanner s = new Scanner(line).useDelimiter(",");

        int id = Integer.parseInt((s.next().trim()));
        String name = s.next().trim();
        String street = s.next().trim();
        int zip = Integer.parseInt((s.next().trim()));
        String city = s.next().trim();

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