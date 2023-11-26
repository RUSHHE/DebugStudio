package five.six;

public class Main {
    public static void main(String[] args) {
        Agent agent = new Agent(new Singer());
        agent.sing();
    }
}

interface Ability {
    void sing();
}

class Singer implements Ability {

    @Override
    public void sing() {
        System.out.println("歌手唱歌：“明知这是一场意外”");
    }
}

class Agent implements Ability {
    private Singer singer;

    public Agent(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("经纪人同意接单");
        singer.sing();
        System.out.println("演唱会结束，歌手休息");
    }
}