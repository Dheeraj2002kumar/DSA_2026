public class addString {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String num1 = "11";
        String num2 = "123";
        System.out.println(sol.addStrings(num1, num2)); // 134

        String num3 = "456";
        String num4 = "77";
        System.out.println(sol.addStrings(num3, num4)); // 533

        String num5 = "0";
        String num6 = "0";
        System.out.println(sol.addStrings(num5, num6)); // 0
    }
}

class Solution {

    public String add(String num1, String num2) {
        StringBuilder ans = new StringBuilder();

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;

        // Add both strings
        while (index2 >= 0) {
            int sum = (num1.charAt(index1) - '0') +
                      (num2.charAt(index2) - '0') + carry;

            carry = sum / 10;
            ans.append((char) ('0' + (sum % 10)));

            index1--;
            index2--;
        }

        // Remaining digits of num1
        while (index1 >= 0) {
            int sum = (num1.charAt(index1) - '0') + carry;

            carry = sum / 10;
            ans.append((char) ('0' + (sum % 10)));

            index1--;
        }

        // If carry remains
        if (carry != 0) {
            ans.append('1');
        }

        // Reverse result
        return ans.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return add(num2, num1);
        } else {
            return add(num1, num2);
        }
    }
}