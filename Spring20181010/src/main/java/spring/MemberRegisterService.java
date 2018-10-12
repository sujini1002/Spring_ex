package spring;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberRegisterService {
	@Autowired(required=false)
	@Qualifier("select")
	Dao memberDao; //타입을 찾고 같은 것이 있으면 qualifier를 찾고 없음면 이름이 같은 것을 찾는다.(그래서 memberDao가 인식 되었음)
	/*private MemberDao memberDao; //new MemberDao()는 의존성이 높음

	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/
	
	//프로퍼티 방식에 필요한 생성자
	public MemberRegisterService() {}
	/*public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/
	public void regist(RegisterRequest req) throws AlreadyExistingMemberException{
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}
}
