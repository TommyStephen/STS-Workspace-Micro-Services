package study.DTO;

import java.time.LocalDate;

public class ChildDTO {
    private long id;
    private String name;
    private LocalDate dob;
    private long salary;
	public ChildDTO() {
		super();
	}
	public ChildDTO(long id, String name, LocalDate dob, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}

    
}
