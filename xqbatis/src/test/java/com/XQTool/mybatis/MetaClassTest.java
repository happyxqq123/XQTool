package com.XQTool.mybatis;

import com.XQTool.mybatis.reflection.DefaultReflectorFactory;
import com.XQTool.mybatis.reflection.MetaClass;
import com.XQTool.mybatis.reflection.Reflector;
import org.junit.Test;

/**
 * @ClassName MetaClassTest
 * @Description TODO
 * @Author admin
 * @Date 2022/10/14 15:15
 * @Version 1.0
 **/
public class MetaClassTest {

    @Test
    public void test1(){
        Person person = new Person();
        Reflector reflector = new Reflector(person.getClass());
        MetaClass metaClass = MetaClass.forClass(person.getClass(),new DefaultReflectorFactory());
        StringBuilder sb = metaClass.buildProperty("leg.length",new StringBuilder());
        System.out.println(sb.toString());
    }

    @Test
    public void test2(){
        MetaClass metaClass = MetaClass.forClass(Person.class,new DefaultReflectorFactory());
        MetaClass metaClassLeg =  metaClass.metaClassForProperty("leg");
        String [] getNames =  metaClassLeg.getGetterNames();
        for(String name : getNames){
            System.out.print(name+" ");
        }
    }

    @Test
    public void test3(){
        Reflector reflector = new Reflector(Person.class);
        Class<?> legClass =  reflector.getGetterType("leg");
        System.out.println(legClass);
    }

    @Test
    public void test4(){
        MetaClass metaClass = MetaClass.forClass(Person.class,new DefaultReflectorFactory());
        String str = metaClass.findProperty("leg");
        System.out.println(str);
    }
}
