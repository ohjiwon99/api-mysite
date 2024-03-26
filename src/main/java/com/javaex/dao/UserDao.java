package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;


	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");

		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		return authUser;
	}
	//no로 한명데이터 가져오기(회원정보수정폼)
	//조회no(회원정보수정 폼)
	public UserVo userSelectOneByNo(int no) {
		System.out.println("UserDao.userSelectOneByNo()");
		
		UserVo userVo = sqlSession.selectOne("user.selectOneByNo", no);
		return userVo;
	}
	//수정(회원정보수정)
		public int userUpdate(UserVo userVo) {
			System.out.println("UserDao.userUpdate()");
			
			int count = sqlSession.update("user.update", userVo);
			return count;
		}
}
