package echang.pxd.contact;


import java.util.Scanner;

/**
 * @Description
 * @Author 彭孝东
 * @QQ 932056657
 */
public class MyClass {
    public static void main(String[] args){
        //创建联系人对象
        Contact contact = new Contact();

        Scanner scanner = new Scanner(System.in);

        while (true){
            //提示添加联系人
            System.out.print("输入联系人姓名:");
            String name = scanner.next();

            //将汉字姓名转化为拼音（每个汉字的首字母大写）
            String firstAlpha = Util.getFirstAlpha(name);
            System.out.println(firstAlpha);

            //创建person
            Person person = new Person(firstAlpha, name);

            //添加联系人
            contact.addPerson(person);

            //是否继续
            if (!Util.isContinue()){
                break;
            }
        }

        //显示内容
        contact.showList();
    }
}
