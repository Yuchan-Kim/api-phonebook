package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PersonVo;

@RestController //@ResponseBody 생력 가능.
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;
	
	@GetMapping(value="/api/persons")
	public List<PersonVo> getList() {
		System.out.println("PhonebookController.getList()");
		
		List<PersonVo> personList = phonebookService.exeGetPersonList();
		System.out.println(personList);
		return personList;
	}

	@PostMapping(value="/api/persons")
	public int addPerson(@RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.addPerson()");
		
		int count = phonebookService.exeWritePerson(personVo);
		System.out.println(count);
		return count;
	}
	
	@DeleteMapping(value="/api/persons/{no}")
	public JsonResult delPerson(@PathVariable(value="no") int no) {
		System.out.println("PhonebookController.addPerson()");
		System.out.println(no);
		
		int count = phonebookService.exePersonDelete(no);
		if (count != 1) {
			return JsonResult.success(count);
		}else {
			return JsonResult.success(count);
		}
		
	}
	
	@GetMapping(value="/api/persons/{no}")
	public JsonResult getPerson(@PathVariable(value="no") int no) {
		System.out.println("Phonebookcontroller.getPerson()");
		System.out.println(no);
		
		PersonVo personVo = phonebookService.exeEditForm(no);
		
		
		if (personVo == null) {
			return JsonResult.fail("번호가 없습니다.");
		}else {
			return JsonResult.success(personVo);
		}
	}
	
	@PutMapping(value = "api/persons/{no}")
	public JsonResult updatePerson(@PathVariable(value = "no") int personId, @RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.updatePerson()");
		System.out.println(personVo); //Axios에서 data값은 화면에 놓이기 때문에 RequestBody로 가져온다.
		personVo.setPersonId(personId);
		System.out.println(personVo);
		
		int count = phonebookService.exeEditPerson(personVo);
		System.out.println(count);
		if (count == 0) {
			return JsonResult.fail("수정할 데이터가 없습니다.");
		}else {
			return JsonResult.success("수정 완료.");
		}
	}
	
}
