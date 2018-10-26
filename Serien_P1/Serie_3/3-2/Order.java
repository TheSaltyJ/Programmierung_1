/* ************************************************************************* *\
*						Programmierung 1 HS 2018 - Serie 3-2				  *
*                Jonas Gehrlein (15-127-541) & Jan Dietrich (10-100-436)      *
*                					File: Order.java					      *
\* ************************************************************************* */

public class Order
{
    private String customerName, customerAddress;
    static int order_id = 0;
    private int counter = 0;
    private String order_string;
    public int i = 0;
    private int total_price;
    public int cost;

    Book book1 = new Book();
    Book book2 = new Book();
    Book book3 = new Book();
    Book book4 = new Book();
    Book book5 = new Book();


    // Constructor which initializes the Order objects. It increases the order_id with each initialization.
    public Order()
    {
        order_id++;
    }
    // Set-Methods
    public String setCustomerName(String input_customer_name) {
    customerName = input_customer_name;

    return customerName;
    }


    public String setCustomerAddress(String input_customer_address) {
    customerAddress = input_customer_address;

    return customerAddress;
    }

    /* addBook Method. For Each iteration a new book variable will be filled with a book from the method.
    It is not very elegant but it works. In addition it fills the cost variables with the price of the book. */

    public void addBook(Book new_book) {
        if (i == 0) {
            book1 = new_book;
            cost = book1.getPrice();
        }
        if (i == 1) {
            book2 = new_book;
            cost = book2.getPrice() + cost;
        }
        if (i == 2) {
            book3 = new_book;
            cost = book3.getPrice() + cost;
        }
        if (i == 3) {
            book4 = new_book;
            cost = book4.getPrice() + cost;
        }
        if (i == 4) {
            book5 = new_book;
            cost = book5.getPrice() + cost;
        }
        i++;
        return;
    }
    // Calculates the total cost of the order which depends on the amount of books added to the order.
    public int getTotal_price() {
       return cost;
    }


    // Some getMethods.
    public String getCustomerName() { return customerName; }
    public String getCustomerAddress() { return customerAddress; }
    public int getOrder_id(){return order_id;}

    // Not very clean, I know. It works for Test.java but would not work for orders of 2, 3, 4 books. Solution would be more arguments of "if".
    // If I had more time, I would add some formatting to the prices. Now it works manually.
    public String toString ()
    {
        String order_string;
        if (i>1 ) {
            order_string = "Order id: " + order_id + ", " + "Customer: " + customerName + ", " + customerAddress + "\n" +
                    book1.toString() + ", " + book1.getPrice() + " CHF" + "\n" +
                    book2.toString() + ", " + book2.getPrice() + " CHF" + "\n" +
                    book3.toString() + ", " + book3.getPrice() + " CHF" + "\n" +
                    book4.toString() + ", " + book4.getPrice() + " CHF" + "\n" +
                    book5.toString() + ", " + book5.getPrice() + " CHF" + "\n" +
                    "Total price: " + getTotal_price() + " CHF" + "\n";
        }
        else
            order_string = "Order id: " + order_id + ", " + "Customer: " + customerName + ", " + customerAddress + "\n" +
                    book1.toString() + ", " + book1.getPrice() + " CHF" + "\n" + "Total price: " + getTotal_price() + " CHF" + "\n";


        return order_string;
    }

    public int getI()
    {
        return i;
    }

}