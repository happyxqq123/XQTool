package com.XQTool.mybatis;

import com.XQTool.mybatis.reflection.property.PropertyTokenizer;
import org.junit.Test;

/**
 * @ClassName PropertyTokenizerTest
 * @Description TODO
 * @Author admin
 * @Date 2022/10/13 15:01
 * @Version 1.0
 **/
public class PropertyTokenizerTest {

    @Test
    public void test1(){
        String req2 = "student.name.abc";
        String reg = "student[0].a";
        PropertyTokenizer propertyTokenizer = new PropertyTokenizer(reg);
        System.out.println(propertyTokenizer.getName());
        System.out.println(propertyTokenizer.getIndexedName());
        System.out.println(propertyTokenizer.getChildren());
    }

}
