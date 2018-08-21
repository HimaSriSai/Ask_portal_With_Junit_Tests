/**
 * 
 */
package com.prokarma.common.util;

/**
 * @author Prokarma
 *
 */
public class CommonUtil {
	
public static String formatEmployeeName(String firName,String lName)
	{
		if(firName!=null && lName!=null) {
			return toInitCap(lName.trim()) + " " + toInitCap(firName.trim());
		}
		return "";		
	}
	
	   public static  String toInitCap(String param) {
	        if (param != null && param.length() > 0) {
	            char[] charArray = param.toCharArray();
	            charArray[0] = Character.toUpperCase(charArray[0]);
	            // set capital letter to first position
	            return new String(charArray);
	            // return desired output
	        } else {
	            return "";
	        }
	    }
	   

}
