package reference;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionInJava {
		   
		   //instance method of the outer class 
			Object my_Method(){
		      int num = 23;
		   
		      //method-local inner class
		      class MethodInner_Demo{
		         public void print(){
		        	System.out.println("This is method inner class "+num);	   
		         }   
		      }//end of inner class
			  //Accessing the inner class
		      MethodInner_Demo inner = new MethodInner_Demo();
		      // inner.print();
		      return inner;
		   }
		   
		   public static void main(String args[]) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			   ReflectionInJava outer = new ReflectionInJava();
			   Object inner = outer.my_Method();
			   Class c = inner.getClass();
			   Method m = c.getMethod("print");
			   m.invoke(inner);
		   }
		}