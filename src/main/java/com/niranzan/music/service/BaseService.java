/**
 * 
 */
package com.niranzan.music.service;

import java.util.List;

/**
 * @author Niranjan
 *
 */
public interface BaseService {
	public List<Object> getAll();
	public List<Object> findAll();
	public Object findById();
}