package com.prokarma.common.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommonUtilTest {
	
	@Test
	public void testFormatEmployeeName() {		
		String returnVal=CommonUtil.formatEmployeeName(null,null);
		assertEquals("",returnVal);		
	}
	
	@Test
	public void testToInitCap() {		
		String returnVal=CommonUtil.toInitCap(null);
		assertEquals("",returnVal);		
		@SuppressWarnings("unused")
		CommonUtil commonUtil=new CommonUtil();
	}

}
