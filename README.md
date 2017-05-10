## 功能介绍
- 项目为图片加载的demo 包括图片加载 颜色提取并更改主题


## 实现效果

![图片](https://github.com/ryanliu19843/XImageView/blob/master/20170510149438820559128dedafd29.gif)




## 实现代码
### 设置加载接口

```Java
ApiUpdateApi api=new ApiUpdateApi().set("sss",1,"ios","sss","0","");
mMFRecyclerView.setOnSwipLoadListener(new OnPageSwipListener(getContext(), api, new DfText()));
mMFRecyclerView.reload();
```
- -- ApiUpdateApi 为根据接口定义自动生成的接口请求类，set方法为接口设置参数
- -- mMFRecyclerView 为本项目中的MFRecyclerview

### 实现数据整理类

```Java
public class DfSimple extends DataFormat{
    int size = 1;

	Simple.SimpleSet simpleSets[] = new Simple.SimpleSet[]{
			new Simple.SimpleSet("ASSETS:tylt_bg_youdoushi_n.png", "ASSETS:tylt_ic_youdoushi_n.png", "魔兽世界1", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_moshou_n.png", "ASSETS:tylt_ic_moshou_n.png", "魔兽世界2", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_zhanzheng_n.png", "ASSETS:tylt_ic_zhenzheng_n.png", "魔兽世界3", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_yingxiong_n.png", "ASSETS:tylt_ic_yingxiong_n.png", "魔兽世界4", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_yongheng_n.png", "ASSETS:tylt_ic_yongheng_n.png", "魔兽世界5", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_guaiwu_n.png", "ASSETS:tylt_ic_guaiwu_n.png", "魔兽世界6", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_youdoushi_n.png", "ASSETS:tylt_ic_youdoushi_n.png", "魔兽世界7", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_moshou_n.png", "ASSETS:tylt_ic_moshou_n.png", "魔兽世界8", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_zhanzheng_n.png", "ASSETS:tylt_ic_zhenzheng_n.png", "魔兽世界9", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_yingxiong_n.png", "ASSETS:tylt_ic_yingxiong_n.png", "魔兽世界10", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_yongheng_n.png", "ASSETS:tylt_ic_yongheng_n.png", "魔兽世界11", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_guaiwu_n.png", "ASSETS:tylt_ic_guaiwu_n.png", "魔兽世界12", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_youdoushi_n.png", "ASSETS:tylt_ic_youdoushi_n.png", "魔兽世界13", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_moshou_n.png", "ASSETS:tylt_ic_moshou_n.png", "魔兽世界14", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_zhanzheng_n.png", "ASSETS:tylt_ic_zhenzheng_n.png", "魔兽世界15", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_yingxiong_n.png", "ASSETS:tylt_ic_yingxiong_n.png", "魔兽世界16", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_yongheng_n.png", "ASSETS:tylt_ic_yongheng_n.png", "魔兽世界17", "110", "220"),
			new Simple.SimpleSet("ASSETS:tylt_bg_guaiwu_n.png", "ASSETS:tylt_ic_guaiwu_n.png", "魔兽世界18", "110", "220"),
	};


	@Override
	public boolean hasNext() {  //判断是否有下一页
		return size >= Integer.MAX_VALUE;
	}

 public CardAdapter getCardAdapter(Context context, Son son, int page) {  //数据整理
     List<Card> list = new ArrayList<>();
		int ind=Math.abs(new Random().nextInt())%5;
		for(int i=ind;i<simpleSets.length;i++){   //设置card
			Simple.SimpleSet item=simpleSets[i];
			CardSimple card=new CardSimple(item);
			list.add(card);
		}
        for(Simple.SimpleSet item:simpleSets){
               CardSimple card=new CardSimple(item);
               list.add(card);
        }
        return new CardAdapter(context,list);
    }

	@Override
	public String[][] getPageNext() {
		return null;
	}

	@Override
	public void reload() {

	}
}
				
```

### 设置加载完成监听

```Java

        relalayout.setObj(item.bacground);
        relalayout.isPalette=true;   //是否需要执行颜色提取
        relalayout.setOnImageLoaded(new MImageView.OnImageLoaded() {
            @Override
            public void onImageLoaded(Object obj, Drawable drawable, MBitmap mBitmap, int size, int length) {
                overlayout.setBackgroundColor(mBitmap.muted & 0xccffffff);  //设置图片覆盖层，减缓视觉冲击
 
                if(Simple.this.card.getAdapter().params.get("size")==null && posion==0){
                    Frame.HANDLES.sentAll("ActMain", 0, aitem);  //抛出有actmain处理
                }
            }
        });

```

```Java

        relalayout.setObj(item.bacground);
        relalayout.isPalette=true;   //是否需要执行颜色提取
        relalayout.setOnImageLoaded(new MImageView.OnImageLoaded() {
            @Override
            public void onImageLoaded(Object obj, Drawable drawable, MBitmap mBitmap, int size, int length) {
                overlayout.setBackgroundColor(mBitmap.muted & 0xccffffff);  //设置图片覆盖层，减缓视觉冲击
 
                if(Simple.this.card.getAdapter().params.get("size")==null && posion==0){
                    Frame.HANDLES.sentAll("ActMain", 0, aitem);  //抛出有actmain处理
                }
            }
        });

```

- 如果项目中有任何问题请邮箱联系我 youyexianhe@126.com

