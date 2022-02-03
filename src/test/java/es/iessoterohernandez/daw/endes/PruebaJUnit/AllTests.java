package es.iessoterohernandez.daw.endes.PruebaJUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCuenta.class, TestMovimiento.class })
public class AllTests {

}
