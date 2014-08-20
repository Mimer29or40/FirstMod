package com.mimer29or40.firstmod.util;

public class Box
{
    public Vector3 one;
    public Vector3 two;
    public Vector3 three;
    public Vector3 four;

    public Box(Vector3 one, Vector3 two, Vector3 three, Vector3 four)
    {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

//    public Box(Vector3 one, Vector3 three)
//    {
//        this.one = one;
//        this.three = three;
//        double radius = this.one.distance(this.three) * 0.5D;
//        Vector3 midpoint = this.one.midpoint(this.three);
//
//    }

    public Box()
    {
        this.one = Vector3.zero;
        this.two = Vector3.zero;
        this.three = Vector3.zero;
        this.four = Vector3.zero;
    }

    public double perimeter()
    {
        double perimeter = 0D;
        perimeter += this.one.distance(this.two);
        perimeter += this.two.distance(this.three);
        perimeter += this.three.distance(this.four);
        perimeter += this.four.distance(this.one);

        return perimeter;
    }

    public double area()
    {
        double area = 0D;
        return area;
    }
}