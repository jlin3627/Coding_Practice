#include <iostream>

int main(int argc, char** argv)
{
    int iArr[5] = {};
    int iArr2[5] = {1,2,3,4,5};
    int iArr3[] = {6,7,8};
    int twodArr[3][4];

    for (int i = 0; i<5;i++)     std::cout<< iArr[i] << std::endl;
    for (int i = 0; i<5; i++)   std::cout<< iArr2[i] << std::endl;
    for (int i = 0; i<3; i++) std::cout<< iArr3[i] << std::endl;

    return 0;
}