package cg.demo.DIassignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Employee;
import beans.SBU;



public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

        SBU sbu = (SBU) context.getBean("sbu");

        sbu.displaySBUDetails();

    }
}
