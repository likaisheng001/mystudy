package designmodel.mediator;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/9/2.
 */
public class ConcreteMediator extends Mediator{
    private HashMap<String,Colleague> colleagueMap;
    private HashMap<String ,String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<String,Colleague>();
        interMap = new HashMap<String,String>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName,colleague);
        if (colleague instanceof Alarm){
            interMap.put("Alarm",colleagueName);
        }else if(colleague instanceof TV){
            interMap.put("TV",colleagueName);
        }else if (colleague instanceof Curtains){
            interMap.put("Curtains",colleagueName);
        }else if (colleague instanceof CoffeeMachine){
            interMap.put("CoffeeMachine",colleagueName);
        }
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueMap.get(colleagueName) instanceof Alarm){
            if (stateChange == 0){
                ((CoffeeMachine)(colleagueMap.get(interMap.get("CoffeeMachine")))).startCoffee();
                ((TV)(colleagueMap.get(interMap.get("TV")))).startTV();
            }else if (stateChange == 1){
                ((TV)(colleagueMap.get(interMap.get("TV")))).stopTV();
            }
            //如果咖啡机发消息，这里处理
        }else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine){
            ((Curtains)(colleagueMap.get(interMap.get("Curtains")))).upCurtains();
        }else if (colleagueMap.get(colleagueName) instanceof Curtains){

        }
    }

    @Override
    public void sendMessage() {

    }
}
