package es.iessoterohernandez.daw.endes.PruebaJUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cuentas.Cuenta;
import cuentas.IngresoNegativoException;
import cuentas.Movimiento;

public class TestCuenta {
	private Cuenta c;
	private Movimiento m;
	
	@Before
	public void setUp() throws Exception {
		c = new Cuenta("12 3456 7890 1234567890","Juan Nadie");
		
		m = new Movimiento();
		m.setImporte(299.9);
		m.setConcepto("Alquiler Febrero");
	}

	@After
	public void tearDown() throws Exception {
		c = null;
		
		m = null;
	}

	@Test
	public void testCuenta(){
		System.out.println(c.getClass());
		c.addMovimiento(m);
		assertEquals(299.9,c.getSaldo(),0);
		
	}
	
	@Test
	public void testIngresar() throws IngresoNegativoException {
		try {
			c.ingresar("Alquiler Febrero", 299.9);
		} catch (Exception e) {
			fail("No se pudo ingresar");
		}
		assertEquals(true,c.getSaldo()==299.9);
		
	}
	
	@Test
	public void testRetirar() throws IngresoNegativoException {
		try {
			c.ingresar("Alquiler Febrero", 299.9);
			c.retirar("Alquiler Febrero", 299.9);
		} catch (Exception e) {
			fail("No se pudo retirar");
		}
		assertEquals(0, c.getSaldo(),0);
	}
	
	@Test
	public void testGetSaldo(){
		c.addMovimiento(m);
		assertEquals(299.9,c.getSaldo(),0);
		//Ahora debería de salir el doble de saldo que antes
		c.addMovimiento(m);
		assertEquals(599.8,c.getSaldo(),0);
		
	}
	
	@Test
	public void testAddMovimiento(){
		c.addMovimiento(m);
		assertEquals(299.9,c.getSaldo(),0);
		
	}

}
