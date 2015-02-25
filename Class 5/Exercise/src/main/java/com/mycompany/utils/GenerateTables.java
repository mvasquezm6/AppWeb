
package com.mycompany.utils;

/**
 *
 * @author HAMP
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GenerateTables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("cruddvd");

	}

}