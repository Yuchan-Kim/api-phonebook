package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	// 필드
	@Autowired
	private SqlSession sqlSession;
	
	
	//생성자
	//기본생성자 사용(그래서 생략)  
	
	//메소드 gs
	//필드값을 외부에서 사용하면 안됨(그래서 생략)
	
	//메소드 일반
	// DB연결 메소드
	
	
	/* 삭제 */
	public int deletePerson(int no) {
		System.out.println("PhonebookDao.deletePerson()");
		
		int count = sqlSession.delete("phonebook.delete", no);
		return count;
	}
	
	
	
	//사랑 정보 수정하기 1명
	public int updatePerson(PersonVo personVo) {
		System.out.println("PhonebookDao.updatePerson()");
		System.out.println(personVo);
		int count = sqlSession.update("phonebook.update", personVo);
		return count;
	}
	
	
	//사람 1명 정보 가져오기
	public PersonVo getPersonOne(int no) {
		System.out.println("PhonebookDao.getPersonOne()");
		
		PersonVo personVo= sqlSession.selectOne("phonebook.selectOne", no);
		
		return personVo;
	}
	
	
	//사람 1명 정보 가져오기 Map
	public Map<String, Object> getPersonOne2(int no) {
		System.out.println("PhonebookDao.getPersonOne2()");
		
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectOneMap", no);
		return personMap;
	}
	
	
	//사람정보 저장
	public int insertPerson(PersonVo personVo) {
		System.out.println("PhonebookDao.insertPerson()");
		
		//vo를 사용할때
		int count = sqlSession.insert("phonebook.insert", personVo);
		
		//가정 map 으로 사용할때
		/*
		String name ="정우성";
		String hp ="111";
		String company ="222";
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", name);
		pMap.put("hp", hp);
		pMap.put("company", company);
		
		int count = sqlSession.insert("phonebook.insert2", pMap);
		*/
		
		return count;
	}
	
	
	//리스트 가져오기
	public List<PersonVo> getPersonList() {
		System.out.println("PhonebookDao.getPersonList()");
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		
		System.out.println("==========================================");
		System.out.println(personList);
		System.out.println("==========================================");

		return personList;
	}
	
	
	
	
	
	
}
