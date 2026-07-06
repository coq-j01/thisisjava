package ch12.sec11.exam02.copy3;

import java.lang.reflect.*;
	
public class ReflectionExample {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("실행 인자가 부족함");
			return;
		}
		
		Class clazz = Class.forName(args[0]);
		//Class clazz = Class.forName("ch12.sec11.exam02.Car");
		//Car car = new Car();
		Object car = clazz.getConstructor().newInstance();
		
		Method setModelMethod = clazz.getDeclaredMethod(args[1], String.class);
		//Method setModelMethod = clazz.getDeclaredMethod("setModel", String.class);
		setModelMethod.invoke(car, args[2]);
		//setModelMethod.invoke(car, "모델");
		//car.setModel("모델");
		
		//car.setOwner("오너");
		
		Method getModelMethod = clazz.getDeclaredMethod(args[3]);
		//Method getModelMethod = clazz.getDeclaredMethod("getModel");
		String model = (String) getModelMethod.invoke(car);
		//String model = car.getModel();
		
		//String owner = car.getOwner();

		System.out.println(model);
		//System.out.println(owner);
		
		//Class clazz = Car.class;
		//Class clazz = Class.forName("ch12.sec11.exam02.Car");
		
//		System.out.println("[생성자 정보]");
//		Constructor[] constructors = clazz.getDeclaredConstructors();
//		for(Constructor constructor : constructors) {
//			System.out.print(constructor.getName() + "(");
//			Class[] parameters = constructor.getParameterTypes();
//			printParameters(parameters);
//			System.out.println(")");
//		 	}
//		System.out.println();
//		
//		System.out.println("[필드 정보]");
//		Field[] fields = clazz.getDeclaredFields();
//		for(Field field : fields) {
//			System.out.println(field.getType().getName() + " " + field.getName());
//		}
//		System.out.println();
//		
//		System.out.println("[메소드 정보]");
//		Method[] methods = clazz.getDeclaredMethods();
//		for(Method method : methods) {
//			System.out.print(method.getName() + "(");
//			Class[] parameters = method.getParameterTypes();
//			printParameters(parameters);
//			System.out.println(")");
//		}
	}
			
	private static void printParameters(Class[] parameters) {
		for(int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if(i<(parameters.length-1)) {
				System.out.print(",");
			}
		}
	}
}		