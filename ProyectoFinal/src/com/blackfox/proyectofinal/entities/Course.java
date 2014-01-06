/**
 * 
 */
package com.blackfox.proyectofinal.entities;

import java.util.List;

/**
 * @author Emmanuel
 *
 */
public class Course {
	private String name;
	private String description;
	private String image;
	private int enrolled;
	private List<Student> students;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the enrolled
	 */
	public int getEnrolled() {
		return enrolled;
	}
	/**
	 * @param enrolled the enrolled to set
	 */
	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}
	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
