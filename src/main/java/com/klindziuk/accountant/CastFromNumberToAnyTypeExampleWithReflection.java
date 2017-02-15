package com.klindziuk.accountant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CastFromNumberToAnyTypeExampleWithReflection {

	
	
	
	private static Number inputNumber(Class aClass) {
        try {
            Constructor<?> ctor = aClass.getConstructor(String.class);
            return (Number) ctor.newInstance(new String[] {"123"});
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
