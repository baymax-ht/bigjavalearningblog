package org.bigjava.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.druid.sql.visitor.functions.If;

public class Webutils {
	/**
	 * ��Map�е�ֵע�뵽��Ӧ��JavaBean�����С�
	 * 
	 * @param value
	 * @param bean
	 */
	public static <T> T copyParamToBean(Map value, T bean) {
		try {
			// System.out.println("ע��֮ǰ��" + bean);
			/**
			 * ����������Ĳ�����ע�뵽user������
			 */
			BeanUtils.populate(bean, value);
			// System.out.println("ע��֮��" + bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * ����ת��
	 * 
	 * @param strInt
	 * @param deafult
	 * @return ����deafultת��ʧ��
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
