package com.wolox.automation.wappi.exceptions;

public class OrderException extends AssertionError {
	
	public static final String NO_PRODUCT_IN_ORDER = "No se encontro el producto en la ventana de pedidos";
	public static final String NO_COUPON_STATE = "El estado actual del cupon para el producto ordenado no es el esperado";
	
	public OrderException(String message, Throwable cause) {
		super(message, cause);
	}
}
