import java.math.BigInteger;
public class Factorial{
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
