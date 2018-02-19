import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class DijaAverage {
    public static void main(String a[]) {
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bayqu\\Desktop\\Computer Science\\CS3321\\assignment2\\src\\ticker.txt"));
            while (strLine != null) {
                strLine = br.readLine();
                sb.append(strLine);
                sb.append(System.lineSeparator());
                if (strLine == null)
                    break;
                list.add(strLine);
            }
            //System.out.println(Arrays.toString(list.toArray()));
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        //String num1 = list.get(0);
        //System.out.println(list.get(0));
        char[] ascii = new char[128];
        ascii[33] = '!';
        ascii[34] = '"';
        ascii[35] = '#';
        ascii[36] = '$';
        ascii[37] = '%';
        ascii[38] = '&';
        ascii[39] = '\'';
        ascii[40] = '(';
        ascii[41] = ')';
        ascii[42] = '*';
        ascii[43] = '+';
        ascii[44] = ',';
        ascii[45] = '-';
        ascii[46] = '.';
        ascii[47] = '/';
        ascii[48] = '0';
        ascii[49] = '1';
        ascii[50] = '2';
        ascii[51] = '3';
        ascii[52] = '4';
        ascii[53] = '5';
        ascii[54] = '6';
        ascii[55] = '7';
        ascii[56] = '8';
        ascii[57] = '9';
        ascii[58] = ':';
        ascii[59] = ';';
        ascii[60] = '<';
        ascii[61] = '=';
        ascii[62] = '>';
        ascii[63] = '?';
        ascii[64] = '@';
        ascii[65] = 'A';
        ascii[66] = 'B';
        ascii[67] = 'C';
        ascii[68] = 'D';
        ascii[69] = 'E';
        ascii[70] = 'F';
        ascii[71] = 'G';
        ascii[72] = 'H';
        ascii[73] = 'I';
        ascii[74] = 'J';
        ascii[75] = 'K';
        ascii[76] = 'L';
        ascii[77] = 'M';
        ascii[78] = 'N';
        ascii[79] = 'O';
        ascii[80] = 'P';
        ascii[81] = 'Q';
        ascii[82] = 'R';
        ascii[83] = 'S';
        ascii[84] = 'T';
        ascii[85] = 'U';
        ascii[86] = 'V';
        ascii[87] = 'W';
        ascii[88] = 'X';
        ascii[89] = 'Y';
        ascii[90] = 'Z';
        ascii[91] = '[';
        ascii[92] = '\\';
        ascii[93] = ']';
        ascii[94] = '^';
        ascii[95] = ';';
        ascii[96] = '`';
        ascii[97] = 'a';
        ascii[98] = 'b';
        ascii[99] = 'c';
        ascii[100] = 'd';
        ascii[101] = 'e';
        ascii[102] = 'f';
        ascii[103] = 'g';
        ascii[104] = 'h';
        ascii[105] = 'i';
        ascii[106] = 'j';
        ascii[107] = 'k';
        ascii[108] = 'l';
        ascii[109] = 'm';
        ascii[110] = 'n';
        ascii[111] = 'o';
        ascii[112] = 'p';
        ascii[113] = 'q';
        ascii[114] = 'r';
        ascii[115] = 's';
        ascii[116] = 't';
        ascii[117] = 'u';
        ascii[118] = 'v';
        ascii[119] = 'w';
        ascii[120] = 'x';
        ascii[121] = 'y';
        ascii[122] = 'z';
        ascii[123] = '{';
        ascii[124] = '|';
        ascii[125] = '}';
        ascii[126] = '~';
        // a few arrays that will be used to parse the data string
        String[] ar;
        String[] s1;
        byte[] btArray;
        char[] temp;

        double realSum = 0;
        for (int index = 0; index < list.size(); index++) {
            //System.out.println(list.get(index));

            try {
                URL url = new URL("https://query1.finance.yahoo.com/v8/finance/chart/" + list.get(index) + "?interval=2m");
                URLConnection urlConnection = url.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                // System.out.println(line);
                btArray = line.getBytes();
                temp = new char[btArray.length];
                int n = 0;
                for (int i = 0; i < btArray.length; i++)
                    temp[n++] = ascii[btArray[i]];
                // saving the temp array as a String variable
                line = new String(temp);
                // parse the string to find the closing price
                ar = line.split("\"symbol\":");
                s1 = ar[1].split(",");
                System.out.print(s1[0]);
                ar = line.split("\"previousClose\":");
                s1 = ar[1].split(",");
                System.out.println(" " + s1[0]);
                //System.out.println(s1[0]);
                double tempSum = Double.parseDouble((s1[0]));
                //realSum = 0;
                realSum = realSum + tempSum;
                //System.out.println(realSum);
            } catch (MalformedURLException mle) {
                mle.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }
        // double realSum;
        double DIJA = realSum / .14602128057775;
        System.out.println("Dija = " + String.format("%.2f", DIJA));

    }
}