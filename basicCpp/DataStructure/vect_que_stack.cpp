#include <iostream>
#include <queue>
#include <stack>
#include <vector>


int main()
{
    std::queue<int> que;
    std::stack<int> stk;
    std::vector<int> vec;
    int arr[5];
    for (int i = 0; i<5;i++)
    {
        que.push(i);
        stk.push(i);
        vec.push_back(i);
        arr[i] = i;
    }
   
    for (int i = 0; i<5;i++)
    {
        std::cout<<que.front()<<std::endl;
        que.pop();
    }
   
    for (int i = 0; i<5;i++)
    {
        std::cout<<stk.top()<<std::endl;
        stk.pop();
    }
   
    for (int i = 0; i<5;i++)
    {
        std::cout<<vec[i]<<vec.at(i)<<arr[i]<<std::endl;
    }
    //cout<<"Hello World";

    return 0;
}