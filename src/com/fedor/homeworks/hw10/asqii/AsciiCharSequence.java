package com.fedor.homeworks.hw10.asqii;

public class AsciiCharSequence implements CharSequence {

    private byte[] ascii;

    public AsciiCharSequence(byte[] ascii) {
        this.ascii = ascii;
    }

    @Override
    public int length() {
        return ascii.length;
    }

    @Override
    public char charAt(int index) {
        return (char) ascii[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int size = end - start;
        int ind = 0;
        byte[] b = new byte[size];
        for (int i = start; i < end; i++) {
            b[ind] = ascii[i];
            ind++;
        }
        AsciiCharSequence acs = new AsciiCharSequence(b);
        return acs;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ascii.length; i++) {
            str.append((char) ascii[i]);
        }
        return str.toString();
    }
}
