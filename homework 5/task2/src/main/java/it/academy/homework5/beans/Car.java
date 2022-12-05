package it.academy.homework5.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Getter
@Setter
@ToString
public class Car implements InitializingBean, DisposableBean {

    private String name;
    private int year;

    @Override
    public void afterPropertiesSet() {
        // Init method for bean
        System.out.println("afterPropertiesSet() executed!");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() executed!");
    }

    public void defaultInit() {
        System.out.println("Default init() executed!");
    }

    public void defaultDestroy() {
        System.out.println("Default destroy() executed!");
    }

    public static Car getInstance() {
        return new Car();
    }
}
