package cg.demo.DIassignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;



public class App 
{
    public static void main( String[] args )
    {

       ApplicationContext ac = new ClassPathXmlApplicationContext("springconfig.xml");
       
       
       Employee e  = (Employee) ac.getBean("emp1");

       System.out.println("Employee Details");
       System.out.println("----------------");
       
       e.detail();
    	

    }
}
