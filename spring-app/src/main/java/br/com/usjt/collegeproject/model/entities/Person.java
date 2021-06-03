package br.com.usjt.collegeproject.model.entities;

import java.sql.Date;

import javax.persistence.Embedded;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Person {

	@NotBlank(message = "O nome não deve ser vazio!")
	private String name;

	@Positive(message = "A idade deve ser maior que 0!")
	private int age;

	@Size(min = 11, max = 11, message = "O telefone é inválido!")
	private String phone;
	
	@NotBlank(message = "O sexo não deve ser vazio!")
	private String sex;
	
	@NotBlank(message = "O nascimento não deve ser vazio!")
	private Date birthday;

	@Email(message = "O e-mail é inválido!")
	private String email;

	@Size(min = 11, max = 11, message = "O cpf é inválido!")
	private String cpf;

	@NotBlank(message = "O endereço não deve ser vazio!")
	private String address;

	@Positive(message = "O número deve ser maior que 0!")
	private int number;

	@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres!")
	private String password;

	@Embedded
	private Professional professional;

	@Embedded
	private Patient patient;

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
