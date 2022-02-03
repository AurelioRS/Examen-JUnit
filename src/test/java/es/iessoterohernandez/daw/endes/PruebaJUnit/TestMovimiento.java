package es.iessoterohernandez.daw.endes.PruebaJUnit;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cuentas.Movimiento;

public class TestMovimiento {
	private Movimiento m;
	@Before
	public void setUp() throws Exception {
		m = new Movimiento();
		m.setImporte(299.9);
		m.setConcepto("Alquiler Febrero");
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}


	@Test
	public void testGetImporte() {
		assertEquals(299.9,m.getImporte(),0);
		//Con Hamcrest
		assertThat(m.getImporte(),Matchers.is(299.9));
	}
	
	

	@Test
	public void testGetConcepto() {
		assertEquals("Alquiler Febrero",m.getConcepto());
		//Con Hamcrest
		assertThat(m.getConcepto(),Matchers.is("Alquiler Febrero"));
	}
	
	@Test
	public void testSetImporte() {
		assertEquals(299.9,m.getImporte(),0);
		m.setImporte(400.);
		assertEquals(400.,m.getImporte(),0);
		//Con Hamcrest
		assertThat(m.getImporte(),Matchers.is(400.));
		
	}
	
	@Test
	public void testSetConcepto() {
		assertEquals("Alquiler Febrero",m.getConcepto());
		m.setConcepto("Alquiler Marzo");
		assertEquals("Alquiler Marzo",m.getConcepto());
		//Con Hamcrest
		assertThat(m.getConcepto(),Matchers.is("Alquiler Marzo"));
	}

}
