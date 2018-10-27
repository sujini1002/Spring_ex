package com.bit.lib.system.dao;

import com.bit.lib.system.model.Borrow;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public String getBook_code(String bookname){

        return sqlSessionTemplate.selectOne(mapperPath+".getBook_code","%"+bookname+"%");
    }

}
