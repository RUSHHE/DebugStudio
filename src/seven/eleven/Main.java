package seven.eleven;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //用继承Thread类或实现Runnable接口自行选择
        //下面示例代码用的是继承Thread类
        Ticket ticket=new Ticket();
        SaleTickets st1 = new SaleTickets("a",ticket);
        SaleTickets st2 = new SaleTickets("b",ticket);
        SaleTickets st3 = new SaleTickets("c",ticket);

        st1.run();
        st2.run();
        st3.run();
    }
}

class SaleTickets implements Runnable {
    String name;
    Ticket ticket;
    public SaleTickets(String name, Ticket ticket) {
        this.name = name;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        do {
            System.out.print(name + ":");
        } while (ticket.minus() != -1);
    }
}

class Ticket {
    private int ticket = 20;

    public synchronized int minus() {
        if (ticket > 0) {
            System.out.println("还剩" + --ticket + "张票");
        } else {
            System.out.println("票已经卖完啦");
            return -1;
        }
        return 0;
    }
}