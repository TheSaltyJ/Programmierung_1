import java.math.BigInteger;
public class Factorial{
    // The recursive function of factorial is more efficient (with regard to computing time) as the fibonacci function, because for factorial of n the function is called n-times.
    // This basically translates to an algorithm O(n) which has polynomial time.
    public static void main(String[] args){

        int n = Integer.parseInt(args[0]);
        A = new BigInteger(n);

        System.out.println(factorial(n));

    }

    public static BigInteger factorial(BigInteger n){
        BigInteger fac_result = new BigInteger("1");

        if (n==1)
            fac_result = 1;
        else
            fac_result = n.multiply(factorial(n-1));

        return fac_result;
    }
}
