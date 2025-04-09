package com.manish.IO.SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;

public class ObjectInputStreamExample {
    public ObjectInputStreamExample() {
    }

    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("names.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            List<String> names = (List)objectIn.readObject();
            objectIn.close();
            System.out.println("Deserialized List of Names:");
            Iterator var4 = names.iterator();

            while(var4.hasNext()) {
                String name = (String)var4.next();
                System.out.println(name);
            }
        } catch (IOException var6) {
            IOException e = var6;
            e.printStackTrace();
        } catch (ClassNotFoundException var7) {
            ClassNotFoundException e = var7;
            e.printStackTrace();
        }

    }
}
