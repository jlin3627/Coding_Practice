#include<map>
#include<unordered_map>
#include<set>
#include<unordered_set>
#include<iostream>
#include<string>
#include<vector>
#include<algorithm>


bool sortByValDes(const std::pair<char,int> &a, const std::pair<char,int> &b)
{
    return (a.second > b.second);
}

bool sortByValAss(const std::pair<char,int> &a, const std::pair<char,int> &b)
{
    return (a.second < b.second);
}

int main()
{
    std::string testStr("asdkgljdkbhcvkbjnhrdkfghnsaodfidvcuojkrgjwierythwsjahhsjudfghksglkv;mdgvbsiadfrhguasdfkjasfhpjbfidzoigja;fjioiojzkl;klxnfvpkjozxkvyhuriwaerhsfkj");
    std::map<char,int> testMp;
    std::unordered_map<char,int> testUMp;
    std::set<char> testSt;
    std::unordered_set<char> testUSt;
    std::vector<std::pair<char,int>> vecTest;

    for (int i = 0; i<testStr.size();i++)
    {
        char ch = testStr.at(i);
        testMp[ch]++;
        testUMp[ch]++;
        testUSt.insert(ch);
        testSt.insert(ch);
    }

    std::cout<<"Ordered Map"<<std::endl;
    for (auto itr = testMp.cbegin(); itr!= testMp.cend(); ++itr)
    {
        std::cout<<(*itr).first<<":"<<(*itr).second<<" ";
        vecTest.push_back(std::make_pair((*itr).first,(*itr).second));
    }
    std::cout<<std::endl;
    
    std::cout<<"Unordered Map"<<std::endl;
    for (auto itr = testUMp.cbegin(); itr!= testUMp.cend(); ++itr)
    {
        std::cout<<(*itr).first<<":"<<(*itr).second<<" ";
    }
    std::cout<<std::endl;

    std::cout<<"Ordered Set"<<std::endl;
    for (auto itr = testSt.cbegin(); itr!= testSt.cend(); ++itr)
    {
        std::cout<<(*itr);
    }
    std::cout<<std::endl;

    std::cout<<"Unordered set"<<std::endl;
    for (auto itr = testUSt.cbegin(); itr!=testUSt.cend(); ++itr)
    {
        std::cout<<(*itr);
    } 
    std::cout<<std::endl;

    std::cout<<"Ordered vector by value"<<std::endl;
    std::sort(vecTest.begin(),vecTest.end(), sortByValDes);
    for (int i = 0; i<vecTest.size();i++)
    {
        std::cout<<vecTest[i].first<<":"<<vecTest[i].second<<" ";
    }
    std::cout<<std::endl;

    std::sort(vecTest.begin(),vecTest.end(), sortByValAss);
    for (int i = 0; i<vecTest.size();i++)
    {
        std::cout<<vecTest[i].first<<":"<<vecTest[i].second<<" ";
    }
    std::cout<<std::endl;
    return 0;
}