package six.four;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
        DishManage dishManage = new DishManage();
        while (true) {
            System.out.println("请根据提示操作：");
            System.out.println("1.点餐");
            System.out.println("2.查看已点菜品及数量");
            System.out.println("3.买单");
            System.out.println("4.查看历史账单");
            System.out.println("5.退出");

            Scanner scan = new Scanner(System.in);
            switch (scan.nextInt()) {
                case 1:
                    while (true) {
                        System.out.println("请选择菜的类型");
                        System.out.println("1.素菜");
                        System.out.println("2.荤菜");
                        System.out.println("3.返回");
                        int choice = scan.nextInt();
                        if (choice == 1 || choice == 2) {
                            dishManage.showMenu(choice);
                            System.out.println("请输入菜品ID，输入0取消");
                            int dishId = scan.nextInt();
                            if (dishId == 0) {
                                continue;
                            }
                            System.out.println("请输入份数，输入0取消");
                            int count = scan.nextInt();
                            if (count == 0) {
                                continue;
                            }
                            dishManage.order(dishId, count);
                        } else if (choice == 3) {
                            break;
                        }
                    }
                    break;
                case 2:
                    dishManage.showIsOrdered();
                    break;
                case 3:
                    dishManage.fresh();
                    break;
                case 4:
                    dishManage.getBill().showItemList();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效选项");
                    break;
            }
        }
    }
}

//菜品类
class Dish {
    private final int dishId; // 菜品id

    public String getDishName() {
        return dishName;
    }

    private final String dishName; // 菜品名称
    private final int dishType; // 菜品类型
    private final double price; // 单品价格
    private int orderCount; // 点菜单品数量

    public Dish(int dishId, String dishName, int dishType, int orderCount, double price) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishType = dishType;
        this.orderCount = orderCount;
        this.price = price;
    }

    public Dish(Dish dish) {
        this.dishId = dish.dishId;
        this.dishName = dish.dishName;
        this.dishType = dish.dishType;
        this.orderCount = dish.orderCount;
        this.price = dish.price;
    }

    public int getDishId() {
        return dishId;
    }

    public int getDishType() {
        return dishType;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public Dish setOrderCount(int orderCount) {
        this.orderCount = orderCount;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return dishId + "." +
                dishName + "," +
                "价格：" +
                price;
    }
}

class DishManage {

    //账单，上面记着所有的菜品，以及哪些菜品被点上了
    private final List<Dish> menu;

    public Bill getBill() {
        return bill;
    }

    private final Bill bill;

    //创建这个菜单管理时，把菜单里的菜填充进去
    public DishManage() {
        this.menu = new ArrayList<>();
        this.bill = new Bill();
        //下面这里用到了枚举类
        this.menu.add(new Dish(101, "蒜蓉蒸茄子", DishType.VEGETABLE.getTypeId(), 0, 29.9));
        this.menu.add(new Dish(201, "糖醋排骨", DishType.MEAT.getTypeId(), 0, 69.9));
    }

    //根据荤菜和素菜，来展示所有菜，使用到上一个任务中的枚举类
    public void showMenu(int dishType) {
        if (dishType == 1) {
            System.out.println("素菜菜单");
        } else if (dishType == 2) {
            System.out.println("荤菜菜单");
        } else {
            System.out.println("没有此选项");
        }
        for (Dish dish : menu) {
            if (dish.getDishType() == dishType) {
                System.out.println(dish);
            }
        }
    }

    //展示哪些菜已经被点上了
    public void showIsOrdered() {
        double sum = 0;
        for (Dish dish : menu) {
            if (dish.getOrderCount() > 0) {
                System.out.println(
                        dish.getDishName() + "，" +
                        dish.getOrderCount() + "份 * " +
                        "￥" + dish.getPrice()
                );
                sum += dish.getPrice() * dish.getOrderCount();
            }
        }
        System.out.println("目前共计费用" + sum + "元");
    }

    //根据菜品的ID，和点了多少份，记录在账单中
    public void order(int dishId, int count) {
        for (Dish dish : menu) {
            if (dish.getDishId() == dishId) {
                dish.setOrderCount(dish.getOrderCount() + count);
            }
        }
    }

    //结账，计算总金额
    public double checkOut() {
        double sum = 0;
        for (Dish dish : menu) {
            if (dish.getOrderCount() > 0) {
                sum += dish.getOrderCount() * dish.getPrice();
            }
        }
        return sum;
    }

    //完成一次消费后，菜单恢复初始状态
    public void fresh() {
        bill.addItem(menu, checkOut());
        for (Dish dish : menu) {
            dish.setOrderCount(0);
        }
    }
}

//账单类
class Bill {
    // 历史记录
    List<Item> itemList;

    public Bill() {
        itemList = new ArrayList<>();
    }

    // 往历史记录中添加记录，参数是这次买单的菜单列表，和消费金额
    public void addItem(List<Dish> dishList, double money) {
        itemList.add(new Item().setDishList(dishList).setMoney(money));
    }

    // 展示账单列表
    public void showItemList() {
        for (Item item : itemList) {
            System.out.println(item);
        }
    }

    // 内部类，每一个历史记录项，记录着每一次点了那些菜，和金额还有时间
    static class Item {
        private final Date time;
        private double money;
        private final List<Dish> dishList;

        Item() {
            this.time = new Date();
            dishList = new ArrayList<>();
        }

        public Item setMoney(double money) {
            this.money = money;
            return this;
        }

        public Item setDishList(List<Dish> dishList) {
            for (Dish dish : dishList) {
                if (dish.getOrderCount() > 0) {
                    this.dishList.add(new Dish(dish));
                }
            }
            return this;
        }

        private String printBill() {
            StringBuilder sb = new StringBuilder();
            for (Dish dish : dishList) {
                sb.append(dish).append("*").append(dish.getOrderCount()).append("份").append("\n");
            }
            return sb.toString();
        }

        public String toString() {
            return "消费时间" + time + "，" +
                    "消费金额" + money + "\n" +
                    printBill();
        }
    }
}