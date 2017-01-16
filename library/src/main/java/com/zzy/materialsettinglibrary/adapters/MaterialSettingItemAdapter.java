package com.zzy.materialsettinglibrary.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.zzy.materialsettinglibrary.R;
import com.zzy.materialsettinglibrary.model.MaterialSettingActionItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingCompoundButtonItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingTitleItem;
import com.zzy.materialsettinglibrary.utils.MaterialSettingSharedPreferences;

import java.util.ArrayList;

/**
 * Created by zzyandzzy on 2017/1/14.
 */

public class MaterialSettingItemAdapter extends
        RecyclerView.Adapter<MaterialSettingItemViewHolder>{
    private ArrayList<MaterialSettingItem> data;
    private Context context;
    private MaterialSettingSharedPreferences sharedPreferences;
    public MaterialSettingItemAdapter(ArrayList<MaterialSettingItem> data){
        this.data = data;
    }

    @Override
    public MaterialSettingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        sharedPreferences = new MaterialSettingSharedPreferences(context);
        if (!(parent instanceof RecyclerView)){
            throw new RuntimeException("Not bound to RecyclerView");
        }
        int layoutId = -1;
        switch (viewType){
            case MaterialSettingItem.ItemType.ACTION_ITEM:
                layoutId = R.layout.mal_material_setting_action_item;
                break;
            case MaterialSettingItem.ItemType.TITLE_ITEM:
                layoutId = R.layout.mal_material_setting_title_item;
                break;
            case MaterialSettingItem.ItemType.CHECKBOX_ITEM:
                layoutId = R.layout.mal_material_setting_checkbox_item;
                break;
            case MaterialSettingItem.ItemType.SWITCH_ITEM:
                layoutId = R.layout.mal_material_setting_switch_item;
                break;
            case MaterialSettingItem.ItemType.RADIOBUTTON_ITEM:
                layoutId = R.layout.mal_material_setting_radiobutton_item;
                break;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId,parent,false);
        view.setFocusable(true);
        return new MaterialSettingItemViewHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(MaterialSettingItemViewHolder holder, int position) {
        switch (holder.viewType){
            case MaterialSettingItem.ItemType.ACTION_ITEM:
                setupActionItem(holder,position);
                break;
            case MaterialSettingItem.ItemType.TITLE_ITEM:
                setupTitleItem(holder,position);
                break;
            case MaterialSettingItem.ItemType.CHECKBOX_ITEM:
                setupCompoundButtonItem(holder,position,holder.checkBox);
                break;
            case MaterialSettingItem.ItemType.SWITCH_ITEM:
                setupCompoundButtonItem(holder,position,holder.aSwitch);
                break;
            case MaterialSettingItem.ItemType.RADIOBUTTON_ITEM:
                setupCompoundButtonItem(holder,position,holder.radioButton);
        }
    }

    private void setupCompoundButtonItem(final MaterialSettingItemViewHolder holder,
                                         int position, final CompoundButton compoundButton) {
        final MaterialSettingCompoundButtonItem item =
                (MaterialSettingCompoundButtonItem) data.get(position);
        CharSequence text = item.getDefText();
        int textRes = item.getDefTextRes();
        CharSequence subText = item.getDefSubText();
        int subTextRes = item.getDefSubTextRes();
        holder.setText(holder.text,holder.subText,null,text,textRes,subText,subTextRes,null,0);
        boolean defValue = item.getDefValue();
        String key = item.getKey();
        if (key == null)
            key = context.getString(R.string.app_name);
        boolean isChecked = sharedPreferences.getBoolean(key,defValue);
        compoundButton.setChecked(isChecked);
        holder.setButtonText(holder,item,isChecked);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground,typedValue,true);
        holder.view.setBackgroundResource(typedValue.resourceId);
        if (item.getOnCheckedChangeListener() != null){
            holder.onCheckedChangeListener = item.getOnCheckedChangeListener();
        }else {
            holder.onCheckedChangeListener = item.getOnCheckedChangeListener();
            holder.onCheckedChangeListener = null;
        }
        final String finalKey = key;
        compoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.setSettingSharedPreferences(item,isChecked);
                holder.setButtonText(holder,item,isChecked);
                if (holder.onCheckedChangeListener != null) {
                    Log.d("TAG","CompoundButton:" + finalKey);
                    holder.onCheckedChangeListener.onCheckedChanged(compoundButton,finalKey,isChecked);
                }
            }
        });
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compoundButton.setChecked(!compoundButton.isChecked());
                holder.setSettingSharedPreferences(item,compoundButton.isChecked());
                holder.setButtonText(holder,item, compoundButton.isChecked());
            }
        });
    }

    private void setupActionItem(MaterialSettingItemViewHolder holder, int position) {
        MaterialSettingActionItem item = (MaterialSettingActionItem) data.get(position);
        CharSequence text = item.getText();
        int textRes = item.getTextRes();
        CharSequence subText = item.getSubText();
        int subTextRes = item.getSubTextRes();
        holder.icon.setVisibility(View.VISIBLE);
        Drawable drawable = item.getIcon();
        int drawableRes = item.getIconRes();
        holder.setText(holder.text,holder.subText,holder.icon,
                text,textRes,subText,subTextRes,drawable,drawableRes);
        int paddingLeft = 0,paddingRight = 0,paddingTop = 0,paddingBottom = 0;
        if (Build.VERSION.SDK_INT < 21){
            paddingLeft = holder.view.getPaddingLeft();
            paddingRight = holder.view.getPaddingRight();
            paddingTop = holder.view.getPaddingTop();
            paddingBottom = holder.view.getPaddingBottom();
        }
        if (item.getOnClickListener() != null){
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground,typedValue,true);
            holder.view.setBackgroundResource(typedValue.resourceId);
            holder.onClickListener = item.getOnClickListener();
        }else {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground,typedValue,false);
            holder.view.setBackgroundResource(typedValue.resourceId);
            holder.onClickListener = item.getOnClickListener();
            holder.onClickListener = null;
        }

        if (Build.VERSION.SDK_INT < 21)
            holder.view.setPadding(paddingLeft,paddingTop,paddingRight,paddingBottom);
    }

    private void setupTitleItem(MaterialSettingItemViewHolder holder,int position){
        MaterialSettingTitleItem item = (MaterialSettingTitleItem) data.get(position);
        CharSequence text = item.getText();
        int textRes = item.getTextRes();
        Drawable drawable = item.getIcon();
        int drawableRes = item.getIconRes();
        holder.setText(holder.text,null,holder.icon,text,textRes,null,0,drawable,drawableRes);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }

    public int getItemType(int position){
        return data.get(position).getType();
    }

    public void swapData(ArrayList<MaterialSettingItem> newData){
        data = newData;
        notifyDataSetChanged();
    }

    public ArrayList<MaterialSettingItem> getData(){
        return data;
    }

}
