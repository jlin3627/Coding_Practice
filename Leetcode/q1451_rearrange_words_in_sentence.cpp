class Solution {
public:
    string arrangeWords(string text) 
    {
        string word = "";
        text[0] = tolower(text[0]);
        text += ' ';
        for(int i = 0; i<text.size(); i++)
        {
            if( text[i] == ' ')
            {
                
                ans.push_back(make_pair(word,i));
                word = "";
            }
            else
            {
                word+=text[i];
            }
        }
        sort(ans.begin(),ans.end(), sizeCompare);
        
        string final_ans = ans[0].first;
        final_ans[0] = toupper(final_ans[0]);
        for(int i = 1; i< ans.size(); i++)
        {
            
            final_ans += " " + ans[i].first;
            
        }
        return final_ans;
    }
    
    static bool sizeCompare (pair<string,int>&a,pair<string,int>&b)
    {
        if(a.first.size() == b.first.size())
        {
            return a.second<b.second;
        }
        return a.first.size()<b.first.size();
    }
    
private:
    vector<pair<string,int>> ans;
    
};