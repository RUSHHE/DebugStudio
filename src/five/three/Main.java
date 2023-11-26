package five.three;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("qwe").setAge(123).setGender("男");
        System.out.println(user);
    }
}

@SuppressWarnings("UnusedReturnValue")
class User {
    private String userName;
    private int age;
    private String gender;

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "userName = " + userName + ", " +
                "age = " + age + ", " +
                "gender = " + gender +
                "}";
    }
}