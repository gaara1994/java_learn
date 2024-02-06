public class User {
    private String name;
    private int age;

    // 添加构造函数、getter和setter
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {  // 添加setName方法
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {  // 添加setAge方法
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名: " + name + ", 年龄: " + age;
    }
}
