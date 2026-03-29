import java.util.*;

public class longestPalindrome {
    public int findLongestPalindrome(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean odd = false;

        for (int freq : map.values()) {
            if (freq % 2 == 0){
                length += freq;
            } else{
                length += freq - 1;
                odd = true;
            }
        }

        return length + (odd ? 1 : 0);
    }

    public static void main(String[] args){
        longestPalindrome longP = new longestPalindrome();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.next();

        System.out.println("Longest Palindrome Length: " + longP.findLongestPalindrome(s));
    }
}
/*
========= Output ===========

➜  string_java git:(main) ✗ javac -d out longestPalindrome.java
➜  string_java git:(main) ✗ java -cp out longestPalindrome     
Enter string: abaccd
Longest Palindrome Length: 5
➜  string_java git:(main) ✗ 

*/


// ----------------------------------

// import java.util.*;

// public class longestPalindrome {
//     public int findLongestPalindrome(String s){
//         int[] lower = new int[26];
//         int[] upper = new int[26];

//         // count frequencies
//         for(int i = 0; i < s.length(); i++){
//             char ch = s.charAt(i);
//             if (ch >= 'a' && ch <= 'z'){
//                 lower[ch - 'a']++;
//             } else{
//                 upper[ch - 'A']++;
//             }
//         }

//         int count = 0;
//         boolean odd = false;

//         // calculate palindrome length
//         for (int i = 0; i < 26; i++){
//             if (lower[i] % 2 == 0){
//                 count += lower[i];
//             } else{
//                 count += lower[i] - 1;
//                 odd = true;
//             }

//             if (upper[i] % 2 == 0){
//                 count += upper[i];
//             } else{
//                 count += upper[i] - 1;
//                 odd = true;
//             }
//         }

//         return count + (odd ? 1 : 0);
//     }    

//     public static void main(String[] args){
//         longestPalindrome longPolinedrome = new longestPalindrome();
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter String: ");
//         String s = sc.next();
        
//         int result = longPolinedrome.findLongestPalindrome(s);
//         System.out.println("Longest palindrome Length: " + result);

//         sc.close();
        
//     }
// }

// output ------------
//   string_java git:(main) ✗ javac -d out longestPalindrome.java 
//  string_java git:(main) ✗ java -cp out longestPalindrome 
// Enter String: abaccdd
// Longest palindrome Length: 7