package view.messages;

import view.styles.MyButton;
import view.styles.MyLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyFailMessage extends MyDialog{

    private static MyFailMessage failMessage;

    private MyFailMessage(){
        super("Fehler");

        MyLabel message=new MyLabel("Das hat leider nicht geklappt!");
        message.setPreferredSize(new Dimension(370,30));
        getRowOne().add(message);

        MyButton confirm=new MyButton("OK");
        confirm.setName("failMessage");
        getButton().add(confirm);
    }

    public static MyFailMessage getInstance(){
        if(failMessage==null){
            failMessage= new MyFailMessage();
        }
        return failMessage;
    }

}
