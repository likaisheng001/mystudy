package designmodel.command;

/**
 * Created by Administrator on 2019/8/30.
 */
public class LightOnCommand implements Command{
    LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
