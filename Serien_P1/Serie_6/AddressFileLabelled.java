/* ************************************************************************* *\
*                Programmierung 1 HS 2018 - Serie 6-1                         *
*		Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)	              *
\* ************************************************************************* */

import java.util.*;

public class AddressFileLabelled extends AddressFile{

    public AddressFileLabelled(String filename){
        super(filename);
    }

    // Diese Methode sucht anhand der labels in einer Zeile nach den jeweiligen Einträgen und baut anschliessend ein Address Objekt daraus. Die Methode ist protected, da sie von aussen aufgerufen werden soll.gui
    protected Address parseLine(String line){

        String id_label = "id";
        String name_label = "name";
        String street_label = "street";
        String zip_label = "zip";
        String city_label = "city";

        // Habe nicht geschafft hier nur ein scanner objekt zu nutzen. Ggf. gibt es hier elegantere Lösungen?
        Scanner sc_id = new Scanner(line);
        Scanner sc_name = new Scanner(line);
        Scanner sc_zip = new Scanner(line);
        Scanner sc_street = new Scanner(line);
        Scanner sc_city = new Scanner(line);

        sc_id.findInLine(id_label +"[\\s]*:[\\s]*([^;]*)");
        int id = Integer.parseInt(sc_id.match().group(1).trim());

        sc_zip.findInLine(zip_label +"[\\s ]*:[\\s ]*([^;]*)");
        int zip = Integer.parseInt(sc_zip.match().group(1).trim());

        sc_name.findInLine(name_label +"[\\ s ]*:[\\ s ]*([^;]*)");
        String name = sc_name.match().group(1).trim();

        sc_street.findInLine(street_label +"[\\ s]*:[\\ s]*([^;]*)");
        String street = sc_street.match().group(1).trim();

        sc_city.findInLine(city_label +"[\\ s]*:[\\ s]*([^;]*)");
        String city = sc_city.match().group(1).trim();

        Address addr = new Address(id, name, street, zip, city );

        return addr;

    }
    // Diese Methode nimmt jede Information des Address Objektes und setzt sie als String in gewünschtem Format zusammen. Die Methode ist protected, da sie von aussen aufgerufen werden soll.
    protected String toLine(Address addr){
        String semicolon_string = " id:" + String.valueOf(addr.getId()) + ";" + " name:" + addr.getName() + ";" + " street:" + addr.getStreet() + ";" + " zip:" + String.valueOf(addr.getZipCode()) + ";" + " city:" + addr.getCity();
        return semicolon_string;
    }
}