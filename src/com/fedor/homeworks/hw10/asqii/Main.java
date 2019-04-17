package com.fedor.homeworks.hw10.asqii;

public class Main {
    public static void main(String[] args) {

        byte[] arrayAscii = {34, 111, 99, 88, 44, 100};
        AsciiCharSequence word = new AsciiCharSequence(arrayAscii);
        System.out.println("lineOfSymbol: " + word.toString());
        System.out.println("Length: " + word.length());
        System.out.println("SymbolFirst:" + word.charAt(1));
        System.out.println("PartOfLine: " + word.subSequence(2, 4));
    }
}
