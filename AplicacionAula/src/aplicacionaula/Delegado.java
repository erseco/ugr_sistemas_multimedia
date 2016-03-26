/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionaula;

/**
 *
 * @author ernesto
 */
public class Delegado extends Alumno {
    
     // Metodos:
  public Delegado(String nom){      // Constructor 1
    super(nom); // Llamada explicita al constructor de la superclase
    curso = numAsignaturas = 1;
  }
 
  public String toString(){ // Devuelve una cadena representativa del profesor
    return("Me llamo "+ nombre + " y soy delegado" );
  }
  
}
