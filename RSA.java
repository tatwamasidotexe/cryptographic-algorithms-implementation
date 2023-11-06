import java.math.*;

public class RSA {
    public static void main(String[] args) {
        int p, q, n, d=0, e, phi;

        // plaintext in Zn
        double P = 12;

        System.out.println("Plaintext message = " + P);

        // prime numbers p and q
        p = 3;
        q = 11;

        System.out.println("p = " + p);
        System.out.println("q = " + q);

        n = p*q;
        phi = (p-1)*(q-1);

        System.out.println("n = " + n);
        System.out.println("phi = " + phi);

        // finding e s.t. e and phi are coprime
        for(e=2; e<phi; ++e) {
            if(gcd(phi, e) == 1) break;
        }

        System.out.println("e = " + e);

        // finding d = e^(-1) mod phi
        for(int i = 0; i<phi-1; ++i) {
            int x = 1 + i*phi;

            if(x%e == 0) {
                d = x/e;
                break;
            }
        }

        System.out.println("d = " + d);

        // encryption
        double c = Math.pow(P, e) % n;

        System.out.println("Encrypted message = " + c);

        BigInteger C = BigDecimal.valueOf(c).toBigInteger();

        BigInteger N = BigInteger.valueOf(n);

        BigInteger reply = (C.pow(d)).mod(N);

        System.out.println("Decrypted message = " + reply);

    }
    
    static int gcd(int b, int a) {
        if(b==0) return a;
        else return gcd(a%b, b);
    }
}