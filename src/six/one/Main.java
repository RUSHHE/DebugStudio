package six.one;

public class Main {
    public static void main(String[] args) {
        Student student = new Student.Builder(1, "陈睿")
                .setAge(123)
                .setGender("男")
                .setHeight(123.12)
                .setWeight(234.34)
                .build();
        System.out.println(student);
    }
}

class Student {
    private final int id; // 必选
    private final String name; // 必选
    private final int age; // 可选
    private final String gender; // 可选
    private final double height; // 可选
    private final double weight; // 可选

    public Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    public static class Builder {
        private final int id; // 必选
        private final String name; // 必选
        private int age; // 可选
        private String gender; // 可选
        private double height; // 可选
        private double weight; // 可选

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                id + ", " +
                name + ", " +
                age + ", " +
                gender + ", " +
                height + ", " +
                weight +
                "}";
    }
}