package com.eureka.learn;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;

/**
 * 类加载器测试
 *
 * @author Ljj
 * @date 2020/5/28 14:31
 * @since 1.0
 */
public class ClassLoaderTest {

    private static final String CLASS_PATH = "F:"+File.separator+"Foo.class";


    public static void main(String[] args) throws Exception {

        // static

        System.out.println(StaticTest.i);


        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());


        Class<?> fooClass = new MyClassLoader().loadClass(CLASS_PATH);

        System.out.println(fooClass.getClassLoader());

        System.out.println(fooClass.getDeclaredConstructor().newInstance());


        for (Field field :fooClass.getDeclaredFields()){
            field.setAccessible(true);
            System.out.println(field.toString().substring(field.toString().lastIndexOf(".")+1));
        }
    }
}

// 自定义类加载器 要覆写findClass方法，而不要覆写loadClass 修改默认得委派逻辑，不然可能导致程序启动不了
class MyClassLoader extends ClassLoader{

    private static final String CLASS_NAME = "com.lovnx.learn.Foo";


    @lombok.SneakyThrows
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        System.out.println("使用默认得委派逻辑");

        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in= new FileInputStream(new File(name));
            out= new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            byte[] cls = out.toByteArray();
            return defineClass(CLASS_NAME,cls,0,cls.length);
        }finally {
            if (in!=null)
                in.close();
            if (out!=null)
                out.close();
        }
    }
}


class StaticTest{

    static {

        i = 0;
//        System.out.println(i);  // 程序此处报错
    }

    public   static int i;

}
