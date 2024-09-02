package com.manish.OOP.OOD.DesignPattern.Builder.Database;

public class Database {
    private String name;
    private String userName;
    private String password;
    private Integer port;
    private DatabaseType type;
    private Boolean isCompressed;

    private Database(){}
    //Trick 1 - Builder method i.e static initializer that creates builder for us
    public static Builder builder(){
        return new Builder();
    }

    //Step 1 -> Create a static INNER CLASS
    public static class Builder{
        //Step 2-> Copy all the fields from Outer class
        private String name;
        private String userName;
        private String password;
        private Integer port;
        private DatabaseType type;
        private Boolean isCompressed;

        //Step 3 -> Create Setters for the builder class
        //Fluent interfaces

//        public void setName(String name) {
//            this.name = name;
//        }
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }

//        public void setUserName(String userName) {
//            this.userName = userName;
//        }
//        public Builder withCredential(String userName) {
//            this.userName = userName;
        //    return this;
//        }
        public Builder withCredential(String userName, String password) {
            this.userName = userName;
            this.password = password;
            return this;
        }

//        public void setPassword(String password) {
//            this.password = password;
//        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder port(Integer port) {
            this.port = port;
            return this;
        }

        public Builder type(DatabaseType type) {
            this.type = type;
            return this;
        }

//        public Builder setCompressed(Boolean compressed) {
//            isCompressed = compressed;
//            return this;
//        }
        public Builder compressed() {
            isCompressed = true;
            return this;
        }

        //For type implementation
        public Builder mysql(){
            this.type = DatabaseType.MYSQL;
            return this;
        }

        // Step 4 - Create a build method to return the outer class object
        public Database build(){
            //Step 5 -> Global Validation
            //Build method is called when all the data has been send their will be no more data after build
            boolean isValid = validate();
            if(!isValid){
                throw new IllegalArgumentException("Wrong Port");
            }

            Database database = new Database();

            database.name = name;
            database.userName = userName;
            database.password = password;
            database.isCompressed = isCompressed;
            database.type = type;
            database.port = port;

            return database;
        }

        private boolean validate(){
            if( type == DatabaseType.MYSQL && port != 3306) {
                //throw new IllegalArgumentException("Wrong Port");
                return false;
            }
            return true;
        }
    }
}
/*
The builder class is mutable , but tha database class is immutable
* */
