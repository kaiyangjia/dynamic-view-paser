package com.jiakaiyang.dynamicviewpaser.lib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by kaiyangjia 10/4/2019
 *
 * @author kaiyangjia
 */
public class AttributeSetCreater {
    private static String XmlBlockParserName = "android.content.res.XmlBlock$Parser";

    public static void createParser() {
        try {
            Class clazz = Class.forName(XmlBlockParserName);

            Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return null;
                }
            });

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
