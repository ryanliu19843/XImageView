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

