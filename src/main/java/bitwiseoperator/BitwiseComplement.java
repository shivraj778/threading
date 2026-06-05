package bitwiseoperator;

public class BitwiseComplement {
    public static int bitwiseComplement(int n) {
        int num = 0;
        if (n==0) return 1;
        while (num < n) {
            num = (num << 1) | 1;
        }
        return ~n & num;
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
    }
}
