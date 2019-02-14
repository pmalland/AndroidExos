package com.paulmalland.boot;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.paulmalland.boot.controller.HomeControler;

public class AppTest 
    
{
	@Test
    public void testApp() {
       
		HomeControler hc = new HomeControler();
		String result = hc.home();
		assertEquals(result, "Das Boot, report for the boot!");
		
    }
}
