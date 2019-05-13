package qiuguojun.bawei.com.qiuguojun20190513.bean;

import java.util.List;

public class JsonBean {
   public List<item> items;

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }

    public class item{
       private String desc;
       private String title;
       private String image;

      public String getDesc() {
          return desc;
      }

      public void setDesc(String desc) {
          this.desc = desc;
      }

      public String getTitle() {
          return title;
      }

      public void setTitle(String title) {
          this.title = title;
      }

      public String getImage() {
          return image;
      }

      public void setImage(String image) {
          this.image = image;
      }
  }
}
