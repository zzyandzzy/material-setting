# material-setting-library

[![Release][101]][102]
[![Apache License 2.0][103]][104]

项目来源（比原来的多加了一些控件和增加启动速度，在item很多的情况下）: [material-about-library][2]

[_English Document_][105]

截图
--------

| 截图 | 截图 |
|:-:|:-:|:-:|:-:|
| ![Screenshot 1][3] | ![Screenshot 1][4] |

特点
--------

* Material design
* Modular backend
* Easy to implement
* Simple but intuitive API

Dependency
----------

*material-setting-library* is available on [**jitpack.io**][1]

**Gradle dependency:**
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
```gradle
dependencies {
    compile 'com.github.zzyandzzy:materialsetting:0.1'
}
```

Setup
-----


### Activity

在你的 `Activity` 里继承 [`MaterialSettingActivity`][materialsettingactivityjava] 和修改*style.xml*:
```java
public class MainActivity extends MaterialSettingActivity {
    private MaterialSettingCard materialSettingCard;
    private MaterialSettingCard.Builder builder;

    @Override
    protected MaterialSettingList getMaterialSettingList(Context context) {
        builder = new MaterialSettingCard.Builder()
                .title("title");
        materialSettingCard = builder.build();
        builder.addItem(new MaterialSettingTitleItem.Builder()
                .text(R.string.app_name)
                .icon(R.mipmap.ic_launcher)
                .build());
        return new MaterialSettingList(materialSettingCard);
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.app_name);
    }

}
```

修改style.xml 继承 'Theme.AppCompat.Light.NoActionBar'
```xml
    <!-- Base application theme. -->
        <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
            <!-- Customize your theme here. -->
            <item name="colorPrimary">@color/colorPrimary</item>
            <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
            <item name="colorAccent">@color/colorAccent</item>
        </style>
```

### Add Cards:

构建卡片 [`MaterialSettingCard.Builder()`][5]
```java
public class MainActivity extends MaterialSettingActivity {
    private MaterialSettingCard.Builder builder;

    @Override
    protected MaterialSettingList getMaterialSettingList(Context context) {
        builder = new MaterialSettingCard.Builder()
                        .title("title");
    }
}
```

或者这样

```java
public class MainActivity extends MaterialSettingActivity {
    private MaterialSettingCard.Builder builder;

    @Override
    protected MaterialSettingList getMaterialSettingList(Context context) {
        builder = new MaterialSettingCard.Builder();
        builder.title("title");
    }
}
```
### Add Items:

 item有3种，[`MaterialSteeingTitleItem`][6] 和 [`MaterialSettingActionItem`][7] 和 [`MaterialSettingCompoundButtonItem`][8].

- `MaterialSettingActionItem`: 适用于大标题大图标.
- `MaterialSteeingTitleItem`: 适用于小标题子标题小图标.
- `MaterialSettingCompoundButtonItem`: 适用于各种选择按钮.

[`MaterialSteeingTitleItem`][6] 是用 [`MaterialSteeingTitleItem.Builder()`][6] 创建的，有这几个重要的参数 **text:标题** 和 **icon:图标**.
```java
        builder.addItem(new MaterialSettingTitleItem.Builder()
                .text(R.string.app_name)
                .icon(R.mipmap.ic_launcher)
                .build());
```
[`MaterialSettingActionItem`][7] 是用 [`MaterialSettingActionItem.Builder()`][7] 创建的，有这几个重要的参数 **text:标题**, **sub-text:子标题**, 和 **icon：图标** 和 **OnClickListener**.
```java
        builder.addItem(new MaterialSettingActionItem.Builder()
                .text(R.string.app_name)
                .subText(R.string.mal_title)
                .icon(R.mipmap.ic_launcher)
                .setOnClickListener(new MaterialSettingActionItem.OnClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
                    }
                }).build());
```
[`MaterialSettingCompoundButtonItem`][8] 是用 [`MaterialSettingCompoundButtonItem.Builder()`][8] 创建的，有这几个重要的参数
**defText:默认标题**, **defSubText:默认子标题**,**changeOnText:当按钮按下状态是打开时候的标题**, **changeOnSubText:当按钮按下状态是打开时候的子标题**,**changeOffText:当按钮按下状态是关闭时候的标题**, **changeOffSubText:当按钮按下状态是关闭时候的子标题**, 和 **CompoundButton:按钮** 和 **OnClickListener**.

按钮类型，默认CHECKBOX_ITEM
**ItemType**:

`CHECKBOX_ITEM`

![CheckBox][10]

`SWITCH_ITEM`

![CheckBox][11]

`SWITCH_RADIOBUTTON_ITEM`

![RADIOBUTTON][12]

这里注意RADIOBUTTON一旦选择就不能够改变了，即使你重新打开app!
```java
        builder.addItem(new MaterialSettingCompoundButtonItem.Builder()
                .setItemType(MaterialSettingItem.ItemType.CHECKBOX_ITEM)
                .key("title")
                .defValue(false)
                .defText("text")
                .defSubText("subText")
                .changeOnText("changeOnText")
                .changeOnSubText("changeOnSubText")
                .changeOffText("changeOffText")
                .changeOffSubText("changeOffSubText")
                .setOnCheckedChangeListener(new MaterialSettingCompoundButtonItem.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(String key, boolean isCheck) {
                        Toast.makeText(MainActivity.this,"change :" + isCheck,Toast.LENGTH_SHORT).show();
                    }
                }).build());
```

### Return the list:
[`MaterialSettingList`][9] 是用 [`MaterialSettingList.Builder()`][9]创建的, 它控制你的卡片的显示.
```java
        return new MaterialSettingList.Builder()
                        .addCard(builder.build())
                        .build();
```
例子 [`MainActivity.java`][13].

**提示:** 你可以用 *Strings* / *Drawables* or *Resources* 来set `MaterialSettingItem`

**提升:** Use [Android-Iconics][iconics] for icons. "Android-Iconics - Use any icon font, or vector (.svg) as drawable in your application."

**提示:** 如果你用了 MaterialSettingCompoundButtonItem,你必须使用 OnCheckedChangeListener,这样当用户改变了按钮的状态时，app在下一次启动能够记住按钮的状态

贡献者
-------
* Daniel Stone ([@daniel-stoneuk](https://github.com/daniel-stoneuk))
* zzyandzzy ([@zzyandzzy](https://github.com/zzyandzzy))

开源许可证
-------

    Copyright 2016 zzyandzzy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: https://jitpack.io
[2]: https://github.com/daniel-stoneuk/material-about-library
[3]: https://github.com/zzyandzzy/materialsetting/raw/master/app/1.png
[4]: https://github.com/zzyandzzy/materialsetting/raw/master/app/2.png
[5]: https://github.com/zzyandzzy/materialsetting/blob/master/library/src/main/java/com/zzy/materialsettinglibrary/model/MaterialSettingCard.java
[6]: https://github.com/zzyandzzy/materialsetting/blob/master/library/src/main/java/com/zzy/materialsettinglibrary/model/MaterialSettingTitleItem.java
[7]: https://github.com/zzyandzzy/materialsetting/blob/master/library/src/main/java/com/zzy/materialsettinglibrary/model/MaterialSettingActionItem.java
[8]: https://github.com/zzyandzzy/materialsetting/blob/master/library/src/main/java/com/zzy/materialsettinglibrary/model/MaterialSettingCompoundButtonItem.java
[9]: https://github.com/zzyandzzy/materialsetting/blob/master/library/src/main/java/com/zzy/materialsettinglibrary/model/MaterialSettingList.java
[10]: https://github.com/zzyandzzy/materialsetting/raw/master/app/3.png
[11]: https://github.com/zzyandzzy/materialsetting/raw/master/app/4.png
[12]: https://github.com/zzyandzzy/materialsetting/raw/master/app/5.png
[13]: https://github.com/zzyandzzy/materialsetting/blob/master/app/src/main/java/com/zzy/materalsetting/MainActivity.java
[101]: https://jitpack.io/v/zzyandzzy/materialsetting.svg
[102]: https://jitpack.io/#zzyandzzy/materialsetting
[103]: https://img.shields.io/github/license/HeinrichReimer/material-intro.svg
[104]: https://www.apache.org/licenses/LICENSE-2.0.html
[105]: https://github.com/zzyandzzy/materialsetting/README.md

[materialsettingactivityjava]: https://github.com/zzyandzzy/materialsetting/blob/master/library/src/main/java/com/zzy/materialsettinglibrary/ui/MaterialSettingActivity.java
[iconics]: https://github.com/mikepenz/Android-Iconics