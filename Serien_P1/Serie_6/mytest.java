import java.util.Scanner;

public class mytest{

    public static void main(String[] args){
        String line = "1, Max Muster, Neubrückstr. 10    ,3012,Bern";
        // We use the scanner to import the Strings and use "," as delimiter. After it is scanned we trim() the whitespaces and convert zip and id to Int.
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
        System.out.println(parsed_address);




    }


}