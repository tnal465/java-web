import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws IOException {
		URL url
		=new URL("https://jsonplaceholder.typicode.com/users");
		InputStream in=url.openStream();
		int d=0;
		String buf="";
		while((d=in.read())!=-1) {
			//System.out.print((char)d);
			buf+=(char)d;
		}
		//System.out.println(buf);
		buf=buf.trim();
		
		//Q.buf에 들어 있는 파일은 [{ },{ },...]형태의 배열로 된 문자열이다.
		//이 배열 리스트 문자열로 변환이 가능
		//또는 객체 리스트로 변환이 가능하다.
		//사전작업 []문자열을 제거
		buf=buf.substring(1).trim();
		buf=buf.substring(0, buf.length()-1).trim();
		//whitespacee제거
		//buf=buf.trim();
		//System.out.println(buf);
		// buf.split("},{"); ->문제점 },공백 줄바꿈 공백 {
		buf = buf.replaceAll("},\\s*", "},");
		//System.out.println(buf);
		
		//String[] alist=buf.split("},{"); //->오류발생
		String[] alist=buf.split("\\},\\{");
		
		for(String s:alist) {
			//System.out.println(s);
			//System.out.println("--------------------");
		}
		
		//공백제거
		for(int i=0;i<alist.length;i++) {
			alist[i]=alist[i].trim();
			System.out.println(alist[i]);
			System.out.println("--------------------");
		}
		
		//첫번째 json은 마지막 문자에 }가 없음
		//두번째부터 마지막 전까지 ? 시작시 {가 없음, 마지막 문자에 }가 없음
		//마지막 json ? 시작시 {가 없음
		
		//뒤에서 사라진 문자 }를 추가하기
		for(int i=0;i<alist.length;i++) {
			if(i==0) {
				alist[i]+="}";
			}else if(i==alist.length-1) {
				alist[i]="{"+alist[i];
			}else {
				alist[i]="{"+alist[i];
				alist[i]+="}";
			}
		}
		
		//alist[0]문자열을 객체화 시키시오.
		ObjectMapper mapper=new ObjectMapper();
		
		//위의 문자열 데이터를 1)문자열 리스트로 변환하세요.
		List<String> list=new ArrayList<String>();
		
		//2){ }를 객체로 변환-User객체를 생성
		
	}

}
