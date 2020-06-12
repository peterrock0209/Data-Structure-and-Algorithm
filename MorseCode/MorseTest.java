package MorseCode;

/**
 * Main test class for Morse Code project.
 */
public class MorseTest {
 
    public static void main(String[] args) {
        MorseCoder mc = new MorseCoder();
         	System.out.print("Morse Code: ");
            mc.inOrderPrint();
            System.out.println();
            System.out.println("Morse Code Binary Tree ");
            mc.print(mc.getLetter(), 0);
            // sos decode
            System.out.println("Decode Test 1");
            String str = "... --- ..."; 
            System.out.println("Letter: " + str);
            System.out.println("After decoding: sos");
            System.out.println("Decode(str): " + mc.decode(str));
            testResults("sos", mc.decode(str));

            // abcdef...xyz decode
            System.out.println("Decode Test 2");
            str = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -."
                + " --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
            System.out.println("Letter: " + str);
            System.out.println("After decoding: abcdefghijklmnopqrstuvwxyz");
            System.out.println("Decode(str): " + mc.decode(str));
            testResults("abcdefghijklmnopqrstuvwxyz", mc.decode(str));
          
            // helpmeobiwanyouremyonlyhope decode
            System.out.println("Decode Test 3");
            str = ".... . .-.. .--. -- . --- -... .. .-- .- -. -.-- --- ..-"
                + " .-. . -- -.-- --- -. .-.. -.-- .... --- .--. .";
            System.out.println("Letter: " + str);
            System.out.println("After decoding: helpmeobiwanyouremyonlyhope");
            System.out.println("Decode(str): " + mc.decode(str));
            testResults("helpmeobiwanyouremyonlyhope", mc.decode(str));
         
            // --.. encode
            System.out.println("Encode Test 1");
            str = "z";
            System.out.println("Letter: " + str);
            System.out.println("After encoding: --..");
            System.out.println("Encode(str): " + mc.encode(str));
            testResults("--..", mc.encode(str));
         
            // ... --- ... encode
            System.out.println("Encode Test 2");
            str = "sos";
            System.out.println("Letter: " + str);
            System.out.println("After encoding: ... --- ...");
            System.out.println("Encode(str): " + mc.encode(str));
            testResults("... --- ...", mc.encode(str));
         
            // .-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -. encode
            System.out.println("Encode Test 3");
            str = "runforrestrun";
            System.out.println("Letter: " + str);
            System.out.println("After encoding: .-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -.");
            System.out.println("Encode(str): " + mc.encode(str));
            testResults(".-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -.", mc.encode(str));
         
    }
     
    /**
     * Tests if the output string matches the expected.
     * Prints "Passed" if they match, otherwise prints "Failed"
     * @param one String - Expected output
     * @param two String - Encoded/Decoded call
     */
    public static void testResults(String one, String two) {
        if(one.trim().equals(two.trim()))
            System.out.println("-> Passed");
        else
            System.out.println("-> Failed");
        System.out.println();
    }
 
}
