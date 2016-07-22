package ru.rma.androiddraganddropexample;

class ItemModel {

    private int mType;
    private String mName;


    public ItemModel(int type, String name) {
        mType = type;
        mName = name;
    }


    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
