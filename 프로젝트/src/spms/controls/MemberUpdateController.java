package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MemberDao;
import spms.vo.Member;

@Component("/member/update.do")
public class MemberUpdateController implements Controller, DataBinding {
	
	MemberDao memberDao = null;
	
	public MemberUpdateController setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Member member = (Member)model.get("member");
		String id = (String)model.get("id");
		
			memberDao.update(member);
			return "redirect:mypage.do?id="+id;
		
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"id", String.class,
			"member", spms.vo.Member.class
		};
	}

}












