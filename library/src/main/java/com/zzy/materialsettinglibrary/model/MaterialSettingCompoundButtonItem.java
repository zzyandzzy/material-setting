package com.zzy.materialsettinglibrary.model;

import android.widget.CompoundButton;

/**
 * Created by zzyandzzy on 2017/1/13.
 */

public class MaterialSettingCompoundButtonItem extends MaterialSettingItem {
    private CharSequence defText = null;
    private int defTextRes = 0;
    private CharSequence defSubText = null;
    private int defSubTextRes = 0;
    private String key = null;
    private boolean defValue = false;
    private CharSequence changeOnText = null;
    private int changeOnTextRes = 0;
    private CharSequence changeOffText = null;
    private int changeOffTextRes = 0;
    private CharSequence changeOnSubText = null;
    private int changeOnSubTextRes = 0;
    private CharSequence changeOffSubText = null;
    private int changeOffSubTextRes = 0;
    private int itemType = ItemType.CHECKBOX_ITEM;
    private int position = ButtonPosition.RIGHT;

    public OnCheckedChangeListener getOnCheckedChangeListener() {
        return onCheckedChangeListener;
    }

    public CharSequence getChangeOnText() {
        return changeOnText;
    }

    public CharSequence getChangeOffText() {
        return changeOffText;
    }

    public int getChangeOnTextRes() {
        return changeOnTextRes;
    }

    public int getChangeOffTextRes() {
        return changeOffTextRes;
    }

    public CharSequence getChangeOnSubText() {
        return changeOnSubText;
    }

    public int getChangeOnSubTextRes() {
        return changeOnSubTextRes;
    }

    public CharSequence getChangeOffSubText() {
        return changeOffSubText;
    }

    public int getChangeOffSubTextRes() {
        return changeOffSubTextRes;
    }

    public int getPosition() {
        return position;
    }

    public interface OnCheckedChangeListener{
        void onCheckedChanged(CompoundButton buttonView,String key, boolean isChanged);
    }
    private OnCheckedChangeListener onCheckedChangeListener;

    public MaterialSettingCompoundButtonItem(Builder builder) {
        this.itemType = builder.itemType;
        this.defText = builder.defText;
        this.defTextRes = builder.defTextRes;
        this.defSubText = builder.defSubText;
        this.defSubTextRes = builder.defSubTextRes;
        this.key = builder.key;
        this.defValue = builder.defValue;
        this.changeOnText = builder.changeOnText;
        this.changeOnTextRes = builder.changeOnTextRes;
        this.changeOffText = builder.changeOffText;
        this.changeOffTextRes = builder.changeOffTextRes;
        this.changeOnSubText = builder.changeOnSubText;
        this.changeOnSubTextRes = builder.changeOnSubTextRes;
        this.changeOffSubText = builder.changeOffSubText;
        this.changeOffSubTextRes = builder.changeOffSubTextRes;
        this.position = builder.position;
        this.onCheckedChangeListener = builder.onCheckedChangeListener;
    }

    public MaterialSettingCompoundButtonItem(int itemType,int position,String key, boolean defValue,
            CharSequence defText, CharSequence defSubText,CharSequence changeOnText,
            CharSequence changeOnSubText,CharSequence changeOffText,
            CharSequence changeOffSubText ,OnCheckedChangeListener onCheckedChangeListener){
        this.itemType = itemType;
        this.position = position;
        this.defText = defText;
        this.defSubText = defSubText;
        this.key = key;
        this.defValue = defValue;
        this.changeOnText = changeOnText;
        this.changeOffSubText = changeOffSubText;
        this.changeOffText = changeOffText;
        this.changeOffSubText = changeOffSubText;
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public MaterialSettingCompoundButtonItem(int itemType,String key, CharSequence defText, CharSequence defSubText){
        this.itemType = itemType;
        this.defText = defText;
        this.defSubText = defSubText;
        this.key = key;
    }

    public MaterialSettingCompoundButtonItem(int itemType,String key, int defTextRes, int defSubTextRes){
        this.itemType = itemType;
        this.defTextRes = defTextRes;
        this.defSubTextRes = defSubTextRes;
        this.key = key;
    }

    public MaterialSettingCompoundButtonItem(
            int itemType,int position,String key, boolean defValue, int defTextRes, int defSubTextRes,
            int changeOnTextRes,int changeOnSubTextRes,int changeOffTextRes,
            int changeOffSubTextRes,OnCheckedChangeListener onCheckedChangeListener){
        this.itemType = itemType;
        this.position = position;
        this.defTextRes = defTextRes;
        this.defSubTextRes = defSubTextRes;
        this.key = key;
        this.defValue = defValue;
        this.changeOnTextRes = changeOnTextRes;
        this.changeOffTextRes = changeOffTextRes;
        this.changeOnSubTextRes = changeOnSubTextRes;
        this.changeOffSubTextRes = changeOffSubTextRes;
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

    @Override
    public int getButtonPosition() {
        if (getPosition() == ButtonPosition.LEFT)
            return ButtonPosition.LEFT;
        else if (getPosition() == ButtonPosition.RIGHT)
            return ButtonPosition.RIGHT;
        else return ButtonPosition.NULL;
    }

    public CharSequence getDefText() {
        return defText;
    }

    public int getDefTextRes() {
        return defTextRes;
    }

    public CharSequence getDefSubText() {
        return defSubText;
    }

    public int getDefSubTextRes() {
        return defSubTextRes;
    }

    public String getKey() {
        return key;
    }

    public boolean getDefValue() {
        return defValue;
    }

    public static class Builder {
        private int itemType = ItemType.CHECKBOX_ITEM;;
        private CharSequence defText = null;
        private int defTextRes = 0;
        private CharSequence defSubText = null;
        private int defSubTextRes = 0;
        private String key = null;
        private boolean defValue = false;
        private CharSequence changeOnText = null;
        private int changeOnTextRes = 0;
        private CharSequence changeOffText = null;
        private int changeOffTextRes = 0;
        private CharSequence changeOnSubText = null;
        private int changeOnSubTextRes = 0;
        private CharSequence changeOffSubText = null;
        private int changeOffSubTextRes = 0;
        private OnCheckedChangeListener onCheckedChangeListener;
        private int position = ButtonPosition.RIGHT;

        public Builder setItemType(int itemType){
            this.itemType = itemType;
            return this;
        }

        public Builder setButtonPosition(int position){
            this.position = position;
            return this;
        }

        public Builder defText(CharSequence defText){
            this.defText = defText;
            return this;
        }

        public Builder defText(int defTextRes){
            this.defTextRes = defTextRes;
            this.defText = null;
            return this;
        }

        public Builder defSubText(CharSequence defSubText){
            this.defSubText = defSubText;
            return this;
        }

        public Builder defSubText(int defSubTextRes){
            this.defSubTextRes = defSubTextRes;
            this.defSubText = null;
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

        public Builder changeOnText(CharSequence changeOnText){
            this.changeOnText = changeOnText;
            this.changeOnTextRes = 0;
            return this;
        }

        public Builder changeOnText(int changeOnTextRes){
            this.changeOnText = null;
            this.changeOnTextRes = changeOnTextRes;
            return this;
        }

        public Builder changeOnSubText(CharSequence changeOnSubText){
            this.changeOnSubText = changeOnSubText;
            this.changeOnSubTextRes = 0;
            return this;
        }

        public Builder changeOnSubText(int changeOnSubTextRes){
            this.changeOnSubTextRes = changeOnSubTextRes;
            this.changeOnSubText = null;
            return this;
        }

        public Builder changeOffText(CharSequence changeOffText){
            this.changeOffText = changeOffText;
            this.changeOffTextRes = 0;
            return this;
        }

        public Builder changeOffText(int changeOffTextRes){
            this.changeOffTextRes = changeOffTextRes;
            this.changeOffText = null;
            return this;
        }

        public Builder changeOffSubText(CharSequence changeOffSubText){
            this.changeOffSubText = changeOffSubText;
            this.changeOffSubTextRes = 0;
            return this;
        }

        public Builder changeOffSubText(int changeOffSubTextRes){
            this.changeOffSubTextRes = changeOffSubTextRes;
            this.changeOffSubText = null;
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
