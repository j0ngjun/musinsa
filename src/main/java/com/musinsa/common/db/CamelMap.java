package com.musinsa.common.db;

import java.util.LinkedHashMap;

public class CamelMap extends LinkedHashMap<Object, Object> {

	private static final long serialVersionUID = -5697177904794177514L;

	@Override
	public Object put(Object key, Object value) {
		return super.put(this.convCamel(key), value);
	}
	
	// underscore를 camelcase 변경 
	private Object convCamel(Object key) {
		
		if (!(key instanceof String)) {
			return key;
		}
		
		String temp = (String) key;
		if (temp.length() == 0 || (temp.indexOf("_") == -1 && Character.isLowerCase(temp.charAt(0)))) {
			return key;
		}
		
		int length = temp.length();
		StringBuilder camelKey = new StringBuilder();
		
		boolean isUpper = false;
		for (int i = 0; i < length; ++i) {
			
			char curChar = temp.charAt(i);
			if (curChar == '_') {
				isUpper = true;
				continue;
			}
			
			if (isUpper) {
				camelKey.append(Character.toUpperCase(curChar));
				isUpper = false;
			} else {
				camelKey.append(Character.toLowerCase(curChar));
			}
		}
		
		return camelKey.toString();
	}
}
