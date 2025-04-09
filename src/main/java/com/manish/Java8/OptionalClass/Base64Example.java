package com.manish.Java8.OptionalClass;

import java.util.Base64;

public class Base64Example {
    public Base64Example() {
    }

    public static void main(String[] args) {
        String originalInput = "Hello, world!";
        String encodedString = encodeBase64(originalInput);
        System.out.println("Encoded string: " + encodedString);
        String decodedString = decodeBase64(encodedString);
        System.out.println("Decoded string: " + decodedString);
    }

    public static String encodeBase64(String input) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(input.getBytes());
    }

    public static String decodeBase64(String encodedInput) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encodedInput);
        return new String(decodedBytes);
    }
}
