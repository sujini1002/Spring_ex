package com.openproject.openproject.dao;

import java.util.List;

import com.openproject.openproject.model.MemberInfo;

public interface MemberDaoInterface {
    public MemberInfo getMemberInfo(String id);
    public int insertMemberInfo(MemberInfo memberInfo);
    public List<MemberInfo> selectByList();
    public int updateMember(MemberInfo memberInfo);
    public int deleteMember(String id);
}
