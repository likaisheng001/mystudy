package designmodel.mediator;

/**
 * Created by Administrator on 2019/9/2.
 */
public class Curtains extends Colleague{

    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    public void upCurtains(){
        System.out.println("i am holding up curtains!");
    }
    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }
}
