import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class homework1{
    // Encrypts text using a shift of s 
    public static StringBuffer encrypt(String text, int s) 
    { 
        StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) + 
                                  s - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) + 
                                  s - 97) % 26 + 97); 
                result.append(ch); 
            } 
        } 
        return result; 
    } 
    // Decrypts text using a shift of s 
    public static StringBuffer decrypt(String text, int s) 
    { 
        StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) - 
                                  s - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) - 
                                  s - 97) % 26 + 97); 
                result.append(ch); 
            } 
        } 
        return result; 
    } 

    

    public static void main(String[] args) throws FileNotFoundException {
       
        System.out.println("[---------Enhanced Caeser Cipher:--------]");
        System.out.println("Part 1");

        System.out.println("ENCRYPTION:");
        System.out.print("Input plaintext: ");
        Scanner scan = new Scanner(System.in);
        String plaintext = scan.nextLine();
        //System.out.println(plaintext);
        System.out.print("Input key: ");
        String key = scan.nextLine();
        int k = Integer.parseInt(key);
        StringBuffer cText = encrypt(plaintext,k);
        String cipherText = cText.toString();
        System.out.println("Output Ciphertext: " + cipherText);

        System.out.println("DECRYPTION:");
        System.out.print("Input Ciphertext: ");
        String cText2 = scan.nextLine();
        System.out.print("Input key: ");
        String key2 = scan.nextLine();
        int k2 = Integer.parseInt(key2);
        StringBuffer pText = decrypt(cText2, k2);
        String plainText2 = pText.toString();
        System.out.println("Output PlainText: " + plainText2);

        //Part2
        System.out.println("Part 2");
        System.out.println("User-input ciphertext message: ");
        String ciphertext3 = scan.nextLine();
        String plaintext3 = "";
        System.out.println("User-specified vocabulary text file (include filepath for best results): ");
        String filename = scan.nextLine();
        System.out.println("inputfile: " + filename);

        Scanner x = new Scanner(new File("/Users/aaronfaubion/Desktop/Cryptography/Homework1/sample.txt"));
        //Scanner x = new Scanner(new File(filename));
        ArrayList<String> list = new ArrayList<String>();
    
        while(x.hasNext())
        {
            String a = x.next();
            list.add(a);
        }

        x.close();
        scan.close();
        /** 
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        */

        String[] cipharray = ciphertext3.split(" ");
        for(int i = 0; i < list.size(); i++)
        {
            if(cipharray[0].length() == list.get(i).length())
            {
                char cchar = cipharray[0].charAt(0); //first letter of cipherword
                char pchar = list.get(i).charAt(0);
                int val = (int)cchar - (int)pchar;
                boolean match = false;
                for(int j = 1; j < cipharray[0].length(); j++)
                {
                    if((int)cipharray[0].charAt(j) - val == (int)list.get(i).charAt(j))
                    {
                        match = true;
                    }
                    else
                    {
                        match = false;
                    }
                }
                if(match == true)
                {
                    System.out.println("Key : " + val);
                    System.out.println("Decrypted text: " + decrypt(ciphertext3, val));
                }
            }
        }

    }
    
}