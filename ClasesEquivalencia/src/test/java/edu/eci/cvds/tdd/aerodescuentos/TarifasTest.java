package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.*;
import org.junit.Test;

public class TarifasTest {
	
	@Test
	public void validarSinDescuentoPorAnticipacion() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,18,30);//tarifa,dias,edad
		Assert.assertTrue(ans==200000);
	}
	
	@Test
	public void validarDescuentoPorAnticipacion() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,23,30);//tarifa,dias,edad
		Assert.assertTrue(ans==170000);
	}
	
	@Test
	public void validarSinDescuentoPorAnticipacionEn20() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,20,30);//tarifa,dias,edad
		Assert.assertTrue(ans==200000);
	}
	
	@Test
	public void validarDescuentoPorEdad() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,18,16);//tarifa,dias,edad
		Assert.assertTrue(ans==190000);
	}
	
	@Test
	public void validarSinDescuentoPorEdad18() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,18,18);//tarifa,dias,edad
		Assert.assertTrue(ans==200000);
	}
	
	@Test
	public void validarSinDescuentoPorEdad() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,18,20);//tarifa,dias,edad
		Assert.assertTrue(ans==200000);
	}
	
	@Test
	public void validarSinDescuentoPorEdadMenorA65() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,18,63);//tarifa,dias,edad
		Assert.assertTrue(ans==200000);
	}
	
	@Test
	public void validarSinDescuentoPorEdad65() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,18,65);//tarifa,dias,edad
		Assert.assertTrue(ans==200000);
	}
	
	@Test
	public void validarDescuentoPorEdadMayor() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,18,67);//tarifa,dias,edad
		Assert.assertTrue(ans==184000);
	}
	
	@Test
	public void validarDescuentoPorEdadMenorYDias() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,23,16);//tarifa,dias,edad
		Assert.assertTrue(ans==160000);
	}
	
	@Test
	public void validarDescuentoPorEdadMayorYDias() {
		CalculadorDescuentos test=new CalculadorDescuentos();
		double ans=test.calculoTarifa(200000,23,70);//tarifa,dias,edad
		Assert.assertTrue(ans==154000);
	}
}
