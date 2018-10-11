package org.dieschnittstelle.jee.esa.basics;


import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.jee.esa.basics.annotations.StockItemProxyImpl;

import java.lang.reflect.Field;

import static org.dieschnittstelle.jee.esa.utils.Utils.*;

public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {
			;
			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * UE BAS2 
	 */
	private static void showAttributes(Object consumable) {

		Field[] declaredFields = consumable.getClass().getDeclaredFields();
		Field field;
		String message = "{" + consumable.getClass().getSimpleName() + " ";

		for(int i = 0; i < declaredFields.length; i++){
			field = declaredFields[i];
			field.setAccessible(true);
			try {
				message += " " + field.getName() + ": " + field.get(consumable) + ",";
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		message = message.substring(0, message.length() - 1) + "}";
		show(message);
	}
}