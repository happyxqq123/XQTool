package com.XQTool.mybatis;

import com.XQTool.mybatis.reflection.Reflector;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ReflectorTest
 * @Description TODO
 * @Author admin
 * @Date 2022/10/13 15:52
 * @Version 1.0
 **/
public class ReflectorTest {

    @Test
    public void test1(){
        Reflector reflector = new Reflector(Person.class);
        String [] getableNames = reflector.getGetablePropertyNames();
        String [] setableName = reflector.getSetablePropertyNames();
     //   Arrays.stream(getableNames).forEach(System.out::println);
        Arrays.stream(setableName).forEach(System.out::println);
    }

    @Test
    public void test2(){
        Reflector reflector = new Reflector(Person.class);
        Method [] methods = reflector.getClassMethods(Person.class);
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }

    @Test
    public void test3(){
        Map<String,Method> map = getClassMethods(Person.class);
        System.out.println(map);
    }

    public Map<String,Method> getClassMethods(Class<?> clazz){
        Map<String,Method> uniqueMethods = new HashMap<>();
        Class<?> currentClass = clazz;
        while(currentClass != null && currentClass != Object.class){
            addUniqueMethods(currentClass, uniqueMethods);

            Class<?>[] interfaces = currentClass.getInterfaces();
            for(Class<?> asInterface : interfaces){
                addUniqueMethods(asInterface,uniqueMethods);
            }
            currentClass = currentClass.getSuperclass();
        }
        return uniqueMethods;
    }

    private static void addUniqueMethods(Class<?> clazz, Map<String, Method> uniqueMethods) {
        Method [] methods =  clazz.getDeclaredMethods();
        for(Method method : methods){
            StringBuilder sBuilder = new StringBuilder();
            Class<?> returnType =  method.getReturnType();
            sBuilder.append(returnType.getName()).append("#").append(method.getName());
            Class<?>[] parameters =method.getParameterTypes();
            for(int i = 0; i < parameters.length; i++){
                sBuilder.append(i==0? ':':',').append(parameters[i].getName());
            }
            String signature =sBuilder.toString();
            if(!uniqueMethods.containsKey(signature)){
                uniqueMethods.put(signature,method);
            }
        }
    }
}
