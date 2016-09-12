package lab;

import lab.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
class BeanContainer {

    @Autowired
    Person person;
}

public class NonJunitTest {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        BeanContainer container = context.getBean(BeanContainer.class);
        System.out.println(container.person);
    }

}
