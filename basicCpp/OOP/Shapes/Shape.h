#ifndef SHAPE_H
#define SHAPE_H

#include <string>

class Shape
{
private: 
    std::string color;
public:
    Shape(const std::string& color = "red");    
    std::string getColor() const;
    void setColor(const std::string& color);
    // virtual function, run subclass version if overriden
    virtual void print() const;
    // pure virtual, to be implemented by subclass
    // cannot crate instance of shape
    virtual double getArea() const = 0;
};

#endif