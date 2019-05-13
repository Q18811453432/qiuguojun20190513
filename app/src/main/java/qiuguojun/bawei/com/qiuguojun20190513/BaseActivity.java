package qiuguojun.bawei.com.qiuguojun20190513;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initfind();
        initdata();
        initlistener();
    }

    protected abstract int initview();


    protected abstract void initfind();
    protected abstract void initdata();
    protected abstract void initlistener();
   

    


}
