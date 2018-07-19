package com.chonley.objectPattern.commandPattern;

import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * 命令模式：将“请求”封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。命令模式也支持可撤销的操作。
 */
public class Command {
}

//家电api
class Light{
    public void on(){
        System.out.println("开灯");
    }
    public void off(){
        System.out.println("关灯");
    }
}


//命令接口-不变的东西，也就是执行这个动作，所以进行抽象

interface Command1{
   void execute();
}

class LightOnCommand implements Command1{
    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }


    @Override
    public void execute() {
        light.on();
    }
}



class LightOffCommand implements Command1{
    private Light light;

    public  LightOffCommand(Light light){
        this.light = light;
    }


    @Override
    public void execute() {
        light.off();
    }
}



class NoCommand implements Command1{
    @Override
    public void execute() {

    }
}


//遥控器面板是不变的
class CommandPanel{
    private static final Integer index = 9;

    private Command1[] command1s;

    public CommandPanel(){
        command1s =  new Command1[index];
        for(Command1 c : command1s)
            c = new NoCommand();
    }

    //定制按键
    public void setCommand1s(Integer index, Command1 command1){
        command1s[index] = command1;
    }


    //使用按键
    public void pressKey(Integer index){
        command1s[index].execute();
    }

}


//测试用例
class Test{
    public static void main(String[] args){
        Light light = new Light();

        //command
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        QuickCommand quickCommand = new QuickCommand( new Command1[]{new LightOffCommand(light),new LightOnCommand(light)});

        //command panel

        CommandPanel commandPanel   = new CommandPanel();
        commandPanel.setCommand1s(1,lightOffCommand);
        commandPanel.setCommand1s(0,lightOnCommand);
        commandPanel.setCommand1s(2,quickCommand);

        //execute

        commandPanel.pressKey(1);
        commandPanel.pressKey(0);
        commandPanel.pressKey(2);
    }
}


//个性化定制需求

class QuickCommand implements Command1{
    private Command1[] command1  ;
    public QuickCommand(Command1[] command1  ){
       this.command1 = command1;
    }

    @Override
    public void execute() {
        for(Command1 a : command1){
            a.execute();
        }
    }
}