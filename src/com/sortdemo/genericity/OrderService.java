package com.sortdemo.genericity;

public interface OrderService <T1,T2,T3>{

	T1 addOrder(T1 t);
	T2 delOrder(T2 t);
	T3 updateOrder(T3 t);
}
