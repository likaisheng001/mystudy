package designmodel.mediator;

/**
 * Created by Administrator on 2019/9/3.
 */
public class TV extends Colleague{
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        // TODO Auto-generated constructor stub
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void StartTv() {
        // TODO Auto-generated method stub
        System.out.println("It's time to StartTv!");
    }

    public void StopTv() {
        // TODO Auto-generated method stub
        System.out.println("StopTv!");
    }
}
