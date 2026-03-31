#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string add(string num1, string num2) {
        string ans;
        int index1 = num1.size() - 1;
        int index2 = num2.size() - 1;
        int carry = 0;

        // Add both strings
        while (index2 >= 0) {
            int sum = (num1[index1] - '0') + (num2[index2] - '0') + carry;
            carry = sum / 10;
            ans += (char)('0' + (sum % 10));
            index1--;
            index2--;
        }

        // Remaining digits of num1
        while (index1 >= 0) {
            int sum = (num1[index1] - '0') + carry;
            carry = sum / 10;
            ans += (char)('0' + (sum % 10));
            index1--;
        }

        // If carry remains
        if (carry) {
            ans += '1';
        }

        // Reverse result
        reverse(ans.begin(), ans.end());
        return ans;
    }

    string addStrings(string num1, string num2) {
        if (num1.size() < num2.size()) {
            return add(num2, num1);
        } else {
            return add(num1, num2);
        }
    }
};

int main() {
    Solution sol;

    string num1 = "11";
    string num2 = "123";
    cout << sol.addStrings(num1, num2) << endl; // 134

    string num3 = "456";
    string num4 = "77";
    cout << sol.addStrings(num3, num4) << endl; // 533

    string num5 = "0";
    string num6 = "0";
    cout << sol.addStrings(num5, num6) << endl; // 0

    return 0;
}

/*
---------- output -----------

➜  11_String git:(main) ✗ g++ addString.cpp -o addString
➜  11_String git:(main) ✗ ./addString 
134
533
0
➜  11_String git:(main) ✗   

*/