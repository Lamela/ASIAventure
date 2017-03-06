package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;

/**
  *The class <code>ASIAventureException</code> and its subclasses are a form of <code>Exception</code> that indicates conditions that a reasonable application might want to catch.
  *<p>
  *The class <code>ASIAventureException</code> and any subclasses that are not also subclasses of <code>RuntimeException</code> are checked exceptions. Checked exceptions need to be declared in method or constructor's <code>throws</code> clause if they can be thrown by the execution of the method or constructor and propagate outside the method or constructor boundary.
  *
  *@author Lu Chenxin
  */
public class ASIAventureException extends java.lang.Exception {
	/**
	  *Constructs a new exception of ASIAventure with null as its detail message.
	  */
	public ASIAventureException(){
	}
	/**
	  *Constructs a new exception of ASIAventure with the specified detail message.
	  */
	public ASIAventureException(String msg){
		super(msg);
	}
}
