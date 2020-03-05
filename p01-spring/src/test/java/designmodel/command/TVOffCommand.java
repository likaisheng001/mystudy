package designmodel.command;

/**
 * Created by Administrator on 2019/8/30.
 */
public class TVOffCommand implements Command{
    TVReceiver tv;

    public TVOffCommand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
