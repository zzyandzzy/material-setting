package com.zzy.materalsetting;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.zzy.materialsettinglibrary.model.MaterialSettingActionItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingCard;
import com.zzy.materialsettinglibrary.model.MaterialSettingCompoundButtonItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingList;
import com.zzy.materialsettinglibrary.ui.MaterialSettingFragment;

/**
 * Created by zzyandzzy on 2017/1/17.
 */

public class MainFragment extends MaterialSettingFragment {
    MaterialSettingCard.Builder settingCardBuilder;
    MaterialSettingActionItem materialSettingActionItem;

    @Override
    protected MaterialSettingList getMaterialSettingList(Context context) {
        settingCardBuilder = new MaterialSettingCard.Builder();
        settingCardBuilder.title("设置");
        materialSettingActionItem = new MaterialSettingActionItem.Builder()
                .text("标题")
                .subText("可点击的item")
                .icon(R.mipmap.ic_launcher)
                .setOnClickListener(new MaterialSettingActionItem.OnClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(getActivity(),"你点击了:"+ materialSettingActionItem.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).build();
        settingCardBuilder.addItem(materialSettingActionItem);
        settingCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.CHECKBOX_ITEM)
                .setButtonPosition(MaterialSettingItem.ButtonPosition.LEFT)
                .key("mainFragment_CheckBox1")
                .defValue(false)
                .defText("标题")
                .defSubText("副标题")
                .changeOnText("改变标题开")
                .changeOffText("改变标题关")
                .changeOnSubText("改变子标题开")
                .changeOffSubText("改变子标题关")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, String key, boolean isChanged) {
                        Toast.makeText(getActivity(),key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        return new MaterialSettingList(settingCardBuilder.build());
    }
}
