package com.java.thinking.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
*@author:liuxian
*@date:2018年5月28日
*/
@Retention(RetentionPolicy.RUNTIME)
// @Target(ElementType.FIELD)
public @interface Comment {
	String value();
}
