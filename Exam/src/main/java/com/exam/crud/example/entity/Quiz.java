//package com.exam.crud.example.entity;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Quiz {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String name;
//	private int time;
//	private String description;
//	private int threshold;
//	@OneToMany(targetEntity = Section.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="quiz_id",referencedColumnName = "id")
//	private List<Section> Section;
//	
//}
