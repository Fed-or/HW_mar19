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
        if (end >= start) {
            int size = end - start;
            int ind = 0;
            byte[] arrayAsciiSymbols = new byte[size];
            for (int i = start; i < end; i++) {
                arrayAsciiSymbols[ind] = ascii[i];
                ind++;
            }
            AsciiCharSequence acs = new AsciiCharSequence(arrayAsciiSymbols);
            return acs;
        }
        return null;
    }

        @Override
        public String toString () {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < ascii.length; i++) {
                str.append((char) ascii[i]);
            }
            return str.toString();
        }
    }
