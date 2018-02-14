// This creates an ascii array ... its index is its asii char

public class Ascii {
    public static void main (String args []) {
        char [] ascii = new char[128];
        int index = 0;
        //for(int =33; i <127;) {
        for (char c='!'; c <= '~'; c++) {
            ascii[index++] = c;
        }
        String result = new String(ascii);
        System.out.println(result);
       // System.out.println(ascii[45]);
            //System.out.println(Character.toString((char)i));}
        //System.out.println((char)i);
    }
}
