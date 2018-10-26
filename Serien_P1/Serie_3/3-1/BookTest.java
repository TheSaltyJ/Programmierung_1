/* ************************************************************************* *\
*						Programmierung 1 HS 2018 - Serie 3-1				  *
*                Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)      *
\* ************************************************************************* */
public class BookTest
{
    public static void main(String[] args)
    {
        // The book class requires the input as Book(id, title, author, date (as String))
        // Some of the best books in recent times - try them!
        Book book1 = new Book(1, "A Brief History of Time", "Stephen Hawking", "01.03.1989");
        Book book2 = new Book(2, "Homo Deus: A Brief History of Tomorrow", "Yuval Noah Harari", "23.04.2017");
        Book book3 = new Book(3, "Factfulness: Ten Reasons We're Wrong About the World - And Why Things are Better Than You Think", "Hans Rosling & Ola Rosling", "03.04.2018");

        // toString-Methode
        System.out.println(book1.toString());

        System.out.println(book2.toString());

        System.out.println(book3.toString());

        // Age Methode am Beispiel Factfulness
        System.out.println(book3.age());

        // get-Methode mit Beispiel "1, A Brief History of Time, Stephen Hawking, 01.03.1989"
        System.out.println(book1.getID());
        System.out.println(book1.getAuthor());
        System.out.println(book1.getTitle());
        System.out.println(book1.getDate());

        // set-Methode wobei book1 umgeschrieben wird.
        System.out.println(book1.setID(5));
        System.out.println(book1.setAuthor("Peter Maffay"));
        System.out.println(book1.setTitle("Singt Quatsch"));
        System.out.println(book1.setDate("01.01.1990"));
        System.out.println(book1.toString());

        // Input-Method
        book1.input();
        System.out.println(book1.toString());
    }


}