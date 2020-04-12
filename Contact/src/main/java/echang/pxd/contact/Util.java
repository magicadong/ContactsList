package echang.pxd.contact;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Scanner;

/**
 * @Description
 * @Author 彭孝东
 * @QQ 932056657
 */
public class Util {
    //将汉字姓名转化为拼音（每个汉字的首字母大写）
    public static String getFirstAlpha(String string){
        //保存所有字符的首字母
        StringBuilder sb = new StringBuilder();

        //将字符串转化为字符数组
        char[] chars = string.toCharArray();

        //输出格式
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //设置大小写
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        //遍历数组
        for (char ch : chars){
            //判断是不是汉字
            if(ch > 128){
                //将这个字符转化为拼音
                try {
                    //返回的数组里面只有一个元素
                    String[] strings = PinyinHelper.toHanyuPinyinStringArray(ch, format);
                    //获取这个汉字的拼音的首字母
                    sb.append(strings[0].charAt(0));
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            }else{
                //不是汉字 不需要转化
                sb.append(ch);
            }

        }
        return sb.toString();
    }

    //是否继续
    public static boolean isContinue(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("是否继续(1.继续 2.完成)?:");
            int result = scanner.nextInt();

            if (result == 1){
                return true;
            } else if (result == 2){
                return false;
            } else{
                System.out.print("输入格式不对 ");
            }
        }
    }
}
