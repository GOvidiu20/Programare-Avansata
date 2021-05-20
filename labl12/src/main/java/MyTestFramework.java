import java.io.File;
import java.lang.reflect.Method;

public class MyTestFramework {
    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\Ovidiu Gabor\\Desktop\\PA\\labl11\\src\\main\\java\\Controller\\Person.class";
        File classFile = new File(path);
        //numele clasei
        String className = classFile.getName();
        //numele clasei fara extensia .class
        className = className.split("\\.")[0];
        classFile = classFile.getParentFile();
        //numele pachetului
        StringBuilder packageName = new StringBuilder(classFile.getName());

        MyClassLoader myLoader1 = new MyClassLoader();
        myLoader1.loadClass(packageName+"."+className);

        int passed = 0, failed = 0;
        for (Method m : Class.forName(myLoader1.getName()).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                System.out.println(m.getName());
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
    }
}