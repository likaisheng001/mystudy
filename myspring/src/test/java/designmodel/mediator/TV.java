package designmodel.mediator;

/**
 * Created by Administrator on 2019/9/2.
 */
public class TV extends Colleague{
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }
    public void startTV(){
        System.out.println("it's time to start tv!");
    }
    public void stopTV(){
        System.out.println("it's time to stop tv!");
    }
}
