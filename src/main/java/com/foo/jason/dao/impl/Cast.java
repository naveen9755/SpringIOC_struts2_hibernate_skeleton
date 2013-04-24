package com.foo.jason.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

public class Cast {

	public static <T> ArrayList<T> castList(Class<? extends T> clazz, Collection<?> c) {
		ArrayList<T> r = new ArrayList<T>(c.size());
	    for(Object o: c) {
	      r.add(clazz.cast(o));
	    }
	    return r;
	}
}
