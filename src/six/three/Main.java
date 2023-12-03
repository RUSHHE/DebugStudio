package six.three;

enum DishType {
    VEGETABLE(1, "蔬菜"),
    MEAT(2, "肉类");

    private final int typeId;
    private final String typeName;

    DishType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(DishType.VEGETABLE.getTypeId() + ":" + DishType.VEGETABLE.getTypeName());
        System.out.println(DishType.MEAT.getTypeId() + ":" + DishType.MEAT.getTypeName());
    }
}