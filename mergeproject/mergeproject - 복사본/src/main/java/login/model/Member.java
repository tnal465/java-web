package login.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member{
    String username;
    String password;
    String email;
    String role;
    java.sql.Date regdate;
    
	public Object getRole() {
		return this.role;
	}

	public String getUsername() {
		return this.username;
	}

	public CharSequence getPassword() {
		return this.password;
	}
}
/*
drop table member;
create table member(
username varchar2(12) primary key,
password varchar2(12) not null,
email varchar2(50),
role varchar2(10) not null,
regdate date
);

insert into member 
values('user1','1234','user1@mysite.com','ROLE_USER',sysdate);

commit;

insert into member 
values('root','root','root@mysite.com','ROLE_ROOT',sysdate);

insert into member 
values('admin','admin','admin@mysite.com','ROLE_ADMIN',sysdate);

insert into member 
values('guest','guest','guest@mysite.com','ROLE_GUEST',sysdate);

*/
