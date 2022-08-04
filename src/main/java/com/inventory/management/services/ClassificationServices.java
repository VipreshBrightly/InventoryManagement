package com.inventory.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.management.dao.ClassificationRepo;
import com.inventory.management.entities.Classification;

@Component
public class ClassificationServices {
	@Autowired
	private ClassificationRepo clfRepo;
	public List<Classification> getAllClassification() {
		List<Classification>clf1=(List<Classification>)this.clfRepo.findAll();
		return clf1;
	}
	public Classification getClassificationById(int id) {
		Classification clf2=null;
		try{
		    clf2=this.clfRepo.findById(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return clf2;
	}
	public Classification addClassification(Classification clf3) {
		this.clfRepo.save(clf3);
		return clf3;
	}
	public void deleteClassification(int id) {
		clfRepo.deleteById(id);
	}
	public Classification updateClassification(Classification clf3,int id) {
		Classification clf=new Classification();
		clf.setId(clf3.getId());
		clf.setName(clf3.getName());
		clf.setDescription(clf3.getDescription());
		clf.setTag(clf3.getTag());
		this.clfRepo.save(clf);
		return clf;
	}
	
}
