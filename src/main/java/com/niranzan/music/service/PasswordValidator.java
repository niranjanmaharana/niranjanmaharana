/**
 * 
 */
package com.niranzan.music.service;

/**
 * @author Niranjan
 *
 */
public interface PasswordValidator {
	/**
	 * @param password
	 * @return
	 */
	boolean isValid(String password);
}