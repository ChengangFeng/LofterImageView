# LofterImageView 
一个类似Lofter图片预览的小控件

**PS:目前控件自定义项还比较少，以后渐渐完善**

---

### 效果图
![](https://github.com/ChengangFeng/LofterImageView/blob/master/AppPics/app_thumbnail.gif "LofterImageView") ![](https://github.com/ChengangFeng/LofterImageView/blob/master/AppPics/app_thumbnail_part.gif "LofterImageView")

### 简介
* 依赖![okhttp](https://github.com/square/okhttp)
* 图片加载使用![Glide](https://github.com/bumptech/glide)
* 图片加载进度使用![ProgressManager](https://github.com/JessYanCoding/ProgressManager)

### 使用
Step 1
```
allprojects {
  repositories {
    ...
    maven { url 'https://www.jitpack.io' }
  }
}
```

Step 2 
```
dependencies {
    //使用ProgressManager监听图片下载进度
    compile 'me.jessyan:progressmanager:1.3.3' 
    //依赖okhttp
    compile 'com.squareup.okhttp3:okhttp:3.8.0'
    //依赖Glide
    compile 'com.github.bumptech.glide:glide:3.8.0'
    compile 'com.github.bumptech.glide:okhttp3-integration:1.4.0@aar'
    //LofterImageView
    compile 'com.github.ChengangFeng:LofterImageView:1.0.4'
}

```

Step 3
```
public class GlideConfiguration implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //自定义设置
        ...
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        AppContext application = (AppContext) context.getApplicationContext();
        //Glide 底层默认使用 HttpConnection 进行网络请求,
        //替换为 Okhttp 后才能ProgressManager进行监听进度
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(application.getOkHttpClient()));
    }
}
```

Step 4

```
//单图预览
<chengang.library.widget.LofterImageView
    android:id="@+id/LofterImageView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
    
mLofterImageView.load(IMAGE_URL);
```

```
//多图预览
<chengang.library.widget.LofterGallery
    android:id="@+id/LofterGallery"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
    
mLofterGallery.showGallery(mutiImages, 0);
```


