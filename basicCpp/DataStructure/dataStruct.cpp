#include <iostream>

int main()
{
    int arrTest[10] ={0};
    for (int i = 0; i<sizeof(arrTest)/sizeof(int); i++)
    {
        std::cout<<arrTest[i];
    }
    std::cout<<std::endl;
    return 0;
}