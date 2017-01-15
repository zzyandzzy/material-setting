# material-setting-library

[![Release][101]][102]
[![Apache License 2.0][103]][104]

This project inspiration from: [material-about-library][2]

Thanks!

Screenshots
--------

| App Screenshots | App Screenshots |
|:-:|:-:|:-:|:-:|
| ![Screenshot 1][3] | ![Screenshot 1][4] |

Features
--------

* Material design
* Modular backend
* Easy to implement
* Simple but intuitive API

Dependency
----------

*material-about-library* is available on [**jitpack.io**][1]

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

Your `Activity` must extend [`MaterialSettingActivity`][materialsettingactivityjava] and be in your *AndroidManifest.xml*:
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

Ensure that the theme extends 'Theme.AppCompat.Light.NoActionBar', and apply primary & accent colours.
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

Start building a "card" using [`MaterialSettingCard.Builder()`][5]
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

or

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

There are currently two types of item you can add to a card - [`MaterialSteeingTitleItem`][6] and [`MaterialSettingActionItem`][7] and [`MaterialSettingCompoundButtonItem`][8].
Planned items include "person" items which feature buttons to showcase a single person. Feel free to submit a PR or Issue for more item ideas.

- `MaterialSettingActionItem`: Standard item with text, icon and optional subtext.
- `MaterialSteeingTitleItem`: Larger item with large icon (eg app icon) and larger text.
- `MaterialSettingCompoundButtonItem`: CheckBox Switch and RadioButton.

[`MaterialSteeingTitleItem`][6] is created with [`MaterialSteeingTitleItem.Builder()`][6] and lets you specify **text** and an **icon**.
```java
        builder.addItem(new MaterialSettingTitleItem.Builder()
                .text(R.string.app_name)
                .icon(R.mipmap.ic_launcher)
                .build());
```
[`MaterialSettingActionItem`][7] is created with [`MaterialSettingActionItem.Builder()`][7] and lets you specify **text**, **sub-text**, an **icon** and an **OnClickListener**.
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
[`MaterialSettingCompoundButtonItem`][8] is created with [`MaterialSettingCompoundButtonItem.Builder()`][8] and lets you specify
**defText**, **defSubText**,**changeOnText**, **changeOnSubText**,**changeOffText**, **changeOffSubText**, an **CompoundButton** and an **OnClickListener**.

**ItemType**:

`CHECKBOX_ITEM`
![CheckBox][10]

`SWITCH_ITEM`
![CheckBox][11]

`SWITCH_RADIOBUTTON_ITEM`
![RADIOBUTTON][12]

be careful,RadioButton once the selected cannot be canceled!
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
                    public void onCheckedChanged(String key, boolean isChech) {
                        Toast.makeText(MainActivity.this,"change :" + isChech,Toast.LENGTH_SHORT).show();
                    }
                }).build());
```

### Return the list:
Create a [`MaterialAboutList`][9] using [`MaterialAboutList.Builder()`][9], passing in the cards you would like to display.
```java
        return new MaterialSettingList.Builder()
                        .addCard(builder.build())
                        .build();
```
Check out a working example in [`MainActivity.java`][13].
**Tip:** You can either use *Strings* / *Drawables* or *Resources* when creating `MaterialAboutItem`'s

**Tip:** Use [Android-Iconics][iconics] for icons. "Android-Iconics - Use any icon font, or vector (.svg) as drawable in your application."

**Tip:** If you use MaterialSettingCompoundButtonItem,you need OnCheckedChangeListener,even if you don't use it

Contributors
-------
* Daniel Stone ([@daniel-stoneuk](https://github.com/daniel-stoneuk))
* zzyandzzy ([@zzyandzzy](https://github.com/zzyandzzy))

License
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
[101]: https://jitpack.io/v/daniel-stoneuk/material-about-library.svg
[102]: https://jitpack.io/#daniel-stoneuk/material-about-library
[103]: https://img.shields.io/github/license/HeinrichReimer/material-intro.svg
[104]: https://www.apache.org/licenses/LICENSE-2.0.html

[materialsettingactivityjava]: https://github.com/zzyandzzy/materialsetting/blob/master/library/src/main/java/com/zzy/materialsettinglibrary/ui/MaterialSettingActivity.java