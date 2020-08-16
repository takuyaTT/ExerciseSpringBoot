package com.sample.boot;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
/*
@NamedQuery(
		name = "findWithName",
		query = "from CustomerData where name like :fname"
)
 */
@Getter
@Setter
public class CustomerData {
	@OneToMany(cascade = CascadeType.ALL)
	@Column(nullable = true)
	private List<MsgData> msgdatas;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 200, nullable = true)
	private String mail;

	@Column(nullable = true)
	private Integer age;

	@Column(length = 5, nullable = true)
	private String gender;

	@Column(nullable = true)
	private String memo;
	
}
