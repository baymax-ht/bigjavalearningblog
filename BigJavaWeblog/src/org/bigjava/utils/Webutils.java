package org.bigjava.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.druid.sql.visitor.functions.If;

public class Webutils {
	/**
	 * 把Map中的值注入到对应的JavaBean属性中。
	 * 
	 * @param value
	 * @param bean
	 */
	public static <T> T copyParamToBean(Map value, T bean) {
		try {
			// System.out.println("注入之前：" + bean);
			/**
			 * 把所有请求的参数都注入到user对象中
			 */
			BeanUtils.populate(bean, value);
			// System.out.println("注入之后：" + bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * 类型转换
	 * 
	 * @param strInt
	 * @param deafult
	 * @return 返回deafult转换失败
	 */
	public static int parseInt(String string, int defaultavlue) {
		try {
			 return (string==null)?defaultavlue:Integer.parseInt(string);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultavlue;
	}

}
