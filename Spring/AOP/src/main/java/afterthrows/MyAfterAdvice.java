package afterthrows;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
//    参数1：目标方法的返回值  参数2：当前执行方法对象 参数3：执行方法参数  参数4：目标对象
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("返回值" + o);
        System.out.println("方法名" + method.getName());
        System.out.println("方法的参数" + objects[0]);
        System.out.println("目标对象" + o1);
    }
}
