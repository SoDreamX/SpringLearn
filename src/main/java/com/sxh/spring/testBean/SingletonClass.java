package com.sxh.spring.testBean;

public class SingletonClass {
	private static SingletonClass singletonClass = new SingletonClass();
	
	private SingletonClass() {};
	
	public static SingletonClass getInstance() {
		return singletonClass;
	}
	
	public void init()
    {
        System.out.println("Enter SingletonClass.init()");
    }
    
    public void destory()
    {
        System.out.println("Enter SingletonClass.destory()");
    }
}
