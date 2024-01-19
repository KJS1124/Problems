package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-19
 * Time:00:26
 */
public class Power {
    public double myPow(double x, long n) {
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        if(n==0) return 1;
        if(n==1) return x;

        double ans = myPow(x, n/2);
        ans *=ans;

        if(n%2==1) ans*=x;
        return ans;
    }
}
