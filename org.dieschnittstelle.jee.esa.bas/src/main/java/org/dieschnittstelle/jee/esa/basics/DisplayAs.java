package org.dieschnittstelle.jee.esa.basics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DisplayAs {

        String value();

}
