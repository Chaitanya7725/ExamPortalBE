//package com.exam.crud.example.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.exam.crud.example.entity.Section;
//import com.exam.crud.example.respository.SectionRepository;
//
//@Service
//public class SectionService {
//
//	@Autowired
//	private SectionRepository repo;
//	
//	//Save methods
//	public Section SaveSection(Section section) {
//		return repo.save(section);
//	}
//	
//	public List<Section> SaveSections(List<Section> section) {
//		return repo.saveAll(section);
//	}
//	
//	//get
//	public Section getSection(Integer id) {
//		return repo.findById(id).orElse(null);
//	}
//	
//	public List<Section> getSection(){
//		return repo.findAll();
//	}
//	
//	//update
//	public Section updateSection(Section section) {
//		Section existingSection=repo.findById(section.getId()).orElse(null);
//		existingSection=section;
//		return repo.save(existingSection);
//	}
//	
//	//delete
//	public void deleteSection(Integer id) {
//		repo.deleteById(id);
//	}
//	
//}
