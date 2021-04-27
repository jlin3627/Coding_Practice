#include "Shape.h"
#include <iostream>

Shape::Shape(const std::string& color)
{
    this->color = color;
}

std::string Shape::getColor() const
{
    return color;
}

void Shape::setColor(const std::string &color)
{
    this->color = color;
}

void Shape::setColor(const std::string &color)
{
    this->color = color;
}

void Shape::print() const
{
    std::cout<< "Shape of color=" <<color;
}

