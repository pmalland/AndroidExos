package com.paulmalland.boot;


import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.paulmalland.boot.controller.ShipwreckController;
import com.paulmalland.boot.model.Shipwreck;
import com.paulmalland.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(sw);
		
		
		Shipwreck wreck =sc.get(1L);
		
		verify(shipwreckRepository).findOne(1L);
		
		// without Harmcrest
//		assertEquals(1L, wreck.getId().longValue()); 

		// With Harmcrest
		assertThat(wreck.getId(), is (1L));
		
	}
	
	
}
