package designmodel.mediator;

//定义同事类模板
public abstract class Colleague {
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }
    public abstract void sendMessage(int stateChange);
}
