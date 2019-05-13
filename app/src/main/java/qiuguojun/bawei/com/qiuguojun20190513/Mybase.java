package qiuguojun.bawei.com.qiuguojun20190513;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.ls.LSException;

import java.util.List;

import qiuguojun.bawei.com.qiuguojun20190513.bean.JsonBean;

public class Mybase extends BaseAdapter{
    private List<JsonBean.item> list;
    private Context context;

    public Mybase(List<JsonBean.item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                ViewHolder holder;
                if (convertView==null){
                    convertView=View.inflate(context,R.layout.mybase,null);
                    holder=new ViewHolder();
                    holder.t_desc=convertView.findViewById(R.id.desc);
                    holder.t_title=convertView.findViewById(R.id.title);
                    holder.t_image=convertView.findViewById(R.id.image);
                    convertView.setTag(holder);
                }else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.t_title.setText(list.get(position).getTitle());
                holder.t_desc.setText(list.get(position).getDesc());
                Glide.with(context).load(list.get(position).getImage()).into(holder.t_image);
                break;
            case 1:
                ViewHolders holders;
                if (convertView==null){
                    convertView=View.inflate(context,R.layout.mybases,null);
                    holders=new ViewHolders();
                    holders.t_descs=convertView.findViewById(R.id.descs);
                    holders.t_titles=convertView.findViewById(R.id.titles);
                    holders.t_images=convertView.findViewById(R.id.images);
                    convertView.setTag(holders);
                }else {
                    holders = (ViewHolders) convertView.getTag();
                }
                holders.t_titles.setText(list.get(position).getTitle());
                holders.t_descs.setText(list.get(position).getDesc());
                Glide.with(context).load(list.get(position).getImage()).into(holders.t_images);
                break;
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    class ViewHolder{
        TextView t_desc,t_title;
        ImageView t_image;
    }
    class ViewHolders{
        TextView t_descs,t_titles;
        ImageView t_images;
    }
}
