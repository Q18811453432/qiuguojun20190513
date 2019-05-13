package qiuguojun.bawei.com.qiuguojun20190513;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import qiuguojun.bawei.com.qiuguojun20190513.bean.JsonBean;
import qiuguojun.bawei.com.qiuguojun20190513.http.CallBack;
import qiuguojun.bawei.com.qiuguojun20190513.http.https;
/*
* 作者 邱国军
* 日期 2019 0513
* */
public class MainActivity extends BaseActivity {

    private TextView title;
    private ListView listview;
    //数据路径
  private String path="https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int initview() {
        //加载布局
        return R.layout.activity_main;
    }

    @Override
    //资源id
    protected void initfind() {

        title = (TextView) findViewById(R.id.title);
        listview = (ListView) findViewById(R.id.listview);
    }
//数据解析 展示
    @Override
    protected void initdata() {
        https instance = https.getInstance();
        instance.getAsynTask(path);
         instance.setCallback(new CallBack() {
             @Override
             public void getJson(String json) {

                 Gson gson=new Gson();
                 JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
                 //解析数据
                 List<JsonBean.item> items = jsonBean.getItems();
                 //适配器
                   Mybase adapter=new Mybase(items,MainActivity.this);
                   //展示listview
                   listview.setAdapter(adapter);

             }
         });
    }
//点击事件
    @Override
    protected void initlistener() {

    }


}
