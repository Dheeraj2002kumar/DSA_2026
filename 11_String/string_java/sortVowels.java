import java.util.*;

public class sortVowels {
    public String convertSortVowels(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        char[] arr = s.toCharArray();

        // Step 1: Count vowels
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == 'a' || c == 'e' || c == 'i' || 
                c == 'o' || c == 'u') {
                lower[c - 'a']++;
                arr[i] = '#';
            } 
            else if (c == 'A' || c == 'E' || c == 'I' || 
                     c == 'O' || c == 'U') {
                upper[c - 'A']++;
                arr[i] = '#';
            }
        }

        // Step 2: Build sorted vowels
        StringBuilder vowels = new StringBuilder();

        // Uppercase first
        for (int i = 0; i < 26; i++) {
            while (upper[i]-- > 0) {
                vowels.append((char) ('A' + i));
            }
        }

        // Lowercase next
        for (int i = 0; i < 26; i++) {
            while (lower[i]-- > 0) {
                vowels.append((char) ('a' + i));
            }
        }

        // Step 3: Replace vowels
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '#') {
                arr[i] = vowels.charAt(idx++);
            }
        }

        return new String(arr);
    }
    
    public static void main(String[] args) {
        sortVowels sol = new sortVowels();

        String s1 = "lEetcde";
        System.out.println(sol.convertSortVowels(s1));

        String s2 = "lYmpH";
        System.out.println(sol.convertSortVowels(s2));
    }    
}


// import java.util.*;

// public class sortVowels {
//     public String convertSortVowels(String s){
//         Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

//         List<Character> vowels = new ArrayList<>();

//         for(char c : s.toCharArray()){
//             if (vowelsSet.contains(c)){
//                 vowels.add(c);
//             }
//         }

//         Collections.sort(vowels);
//         StringBuffer result = new StringBuffer();
//         int index = 0;

//         for (char c : s.toCharArray()){
//             if (vowelsSet.contains(c)){
//                 result.append(vowels.get(index++));
//             } else{
//                 result.append(c);
//             }
//         }

//         return result.toString();
//     }    

//     public static void main(String[] args) {
//         sortVowels sol = new sortVowels();

//         String s1 = "lEetcde";
//         System.out.println(sol.convertSortVowels(s1));

//         String s2 = "lYmpH";
//         System.out.println(sol.convertSortVowels(s2));
//     }    
// }
