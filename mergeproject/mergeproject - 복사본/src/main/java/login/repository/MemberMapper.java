package login.repository;

import login.model.Member;

public interface MemberMapper {
	public Member selectMemberByUsername(String username);
}
