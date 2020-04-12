package echang.pxd.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author 彭孝东
 * @QQ 932056657
 */
public class Contact {
    ArrayList<String> titles; //保存每个栏目的标题
    Map<String, List<Person>> contacts; //保存每个栏目对应的名字和内容

    public Contact() {
        //初始化数组
        titles = new ArrayList<>();
        contacts = new HashMap<>();
    }

    //显示所有联系人信息
    public void showList(){
        for (String title: titles){
            //打印这个栏目的标题：W
            System.out.println(title);
            //输出这个栏目对应的所有人信息
            //获取这个title对应的联系人列表
            List<Person> lists = contacts.get(title);
            for (Person p : lists){
                System.out.println(p.name);
            }
        }
    }

    public void addPerson(Person person){
        //获取person对应的首字母
        String title = person.firstAlphaString.substring(0,1);
        //判断当前栏目中是否有这个person对应的首字母
        if (titles.contains(title)){
            //已经有这个栏目
            //获取栏目对应的列表
            List<Person> lists = contacts.get(title);

            //添加到数组中
            lists.add(person);

            //对数组进行排序
            Collections.sort(lists);
        }else{
            //没有这个栏目
            //在标题数组中添加这个栏目
            titles.add(title);

            //对标题数组进行排序
            Collections.sort(titles);

            //添加键值对
            List<Person> lists = new ArrayList<>();
            lists.add(person);
            contacts.put(title,lists);
        }
    }
}
