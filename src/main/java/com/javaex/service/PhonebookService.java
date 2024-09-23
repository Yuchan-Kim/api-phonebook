package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	/* 전화번호등록 */
	public int exeWritePerson(PersonVo personVo) {
		System.out.println("PhonebookService.exeWritePerson()");
		
		int count = phonebookDao.insertPerson(personVo);
		
		return count;
	}
	
	
	
	/* 전화번호 전체 가져오기 */
	public List<PersonVo> exeGetPersonList(){
		System.out.println("PhonebookService.exeGetPerson()");
		
		List<PersonVo> personList = phonebookDao.getPersonList();
		
		return personList;
	}
	
	
	/* 삭제 */
	public int exePersonDelete(int no) {
		System.out.println("PhonebookService.exePersonDelete()");
		
		int count = phonebookDao.deletePerson(no);
		
		return count;
	}
	
	
	/* 수정폼 */
	public PersonVo exeEditForm(int no) {
		System.out.println("PhonebookService.exeEditForm()");
		
		PersonVo personVo = phonebookDao.getPersonOne(no);
		
		return personVo;
	}
	
	
	/* 수정폼2 db에서 Map으로 데이터 보내줌 */
	public Map<String, Object> exeEditForm2(int no){
		System.out.println("PhonebookService.exeEditForm2()");
		
		Map<String, Object> personMap = phonebookDao.getPersonOne2(no);
		return personMap;
	}
	
	
	
	/* 수정 */
	public int exeEditPerson(PersonVo personVo) {
		System.out.println("PhonebookService.exeEdit()");
		
		int count = phonebookDao.updatePerson(personVo);
		
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
