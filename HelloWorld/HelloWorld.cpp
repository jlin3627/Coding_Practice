#include <iostream>
using namespace std;


// To build: g++ -o HelloWorld.exe HelloWorld.cpp
// To run: ./HelloWorld
// To run with arguments: ./HelloWorld test1 test2

int main(int argc, char** argv)
{
    cout<<"HelloWorld"<<endl;
    for (int i =0; i<argc; ++i)
    {
        cout << argv[i] << endl;
    }
    cout<<"Hello World"<<endl;
    return 0;
}