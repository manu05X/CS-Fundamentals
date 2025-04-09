package com.manish.Java8.OptionalClass;

import java.util.Optional;

public class OptionalClassExample {
    public OptionalClassExample() {
    }

    public static void main(String[] args) {
        OptionalClassExample example = new OptionalClassExample();
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");
        System.out.println("Non-Empty Optional: " + String.valueOf(nonEmptyOptional));
        System.out.println("Value: " + (String)nonEmptyOptional.get());
        Optional<String> nullableOptional = Optional.ofNullable(example.getNullableValue());
        System.out.println("Nullable Optional: " + String.valueOf(nullableOptional));
        nullableOptional.ifPresent((value) -> {
            System.out.println("Value: " + value);
        });
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("Empty Optional: " + String.valueOf(emptyOptional));
        String defaultValue = (String)nullableOptional.orElse("Default Value");
        System.out.println("Nullable Optional with Default Value: " + defaultValue);
        defaultValue = (String)emptyOptional.orElseGet(() -> {
            return "Default Value from Supplier";
        });
        System.out.println("Empty Optional with Default Value: " + defaultValue);

        try {
            String var8 = (String)emptyOptional.orElseThrow(() -> {
                return new IllegalArgumentException("Value is not present");
            });
        } catch (IllegalArgumentException var7) {
            IllegalArgumentException e = var7;
            System.out.println("Exception: " + e.getMessage());
        }

    }

    public String getNullableValue() {
        return null;
    }
}