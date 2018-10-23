public class Order
{
    private String customerName, customerAddress;
    static int order_id = 0;
    private int counter = 0;
    private int i = 1;
    private String order_string;
    private int total_price;
    public int cost_1, cost_2 , cost_3, cost_4, cost_5;

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
    public String setCustomerName(String input_customer_name)
    {
    customerName = input_customer_name;

    return customerName;
    }


    public String setCustomerAddress(String input_customer_address)
    {
    customerAddress = input_customer_address;

    return customerAddress;
    }

    /* addBook Method. For Each iteration a new book variable will be filled with a book from the method.
    It is not very elegant but it works. In addition it fills the cost variables with the price of the book. */

    public void addBook(Book new_book)
    {
        if (i == 1) {
            book1 = new_book;
            cost_1 = book1.getPrice();
            i++;
        }
        if (i == 2) {
            book2 = new_book;
            cost_2 = book2.getPrice();
            i++;
        }
        if (i == 3) {
            book3 = new_book;
            cost_3 = book3.getPrice();
            i++;
        }
        if (i == 4) {
            book4 = new_book;
            cost_4 = book4.getPrice();
            i++;
        }
        if (i == 5) {
            book5 = new_book;
            cost_5 = book5.getPrice();
            i++;
        }

// hallo
        return;
    }
    // Calculates the total cost of the order which depends on the amount of books added to the order.
    public int getTotal_price()
    {
        if (i == 1)
            total_price = cost_1;
        if (i == 2)
            total_price = cost_1 + cost_2;
        if (i == 3)
            total_price = cost_1 + cost_2 + cost_3;
        if (i == 4)
            total_price = cost_1 + cost_2 + cost_3 + cost_4;
        if (i == 5)
            total_price = cost_1 + cost_2 + cost_3 + cost_4 + cost_5;

        return total_price;
    }


    // Some getMethods.
    public String getCustomerName() { return customerName; }
    public String getCustomerAddress() { return customerAddress; }
    public int getOrder_id(){return order_id;}

    public String toString ()
    {
        return "0";
    }

}