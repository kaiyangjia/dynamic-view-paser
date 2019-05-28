package com.jiakaiyang.dynamicviewpaser.lib;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.LoaderClassPath;
import javassist.NotFoundException;

/**
 * Created by kaiyangjia 10/4/2019
 *
 * @author kaiyangjia
 */
public class AttributeSetCreater {
    private static final String TAG = "AttributeSetCreater";

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

    public static void test() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            classPool.appendClassPath(new LoaderClassPath(ClassLoader.getSystemClassLoader()));
            classPool.appendClassPath(new LoaderClassPath(PathClassLoader.getSystemClassLoader()));
            classPool.appendClassPath(new LoaderClassPath(DexClassLoader.getSystemClassLoader()));


            URL url = classPool.find("XmlBlock");
            URL url2 = classPool.find("MainActivity");

            Log.i(TAG, "test: url:" + url + ", " + url2);

            CtClass xmlBlockParser = ClassPool.getDefault().getCtClass(XmlBlockParserName);
            CtClass myParser = ClassPool.getDefault().get("com.jiakaiyang.dynamicviewpaser.lib.DXmlResourcesParser");

            myParser.setSuperclass(xmlBlockParser);

            DXmlResourcesParser parser = new DXmlResourcesParser();
            Class superClass = parser.getClass().getSuperclass();
            Log.i(TAG, "test: " + superClass.getName());
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
}
