cmake_minimum_required(VERSION 3.18.2)
project(basicCpp VERSION 0.1.0)

include(CTest)
#enbale_testing()

#Bring the headers, such as Student.h into the project
#include_directories(include)
 
#Can manually add the sources using the set command as follows:
#set(SOURCES src/basicCpp.cpp)
 
#However, the file(GLOB...) allows for wildcard additions:
#file(GLOB SOURCES "src/*.cpp")
 
add_executable(basicCpp basicCpp.h basicCpp.Cpp)

set(CPACK_PROJECT_NAME ${PROJECT_NAME})
set(CPACK_PROJECT_VERSION ${PROJECT_VERSION})
include(CPack)