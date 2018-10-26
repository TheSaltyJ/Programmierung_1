import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mytest
{
    public static void main(String[] args) throws ParseException
    {
        SimpleDateFormat fmt = new SimpleDateFormat(Book.DATE_FORMAT);
        Book b1 = new Book(1, "Homo Faber", "Max Frisch", fmt.parse("01.01.1957"), -10);
        Book b2 = new Book(2, "Harry Potter", "J.K. Rowling", fmt.parse("25.7.2000"), 45);
        Book b3 = new Book(3, "Krieg und Frieden", "Leo Tolstoi", fmt.parse("24.01.1867"), 29);
        Book b4 = new Book(4, "Freedom", "Jonathan Franzen", fmt.parse("08.06.2010"), 39);
        Book b5 = new Book(5, "Goedel, Escher, Bach", "Douglas Hofstadter", fmt.parse("05.11.1979"), 42);


        Order order = new Order();
        order.setCustomerName("Sophie Muster");
        order.setCustomerAddress("Mittelstrasse 10, 3011 Bern");
        order.addBook(b1);
        order.addBook(b2);
        order.addBook(b3);
        order.addBook(b4);
        System.out.println(order);

        /*
        order.setCustomerName("Sophie Muster");
        order.setCustomerAddress("Mittelstrasse 10, 3011 Bern");
        System.out.println(order.getI());
        order.addBook(b1);
        System.out.println(order.getI());
        System.out.println(order.getTotal_price());
        order.addBook(b2);
        System.out.println(order.getI());
        System.out.println(order.getTotal_price());
        order.addBook(b3);
        System.out.println(order.getI());
        System.out.println(order.getTotal_price());
        */
        /*


        order.setCustomerName("Sophie Muster");
        order.setCustomerAddress("Mittelstrasse 10, 3011 Bern");
        System.out.println(order.getI());
        order.addBook(b1);
        System.out.println(order.getI());
        System.out.println(order.getTotal_price());
        order.addBook(b2);
        System.out.println(order.getI());
        System.out.println(order.getTotal_price());
        order.addBook(b3);
        System.out.println(order.getI());


        System.out.println(order.getTotal_price());
        System.out.println(order.getCustomerName());
        System.out.println(b3.getPrice());
        System.out.println(order.getOrder_id());
        System.out.println(order2.getOrder_id());
        System.out.println(order);
           */
      }
}