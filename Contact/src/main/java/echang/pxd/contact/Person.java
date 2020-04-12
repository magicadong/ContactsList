package echang.pxd.contact;

/**
 * @Description
 * @Author 彭孝东
 * @QQ 932056657
 */
public class Person implements Comparable<Person>{
    String firstAlphaString; //汉字的首字母组成的字符串
    String name;

    public Person(String firstAlphaString, String name) {
        this.firstAlphaString = firstAlphaString;
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return firstAlphaString.compareTo(person.firstAlphaString);
    }
}
