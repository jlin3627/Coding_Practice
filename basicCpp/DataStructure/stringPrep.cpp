#include <iostream>
#include <string>
#include <cstdlib>

int main()
{
    std::string str("There are two needles in this haystack with needles.");
    std::string str2("needle");
    int iFind = str.find(str2);
    if(iFind != std::string::npos)
    {
        std::cout<<str2<<" index: "<<iFind<<std::endl;
    }
    
    int iFind2 = str.find("needles are small", iFind+1);
    if (iFind2!=std::string::npos)
    {
        std::cout<<"needle 2 index: "<<iFind2<<std::endl;
    }

    iFind = str.find("needles are small", iFind+1,6);
    if (iFind!=std::string::npos)
    {
        std::cout<<"needle 2 index: "<<iFind<<std::endl;
    }

    iFind = str.find("haystack");
    if (iFind!=std::string::npos)
    {
        std::cout<<"haystack index: "<<iFind<<std::endl;
    }

    for (int i = 0; i<str.size();i++)
    {
        std::cout<<str.at(i);
    }
    std::cout<<std::endl;

    for (auto itr = str.cbegin(); itr!=str.cend(); ++itr)
    {
        std::cout<<(*itr);
    }
    std::cout<<std::endl;


    // substring prep
    std::string subStrTest = str.substr(0,10);
    std::string subStrTest2 = str.substr(iFind);

    std::cout<<"substr 0 to 10: "<<subStrTest<<std::endl;
    std::cout<<"subStr from haystack: "<<subStrTest2<<std::endl;
    return 0;
}