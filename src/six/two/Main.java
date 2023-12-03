package six.two;

public class Main {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone miPhone = factory.makePhone("小米手机");
        IPhone iPhone = (IPhone) factory.makePhone("苹果手机");
        System.out.println(miPhone);
        System.out.println(iPhone);
    }
}

interface Phone {
    void makePhone();
}

class IPhone implements Phone {
    String founder = "乔布斯";
    double price = 8299;
    @Override
    public void makePhone() {
        System.out.println("iPhone");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "founder = " +
                founder +", " +
                "price = " +
                price +
                "}";
    }
}

class MiPhone implements Phone {
    String founder = "雷军";
    double price = 3999;
    @Override
    public void makePhone() {
        System.out.println("小米手机");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "founder = " +
                founder +", " +
                "price = " +
                price +
                "}";
    }
}

class PhoneFactory {
    public Phone makePhone(String name) {
        Phone phone = null;
        if (name.equals("小米手机")) {
            phone = new MiPhone();
        } else if (name.equals("苹果手机")) {
            phone = new IPhone();
        }
        return phone;
    }
}