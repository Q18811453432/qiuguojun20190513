package qiuguojun.bawei.com.qiuguojun20190513.http;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/*
 * 作者 邱国军
 * 日期 2019 0513
 * */
public class https {
    public static https https=new https();
    private CallBack callback;

    public static https getInstance(){
        return https;
    };
    //网络请求数据
    public String gethttp(String path) throws Exception {
        URL url=new URL(path);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //设置请求方式
        urlConnection.setRequestMethod("GET");
        urlConnection.setConnectTimeout(5000);
        urlConnection.setReadTimeout(5000);
        int responseCode = urlConnection.getResponseCode();
        if (responseCode==200){
            InputStream inputStream = urlConnection.getInputStream();
            Read instance = Read.getInstance();
            String s = instance.getRead(inputStream);
            return s;
        }
        return null;
    }
    //异步
    public void getAsynTask(final String path){
        AsyncTask<String,Void,String>asyncTask=new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                String http=null;
                try {
                    http = gethttp(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return http;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callback.getJson(s);
                Log.i("TAG",s);
            }
        }.execute(path);
    }
    //接口回调
    public void setCallback(CallBack callback){
    this.callback=callback;
    }
}
