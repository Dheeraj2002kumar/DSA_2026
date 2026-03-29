#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution{
    public:
        string sortString(string s) {
            vector<int> alpha(26, 0);

            for (int i = 0; i < s.size(); i++){
                alpha[s[i] - 'a']++;
            }

            string ans;
            for (int i = 0; i < 26; i++){
                char c = 'a' + i;

                while(alpha[i] > 0){
                    ans += c;
                    alpha[i]--;
                }
            }

            return ans;
        }
};

int main(){
    Solution obj;

    string s1 = "edcab";
    cout << "Input: " << s1 << endl;
    cout << "Output: " << obj.sortString(s1) << endl;

    string s2 = "xyz";
    cout << "\nInput: " << s2 << endl;
    cout << "Output: " << obj.sortString(s2) << endl;

    return 0;
}