package com.fedor.homeworks.hw10.complexnumber;

public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || (this.getClass() != obj.getClass())) {
            return false;
        }
        ComplexNumber number = (ComplexNumber) obj;
        if (Double.doubleToLongBits(im) != (Double.doubleToLongBits(number.im)) ||
                Double.doubleToLongBits(re) != (Double.doubleToLongBits(number.re))) {
            return false;
        }
        return true;
    }

    int hashcode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(im);
        result = result*prime + (int) (temp^(temp >>> 32));
        temp = Double.doubleToLongBits(re);
        result = result*prime + (int) (temp^(temp>>> 32));
        return result;
    }

}
