package com.manish.OOD.CreationalDesign.PrototypeDesign.Document;

// Prototype Interface: This abstract class declares the method for cloning itself.
public abstract class Document implements Cloneable {  
   private String text;

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
}

