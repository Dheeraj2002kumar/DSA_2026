#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
    public:
        bool checkIfPangram(string sentence){
            vector<bool> alpha(26, 0);

            for (int i = 0; i < sentence.size(); i++){
                alpha[sentence[i] - 'a'] = 1;
            }

            for (int i = 0; i < 26; i++){
                if (alpha[i] == 0){
                    return false;
                }
            }
            return true;
        }
};

int main(){
    Solution obj;

    string sentence1 = "thequickbrownfoxjumpsoverthelazydog";
    cout << "Input: " << sentence1 << endl;
    cout << "Output: " << (obj.checkIfPangram(sentence1) ? "true" : "false") << endl;

    string sentence2 = "leetcode";

    cout << "\nInput: " << sentence2 << endl;
    cout << "Output: " << (obj.checkIfPangram(sentence2) ? "true" : "false") << endl;

    return 0;
}