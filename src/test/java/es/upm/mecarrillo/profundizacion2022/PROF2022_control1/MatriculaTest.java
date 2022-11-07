package es.upm.mecarrillo.profundizacion2022.PROF2022_control1;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Vector;

//import org.junit.Test;
import org.junit.jupiter.api.Test;


public class MatriculaTest{

	@Test
	public void vector_asignaturas_nulo() {		
		Matricula matricula1 = new Matricula(null);
		
		assertThrows(Exception.class, () -> matricula1.getImporte());
	}
	
	
	@Test
	public void calculo_de_importes() throws Exception {
		Asignatura asignatura1 = mock(Asignatura.class);
		Asignatura asignatura2 = mock(Asignatura.class);
		Asignatura asignatura3 = mock(Asignatura.class);
		
		Vector<Asignatura> asignaturas = new Vector<Asignatura>();
		asignaturas.add(asignatura1);
		asignaturas.add(asignatura2);
		asignaturas.add(asignatura3);
	
		//Mock del metodo getImporte
		when(asignatura1.getImporte()).thenReturn(1.0);
		when(asignatura2.getImporte()).thenReturn(2.0);
		when(asignatura3.getImporte()).thenReturn(3.0);
		
		//Calculo del importe
		Matricula matricula = new Matricula(asignaturas);
		double importe = matricula.getImporte();
		
		assertTrue(importe == 6.0);
	}
	
	@Test
	public void recorrer_asignaturas() throws Exception {
		Asignatura asignatura1 = mock(Asignatura.class);
		Asignatura asignatura2 = mock(Asignatura.class);
		Asignatura asignatura3 = mock(Asignatura.class);
		Asignatura asignatura4 = mock(Asignatura.class);
		Asignatura asignatura5 = mock(Asignatura.class);

		
		Vector<Asignatura> asignaturas = new Vector<Asignatura>();
		asignaturas.add(asignatura1);
		asignaturas.add(asignatura2);
		asignaturas.add(asignatura3);
		asignaturas.add(asignatura4);
		asignaturas.add(asignatura5);
		
		//Mock del metodo getImporte
		when(asignatura1.getImporte()).thenReturn(1.0);
		when(asignatura2.getImporte()).thenReturn(10.0);
		when(asignatura3.getImporte()).thenReturn(1.0);
		when(asignatura4.getImporte()).thenReturn(1.0);
		when(asignatura5.getImporte()).thenReturn(1.0);
		
		Matricula matricula = new Matricula(asignaturas);
	
		//Calculo del importe. Se tiene 5 asignaturas. El importe1 debe ser 14.0
		double importe1 = matricula.getImporte();
		
		//Se borra la asignatura de importe 10. El nuevo importe debe ser 4.0
		asignaturas.removeElement(asignatura2);
		double importe2 = matricula.getImporte();
		
		assertTrue(importe1 == 14.0);
		assertTrue(importe2 == 4.0);
	}
	
}
