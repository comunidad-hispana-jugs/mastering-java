package org.medellinjug.mastering.generics;

/**
 * 
 * @author ecabrerar
 * @date Jun 3, 2020
 *
 */
public interface BoxGenericInterface<T1, T2> {

	 T2 doSomeOperation(T1 t);
	 T1 doReverseOperation(T2 t);
}
