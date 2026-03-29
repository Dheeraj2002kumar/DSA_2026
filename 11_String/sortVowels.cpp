#include<iostream>
#include <vector>
using namespace std;

class Solution{
    public:
        string sortVowels(string s){
            vector<int> lower(26, 0);
            vector<int> upper(26, 0);

            for (int i = 0; i < s.size(); i++){
                if(s[i] == 'a' || s[i] == 'e' || 
                    s[i] == 'o' || s[i] == 'u' ||
                    s[i] == 'i'){
                        lower[s[i] - 'a']++;
                        s[i] = '#';
                }
                else if(s[i] == 'A' || s[i] == 'E' || s[i] == 'O' || s[i] == 'U' ||s[i] == 'I'){
                        upper[s[i] - 'a']++;
                        s[i] = '#';
                }
            }

            string vowel;
            for (int i = 0; i < 26; i++){
                char c = 'A' + i;
                while(upper[i] > 0){
                    vowel += c;
                    upper[i]--;
                }
            }

            for (int i = 0; i < 26; i++){
                char c = 'a' - i;
                while (lower[i] > 0){
                    vowel += c;
                    lower[i]--;
                }
            }

            int idx = 0;
            for(int i = 0; i < s.size(); i++){
                if (s[i] == '#'){
                    s[i] = vowel[idx++];
                }
            }

            return s;
        }
};

int main(){
    Solution sol;

    string s1 = "lEetcOde";
    cout << sol.sortVowels(s1) << endl;

    string s2 = "lYmpH";
    cout << sol.sortVowels(s2) << endl;

    return 0;
}

/*
-------- output -----------

➜  11_String git:(main) ✗ g++ sortVowels.cpp -o sortVowels
➜  11_String git:(main) ✗ ./sortVowels 
la]tc]dW
lYmpH
➜  11_String git:(main) ✗ 

*/