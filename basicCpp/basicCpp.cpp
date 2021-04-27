#include "basicCpp.h"
#include <iostream>
#include <climits>
#include <string>
#include <cstdlib>  // for rand(), srand()
#include <ctime>    // for time()
using namespace std;

int squareByValue (int number);        // Pass-by-value
void squareByReference (int & number); // Pass-by-reference

// To build: g++ -o basicCpp.exe basicCpp.h basicCpp.cpp
// To run: ./basicCpp
// To run with arguments: ./basicCpp test1 test2

basicCpp::basicCpp(int t)
{
    test1 = t;
}

void basicCpp::printVarSize()
{
    /*
    sizeof(char) is 1 bytes
    sizeof(short) is 2 bytes
    sizeof(int) is 4 bytes
    sizeof(long) is 4 bytes
    sizeof(long long) is 8 bytes
    sizeof(float) is 4 bytes
    sizeof(double) is 8 bytes
    sizeof(long double) is 12 bytes
    sizeof(bool) is 1 bytes
    */

    cout << "This is class print: %d"<< test1 << endl;
    cout << "sizeof(char) is " << sizeof(char) << " bytes " << endl;
    cout << "sizeof(short) is " << sizeof(short) << " bytes " << endl;
    cout << "sizeof(int) is " << sizeof(int) << " bytes " << endl;
    cout << "sizeof(long) is " << sizeof(long) << " bytes " << endl;
    cout << "sizeof(long long) is " << sizeof(long long) << " bytes " << endl;
    cout << "sizeof(float) is " << sizeof(float) << " bytes " << endl;
    cout << "sizeof(double) is " << sizeof(double) << " bytes " << endl;
    cout << "sizeof(long double) is " << sizeof(long double) << " bytes " << endl;
    cout << "sizeof(bool) is " << sizeof(bool) << " bytes " << endl;
    cout << "++++++++++++++++++++++++++++++++++" << endl;
    cout << "++++++++++++++++++++++++++++++++++" << endl;
}

void printVar2()
{
    cout << "This is function print:" << endl;
    cout << "int max = " << INT_MAX << endl;
    cout << "int min = " << INT_MIN << endl;
    cout << "unsigned int max = " << UINT_MAX << endl;
    cout << "long long max = " << LLONG_MAX << endl;
    cout << "long long min = " << LLONG_MIN << endl;
    cout << "unsigned long long max = " << ULLONG_MAX << endl;
    cout << "Bits in char = " << CHAR_BIT << endl;
    cout << "char max = " << CHAR_MAX << endl;
    cout << "char min = " << CHAR_MIN << endl;
    cout << "signed char max = " << SCHAR_MAX << endl;
    cout << "signed char min = " << SCHAR_MIN << endl;
    cout << "unsigned char max = " << UCHAR_MAX << endl;
    cout << "++++++++++++++++++++++++++++++++++" << endl;
    cout << "++++++++++++++++++++++++++++++++++" << endl;
}

void printString()
{
    string strTest("Test123 456");
    string strTest2;
    cout << "String length with strTest.length(): " << strTest.length() << endl;
    cout << "String size with strTest.size(): " << strTest.size() << endl;
    cout << "String is empty with strTest.empty(): " << strTest.empty() << endl;
    cout << "String is empty " << strTest.empty() << endl;
    strTest2 = strTest;
    cout << "String copy with \'=\' : " << strTest2 << endl;\
    cout << "String printing with at(): ";
    for (int i = 0; i < strTest.length(); i++)
    {
        cout << strTest.at(i) << " ";
    }
    cout<<endl;

    cout << "String substring with substr: " << strTest.substr(0,3) << endl;
    cout << "Check if equal with \'==\': " << (strTest == strTest2) << endl;
    cout << "Check if equal with compare: " << strTest.compare(strTest2) << endl;

}


void printArray()
{
    int marks[5];        // Declare an int array called marks with 5 elements
    double numbers[10];  // Declare an double array of 10 elements
    const int SIZE = 9;
    float temps[SIZE];   // Use const int as array length
    // Declare and initialize an int array of 3 elements
    int numbers2[3] = {11, 33, 44};
    // Use {0} or {} to initialize all elements to 0
    int numbers3[5] = {0};  // First element to 0, the rest also to zero
    int numbers4[5] = {};   // All element to 0 too
    int two_d[10][20];
}

void printCharString()
{
    char message[256];     // Declare a char array 
                       // Can hold a C-String of up to 255 characters terminated by '\0'
    char str1[] = "Hello"; // Declare and initialize with a "string literal".
                       // The length of array is number of characters + 1 (for '\0').
    char str1char[] = {'H', 'e', 'l', 'l', 'o', '\0'};  // Same as above
    char str2[256] = "Hello";  // Length of array is 256, keeping a smaller string.
}

int sum(int array[], int size) {
   int sum = 0;
   for (int i = 0; i < size; ++i) {
      sum += array[i];
   }
   return sum;
}

// In pass-by-value, a "copy" of argument is created and passed into the function. The invoked function works on the "clone", and cannot modify the original copy. In C/C++, fundamental types (such as int and double) are passed by value. That is, you cannot modify caller's value inside the function - there is no side effect.

// On the other hand, in pass-by-reference, a reference of the caller's variable is passed into the function. In other words, the invoked function works on the same data. If the invoked function modifies the parameter, the same caller's copy will be modified as well.

// In C/C++, arrays are passed by reference. That is, you can modify the contents of the caller's array inside the invoked function - there could be side effect in passing arrays into function.

//C/C++ does not allow functions to return an array. Hence, if you wish to write a function that modifies the contents of an array (e.g., sorting the elements of an array), you need to rely on pass-by-reference to work on the same copy inside and outside the function. Recall that in pass-by-value, the invoked function works on a clone copy and has no way to modify the original copy.

// Use const whenever possible for passing references as it prevent you from inadvertently modifying the parameters and protects you against many programming errors.

int linearSearch(const int a[], int size, int key) {
   for (int i = 0; i < size; ++i) {
      if (a[i] == key) return i;
   }
   return size;
}

int compareValueRef()
{
    int n1 = 8;
   cout << "Before call, value is " << n1 << endl;  // 8
   cout << squareByValue(n1) << endl;  // no side-effect
   cout << "After call, value is " << n1 << endl;   // 8
 
   int n2 = 9;
   cout << "Before call, value is " << n2 << endl;  // 9
   squareByReference(n2);  // side-effect
   cout << "After call, value is " << n2 << endl;   // 81
}

// Pass parameter by value - no side effect
int squareByValue (int number) {
   return number * number;
}
 
// Pass parameter by reference by declaring as reference (&)
// - with side effect to the caller
void squareByReference (int & number) {
   number = number * number;
}

void randTest()
{
    // rand() generate a random number in [0, RAND_MAX]
   cout << "RAND_MAX is " << RAND_MAX << endl;   // 32767
 
   // Generate 10 pseudo-random numbers between 0 and 99
   //   without seeding the generator.
   // You will get the same sequence, every time you run this program
   for (int i = 0; i < 10; ++i) {
      cout << rand() % 100 << " ";   // need <cstdlib> header
   }
   cout << endl;
 
   // Seed the random number generator with current time
   srand(time(0));   // need <cstdlib> and <ctime> header
   // Generate 10 pseudo-random numbers
   // You will get different sequence on different run,
   //   because the current time is different
   for (int i = 0; i < 10; ++i) {
      cout << rand() % 100 << " ";   // need <cstdlib> header
   }
   cout << endl;
}

// When you use different library modules, there is always a potential for name crashes, as different library may use the same name for different purposes. This problem can be resolved via the use of namespace in C++. A namespace is a collection for identifiers under the same naming scope. (It is known as package in UML and Java.) The entity name under a namespace is qualified by the namespace name, followed by :: (known as scope resolution operator), in the form of namespace::entityName.

// An enum is a user-defined type of a set of named constants, called enumerators. An enumeration define the complete set of values that can be assigned to objects of that type. For example,
enum Color {
   RED, GREEN, BLUE
} myColor; 

// The enumerators are represented internally as integers. You have to use the names in assignment, not the numbers. However, it will be promoted to int in arithmetic operations. By default, they are running numbers starting from zero. You can assigned different numbers, e.g.,
enum Color {
   RED = 1, GREEN = 5, BLUE
};

// A struct (structure) is a user-defined data structure that can be used to hold a set of variables of different types (called members). To defined a struct:
/*struct StructName {
   type1 var1;
   type2 var2;
   .......
};*/  // need to terminate by a semi-colon


int main (int argc, char** argv)
{
    basicCpp cppTestClass(10);
    
    cppTestClass.printVarSize();
    printVar2();
    printString();
    printArray();
    compareValueRef();
    randTest();

    return 0;
}


// A preprocessor directive begins with # (e.g., "#include <stdio.h>", "#define PI 3.14256295"). When you compile a C/C++ program, these commands will be pre-processed to produce the source file for the actual compilation (e.g., to include a specific header file in this program or to define a certain macro substitution).

// For example, in a header file (e.g., myHeader.h), the following directive are often used to prevent this header from included more than once in a source file.

//#pragma: The directive #pragma can be used to direct compiler for system-dependent information.