package ru.rma.androiddraganddropexample;

class ItemModel {

    private final int mType;
    private String mName;


    public ItemModel(int type, String name) {
        mType = type;
        mName = name;
    }


    public int getType() {
        return mType;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
