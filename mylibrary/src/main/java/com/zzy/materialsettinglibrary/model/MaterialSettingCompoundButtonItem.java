package com.zzy.materialsettinglibrary.model;

/**
 * Created by zzyandzzy on 2017/1/13.
 */

public class MaterialSettingCompoundButtonItem extends MaterialSettingItem {
    private CharSequence text = null;
    private int textRes = 0;
    private CharSequence subText = null;
    private int subTextRes = 0;
    private String key = null;
    private boolean defValue = false;
    private int itemType = ItemType.CHECKBOX_ITEM;

    public OnCheckedChangeListener getOnCheckedChangeListener() {
        return onCheckedChangeListener;
    }

    public interface OnCheckedChangeListener{
        void onCheckedChanged(String key,boolean isChanged);
    }
    private OnCheckedChangeListener onCheckedChangeListener;

    public MaterialSettingCompoundButtonItem(Builder builder) {
        this.itemType = builder.itemType;
        this.text = builder.text;
        this.textRes = builder.textRes;
        this.subText = builder.subText;
        this.subTextRes = builder.subTextRes;
        this.key = builder.key;
        this.defValue = builder.defValue;
        this.onCheckedChangeListener = builder.onCheckedChangeListener;
    }

    public MaterialSettingCompoundButtonItem(
            int itemType,String key, boolean defValue,
            CharSequence text, CharSequence subText, OnCheckedChangeListener onCheckedChangeListener){
        this.itemType = itemType;
        this.text = text;
        this.subText = subText;
        this.key = key;
        this.defValue = defValue;
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public MaterialSettingCompoundButtonItem(int itemType,String key, CharSequence text, CharSequence subText){
        this.itemType = itemType;
        this.text = text;
        this.subText = subText;
        this.key = key;
    }

    public MaterialSettingCompoundButtonItem(int itemType,String key, int textRes, int subTextRes){
        this.itemType = itemType;
        this.textRes = textRes;
        this.subTextRes = subTextRes;
        this.key = key;
    }

    public MaterialSettingCompoundButtonItem(
            int itemType,String key, boolean defValue, int textRes, int subTextRes,
            OnCheckedChangeListener onCheckedChangeListener){
        this.itemType = itemType;
        this.textRes = textRes;
        this.subTextRes = subTextRes;
        this.key = key;
        this.defValue = defValue;
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public int getItemType(){
        return itemType;
    }

    @Override
    public int getType() {
        if (getItemType()== ItemType.CHECKBOX_ITEM)
            return ItemType.CHECKBOX_ITEM;
        else if (getItemType() == ItemType.SWITCH_ITEM)
            return ItemType.SWITCH_ITEM;
        else if (getItemType() == ItemType.RADIOBUTTON_ITEM)
            return ItemType.RADIOBUTTON_ITEM;
        else return ItemType.CHECKBOX_ITEM;
    }

    public CharSequence getText() {
        return text;
    }

    public int getTextRes() {
        return textRes;
    }

    public CharSequence getSubText() {
        return subText;
    }

    public int getSubTextRes() {
        return subTextRes;
    }

    public String getKey() {
        return key;
    }

    public boolean getDefValue() {
        return defValue;
    }

    public static class Builder {
        private int itemType;
        private CharSequence text = null;
        private int textRes = 0;
        private CharSequence subText = null;
        private int subTextRes = 0;
        private String key = null;
        private boolean defValue = false;
        private OnCheckedChangeListener onCheckedChangeListener;

        public Builder setItemType(int itemType){
            this.itemType = itemType;
            return this;
        }

        public Builder text(CharSequence text){
            this.text = text;
            return this;
        }

        public Builder textRes(int textRes){
            this.textRes = textRes;
            return this;
        }

        public Builder subText(CharSequence subText){
            this.subText = subText;
            return this;
        }

        public Builder subTextRes(int subTextRes){
            this.subTextRes = subTextRes;
            return this;
        }

        public Builder key(String key){
            this.key = key;
            return this;
        }

        public Builder defValue(boolean defValue){
            this.defValue = defValue;
            return this;
        }

        public Builder setOnCheckedChangeListener(MaterialSettingCompoundButtonItem.OnCheckedChangeListener onCheckedChangeListener){
            this.onCheckedChangeListener = onCheckedChangeListener;
            return this;
        }

        public MaterialSettingCompoundButtonItem build(){
            return new MaterialSettingCompoundButtonItem(this);
        }
    }
}
