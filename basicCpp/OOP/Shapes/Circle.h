#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"

class Circle : public Shape
{
    private:
        int radius;

    public:
        Circle(int radius = 1, const std::string& color = "red");
        int getRadius() const;  //getter
        void setRadius(int radius); // setter
        void print() const; // Override the virtual function
        double getArea() const; // to implement virtual function    

};

#endif