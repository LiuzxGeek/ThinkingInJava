package com.java.thinking.annotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/*
*@author:liuxian
*@date:2018年5月29日
*/
@SupportedAnnotationTypes("com.java.thinking.annotation.TestAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		for (TypeElement element : annotations) {
			Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(element);
			for (Element element2 : elements) {
				Comment annotation = element2.getAnnotation(Comment.class);
				if (annotation != null) {
					// 获取注解值
					String value = annotation.value();
					System.out.println(value);
				}
			}
		}
		return true;
	}
}
