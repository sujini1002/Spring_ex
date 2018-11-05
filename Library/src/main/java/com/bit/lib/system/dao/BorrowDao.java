package com.bit.lib.system.dao;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.member.model.MemberVO;
import com.bit.lib.system.model.Borrow;
import com.bit.lib.system.model.MybookList;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BorrowDao {
 @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    private String mapperPath = "mappers.BorrowMapper";

    public int insert(Borrow borrow){
        return sqlSessionTemplate.insert(mapperPath+".insert",borrow);
    }

    public Borrow selectByBook_code(String book_code){
        return sqlSessionTemplate.selectOne(mapperPath+".selectByBook_code",book_code);
    }

    public int getDay(String returnDate){

        return sqlSessionTemplate.selectOne(mapperPath+".getDay",returnDate);
    }

    // 책 검색
    public List<BookInfo> getBook_code(String bookname){
        return sqlSessionTemplate.selectList(mapperPath+".getBook_code","%"+bookname+"%");
    }

    public void delete(Borrow borrow){
        sqlSessionTemplate.delete(mapperPath+".delete",borrow);
    }

    public void updatePossible(MemberVO member){
        sqlSessionTemplate.update(mapperPath+".updatePossible",member);
    }

    public int updateExtension(MybookList mybookList){
        return sqlSessionTemplate.update(mapperPath+".updateExtension",mybookList);
    }

    public List<MybookList> myBookList(MybookList mybookList){
        return sqlSessionTemplate.selectList(mapperPath+".myBookList",mybookList);
    }

    public int countExtension(){
        return sqlSessionTemplate.selectOne(mapperPath+".countExtension");
    }


    public void updateExtensionreturndate(MybookList mybookList) {
       sqlSessionTemplate.update(mapperPath+".updateExtensionreturndate",mybookList);
    }
}
