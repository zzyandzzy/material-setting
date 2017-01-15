package com.zzy.materalsetting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import com.zzy.materialsettinglibrary.model.MaterialSettingActionItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingCard;
import com.zzy.materialsettinglibrary.model.MaterialSettingCompoundButtonItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingItem;
import com.zzy.materialsettinglibrary.model.MaterialSettingList;
import com.zzy.materialsettinglibrary.model.MaterialSettingTitleItem;
import com.zzy.materialsettinglibrary.ui.MaterialSettingActivity;

/**
 * Created by zzyandzzy on 2017/1/13.
 */

public class MainActivity extends MaterialSettingActivity {
    MaterialSettingCard.Builder settingCardBuilder,authorCardBuilder,buttonCardBuilder;
    MaterialSettingActionItem materialSettingActionItem;
    @Override
    protected MaterialSettingList getMaterialSettingList(Context context) {
        authorCardBuilder = new MaterialSettingCard.Builder()
                .addItem(new MaterialSettingTitleItem.Builder()
                        .text(R.string.app_name)
                        .icon(R.mipmap.ic_launcher_red)
                        .build());
        authorCardBuilder.addItem(new MaterialSettingActionItem.Builder()
                .text("作者")
                .subText("zzyandzzy")
                .setOnClickListener(new MaterialSettingActionItem.OnClickListener() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://github.com/zzyandzzy/materialsetting"));
                        startActivity(intent);
                    }
                }).build());
        try {
            authorCardBuilder.addItem(new MaterialSettingActionItem.Builder()
                    .text("版本")
                    .subText(context.getPackageManager().getPackageInfo(context.getPackageName(),0).versionName)
                    .build());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        settingCardBuilder = new MaterialSettingCard.Builder();
        settingCardBuilder.title("设置");
        materialSettingActionItem = new MaterialSettingActionItem.Builder()
                .text("标题")
                .subText("可点击的item")
                .icon(R.mipmap.ic_launcher)
                .setOnClickListener(new MaterialSettingActionItem.OnClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"你点击了:"+ materialSettingActionItem.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).build();
        settingCardBuilder.addItem(materialSettingActionItem);
        settingCardBuilder.addItem(new MaterialSettingActionItem.Builder().text("标题").build());
        settingCardBuilder.addItem(new MaterialSettingActionItem.Builder().subText("副标题").build());
        settingCardBuilder.addItem(new MaterialSettingActionItem.Builder().icon(R.mipmap.ic_launcher).build());
        settingCardBuilder.addItem(new MaterialSettingActionItem.Builder()
                .text("标题")
                .icon(R.mipmap.ic_launcher).build());

        buttonCardBuilder = new MaterialSettingCard.Builder();
        buttonCardBuilder.title("按钮");
        buttonCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.CHECKBOX_ITEM)
                .key("checkbox1")
                .defValue(false)
                .defText("标题")
                .subDefText("副标题")
                .changeOnText("改变标题开")
                .changeOffText("改变标题关")
                .changeOnSubText("改变子标题开")
                .changeOffSubText("改变子标题关")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key,boolean isChanged) {
                        Toast.makeText(MainActivity.this,key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        buttonCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.CHECKBOX_ITEM)
                .key("checkbox2")
                .defValue(true)
                .defText("标题")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key,boolean isChanged) {
                        Toast.makeText(MainActivity.this,key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        buttonCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .key("checkbox3")
                .defValue(true)
                .subDefText("副标题")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key,boolean isChanged) {
                        Toast.makeText(MainActivity.this,key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        buttonCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.SWITCH_ITEM)
                .key("switch1")
                .defValue(false)
                .defText("标题")
                .subDefText("副标题")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key,boolean isChanged) {
                        Toast.makeText(MainActivity.this,key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        buttonCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.SWITCH_ITEM)
                .key("switch2")
                .defValue(true)
                .defText("标题")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key,boolean isChanged) {
                        Toast.makeText(MainActivity.this,key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        buttonCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.SWITCH_ITEM)
                .key("switch3")
                .defValue(true)
                .subDefText("副标题")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key,boolean isChanged) {
                        Toast.makeText(MainActivity.this,key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        buttonCardBuilder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.RADIOBUTTON_ITEM)
                .key("radiobutton1")
                .defValue(false)
                .defText("标题")
                .subDefText("副标题")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key,boolean isChanged) {
                        Toast.makeText(MainActivity.this,key + "按钮状态:"+ isChanged,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .build());
        return new MaterialSettingList(authorCardBuilder.build(),settingCardBuilder.build(),buttonCardBuilder.build());
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.app_name);
    }
}
