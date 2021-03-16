package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

@Component("/member/mypage.do")
public class MemberListController implements Controller, DataBinding {
	/* DI(Dependency Injection)으로 변경한 이유
	 * 1) 클래스간의 의존성을 낮추기 위해
	 * 2) MemberDao 인터페이스를 선언하고 상속구현함으로써 
	 *    다른 DBMS로의 전환을 용이하게 하려고
	 * 3) 나중에 변경할 자동화 작업에 사용하려고
	 * */
	
	MemberDao memberDao = null;
	
	public MemberListController setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String id = (String)model.get("id");
		
			model.put("member", memberDao.selectOne(id));
			return "/member/MyPage.jsp";
		
			
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"id", String.class,
			"member", spms.vo.Member.class
		};
	}

}
