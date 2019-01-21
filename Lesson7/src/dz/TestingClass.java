package dz;


import dz.annotation.AfterSuite;
import dz.annotation.BeforeSuite;
import dz.annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestingClass {

    public static void start(String className) throws ClassNotFoundException {
        Class<?> work = Class.forName(className);
        TestingClass.start(work);
    }

    public static void start(Class<?> work) {
        Method[] methods = work.getMethods();
        int beforeSuites = 0;
        int afterSuites = 0;
        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuites++;
                if (beforeSuites > 1) {
                    break;
                }
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                afterSuites++;
                if (afterSuites > 1) {
                    break;
                }
            }
        }
        if (beforeSuites > 1 || afterSuites > 1) {
            throw new RuntimeException("В тестируемом классе более одного начального или завершающего метода");
        }
        Object testObject = null;
        try {
            testObject = work.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                try {
                    o.invoke(testObject);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = 1; i < 11; i++) {
            for (Method o : methods) {
                if (o.isAnnotationPresent(Test.class)) {
                    if (o.getAnnotation(Test.class).priority() == i) {
                        try {
                            o.invoke(testObject);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        for (Method o : methods) {
            if (o.isAnnotationPresent(AfterSuite.class)) {
                try {
                    o.invoke(testObject);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
