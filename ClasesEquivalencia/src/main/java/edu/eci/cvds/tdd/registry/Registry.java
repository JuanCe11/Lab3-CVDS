package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
	private ArrayList<Person> registrados;
	
    public RegisterResult registerVoter(Person p) {
    	RegisterResult resultado  = RegisterResult.VALID;
        resultado = validarVivo(p);
        if(resultado == RegisterResult.VALID) resultado = validarNacimiento(p);
        if(resultado == RegisterResult.VALID) resultado = validarPosibilidadVotarEdad(p);
        if(resultado== RegisterResult.VALID) resultado = validarID(p);
        if(resultado== RegisterResult.VALID) resultado = validarNombre(p);
        return resultado;
    }

	private RegisterResult validarNombre(Person p) {
		RegisterResult respuesta = RegisterResult.VALID;
		String[] nombre = p.getName().trim().split(" ");
		respuesta = (nombre.length>1)?respuesta:RegisterResult.INVALID_NAME;
		return respuesta;
	}

	private RegisterResult validarID(Person p) {
		RegisterResult respuesta = RegisterResult.VALID;
		respuesta = (p.getId() > 0)?respuesta:RegisterResult.INVALID_ID;
		return respuesta;
	}

	private RegisterResult validarPosibilidadVotarEdad(Person p) {
		RegisterResult respuesta = RegisterResult.VALID;
		respuesta = (p.getAge() > 0 && p.getAge() <= 17)?RegisterResult.UNDERAGE:respuesta;
		return respuesta;
	}
	
	private RegisterResult validarNacimiento(Person p) {
		RegisterResult respuesta = RegisterResult.VALID;
		respuesta = (p.getAge() < 1)?RegisterResult.INVALID_AGE:respuesta;
		return respuesta;
	}

	private RegisterResult validarVivo(Person p) {
		RegisterResult respuesta = RegisterResult.VALID;
		respuesta = (!p.isAlive())?RegisterResult.DEAD:respuesta;
		return respuesta;
	}
}