package com.XQTool;

import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName WordTest
 * @Description TODO
 * @Author admin
 * @Date 2022/10/8 17:21
 * @Version 1.0
 **/
public class WordTest {

    @Test
    public void testBodyElemnts() throws IOException {
        String templatePath = "D:\\a.docx";
        XWPFDocument document = new XWPFDocument(new FileInputStream(templatePath));
        List<IBodyElement> elements = document.getBodyElements();
        for(IBodyElement element : elements){
            if(element.getElementType() == BodyElementType.PARAGRAPH){
                XWPFParagraph para = (XWPFParagraph)element;
                for(XWPFRun run : para.getRuns()){
                    System.out.println(run.getText(0));
                }
                System.out.println("------------------------");
            }else if(element.getElementType() == BodyElementType.TABLE){

            }
        }
    }

    @Test
    public void testTimer() throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("tttt");
                System.out.println(Thread.currentThread().getName());
            }
        },0,1000);
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10000);
        timer.cancel();
    }

}
