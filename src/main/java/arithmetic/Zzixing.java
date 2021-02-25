package arithmetic;

public class Zzixing {

    public static void main(String[] args) {
        zzixing("0123456789abc",3);
    }
    public static void zzixing(String s ,int numRows) {


        char[] chars = s.toCharArray();
//        System.out.println(chars[(numRows+1)*0]); ;
//        System.out.println(chars[(numRows+1)*1]); ;
//        System.out.println(chars[(numRows+1)*2]); ;
//        System.out.println(chars[(numRows+1)*3]);

        System.out.println(chars[(numRows)]);
        System.out.println(chars[(numRows)]);
        System.out.println(chars[(numRows+2*1)]);
        System.out.println(chars[(numRows+2*2)]);
        System.out.println(chars[(numRows+2*3)]);
        System.out.println(chars[(numRows+2*4)]);

//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(chars[(numRows-1)*2^i]); ;
//        }

    }
}
