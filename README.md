# OptionFrame

一款Android弹出框、对话框、Dialog、popuwindow
---

# Example

<image src="https://github.com/q805699513/OptionFrame/blob/master/image/yi.gif?raw=true" width="350px"/>  <image src="https://github.com/q805699513/OptionFrame/blob/master/image/er.png?raw=true" width="350px"/>  

<image src="https://github.com/q805699513/OptionFrame/blob/master/image/san.png?raw=true" width="350px"/>  <image src="https://github.com/q805699513/OptionFrame/blob/master/image/si.png?raw=true" width="350px"/>

 <image src="https://github.com/q805699513/OptionFrame/blob/master/image/wu.png?raw=true" width="350px"/>
---

# Usage

### Gradle

```groovy
dependencies {

  compile 'com.longsh:OptionFrame:1.0.0'
  
}
```

### 仿QQ底部弹出窗口
```java
    List<String> stringList = new ArrayList<String>();
    stringList.add("拍照");
    stringList.add("从相册选择");

    final OptionBottomDialog optionBottomDialog = new OptionBottomDialog(MainActivity.this, stringList);
    optionBottomDialog.setItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         optionBottomDialog.dismiss();
    }
    });
    
```

### 仿微信中间弹出框
```java
    final ArrayList<String> list = new ArrayList<>();
    list.add("标为已读");
    list.add("置顶聊天");
    list.add("删除该聊天");
    final OptionCenterDialog optionCenterDialog = new OptionCenterDialog();
    optionCenterDialog.show(MainActivity.this, list);
    optionCenterDialog.setItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            optionCenterDialog.dismiss();
        }
    });
```

###  Material Design风格对话框
```java
    final OptionMaterialDialog mMaterialDialog = new OptionMaterialDialog(MainActivity.this);
    mMaterialDialog.setTitle("这是标题")
//                .setTitleTextColor(R.color.colorPrimary)
//                .setTitleTextSize((float) 22.5)
            .setMessage("支持所有布局文字大小颜色等设置。")
//                .setMessageTextColor(R.color.colorPrimary)
//                .setMessageTextSize((float) 16.5)
//                .setPositiveButtonTextColor(R.color.colorAccent)
//                .setNegativeButtonTextColor(R.color.colorPrimary)
//                .setPositiveButtonTextSize(15)
//                .setNegativeButtonTextSize(15)
            .setPositiveButton("确定", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMaterialDialog.dismiss();
                }
            })
            .setNegativeButton("取消",
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mMaterialDialog.dismiss();
                        }
                    })
            .setCanceledOnTouchOutside(true)
            .setOnDismissListener(
                    new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                        //对话框消失后回调
                        }
                    })
            .show();
```


### Version: 1.0.0

  有其他弹出窗的需求可以给我提Issues
  
## License
```text

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



