package login.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import login.repository.MemberMapper;
import login.model.Member;

@Service
public class LoginService implements UserDetailsService{

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	//아래의 함수가 로그인을 처리해준다.
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		System.out.println("login procedure!!!!!!");
		System.out.println(username);
		// 사용자의 id를 가지고와서 db에서 해당사용자의 정보를 수집하고
		//수집된 정보와 전달받은 패스워드를 비교하여 인증여부 확인
		
		//1)db로부터 id정보를 데이터를 전달받아한다.(db설정)
		try(SqlSession sqlSession=sqlSessionFactory.openSession()){
			MemberMapper memberDao = sqlSession.getMapper(MemberMapper.class);
			Member member = memberDao.selectMemberByUsername(username);
			//uesername을 이용하여 데이터베이스 정보 전달받은 후 계정확인
			System.out.println(member);
			//나의 계정과 username, password
			//db계정정보 member.getUsername, member.getPassword
			//아래의 함수는 폼으로부터 전송한password와 db의 getPassword를 비교
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			if (member.getRole().equals("ROLE_ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else if (member.getRole().equals("ROLE_USER")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            } else if (member.getRole().equals("ROLE_GUEST")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_GUEST"));
            }
			
			//username정보, 패스워드정보, 권한정보 확인
			/*
			 * 아래의 코드는 암호화가 되어 있지 않아 처리 불가(시큐리티 기본 암호화처리)
			User user=new User(member.getUsername()
					,member.getPassword()
					,authorities);
			*/
			User user=new User(member.getUsername(), 
					new BCryptPasswordEncoder().encode(member.getPassword())
					,authorities);
			//패스워드가 일치하면 객체가 생성, 그렇지 않으면 null값 처리
			//폼에서 전송된 패스워드는 해당코드에서는 나타나지 않으며, User객체가 알아서 비교를 해준다.
			System.out.println(user);
			System.out.println(authorities);
			return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
	}

}
