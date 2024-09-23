package com.manish.Java8.Practice.Example17;

class Notes {
    private long tagId;
    private String tagName;
    private long otherValue; // Assuming there's another value

    public Notes(long tagId, String tagName, long otherValue) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.otherValue = otherValue;
    }

    public long getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public long getOtherValue() {
        return otherValue;
    }
}