package ch07;

import java.sql.Date;
import java.util.Objects;
import java.lang.String;

public class Member {
	// uid, pwd, 이름, 생년월일, email, 성별, 취미
	private String uid;
	private String pwd;
	private String uname;
	private Date birth;
	private String email;
	private String gender;
	private String hobby;
	
	// 기본 생성자
	Member () {}

	// 모든 회원 정보를 매개변수로 갖는 생성자
	Member(String uid, String pwd, String uname, Date birth, String email, String gender, String hobby) {
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.hobby = hobby;
	}

	@Override
	// toString() Method
	public String toString() {
		return "MemberVO [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", birth=" + birth + ", email=" + email
				+ ", gender=" + gender + ", hobby=" + hobby + "]";
	}

	@Override
	// hashCode() Method
	public int hashCode() {
		return Objects.hash(birth, email, gender, hobby, pwd, uid, uname);
	}

	@Override
	// equals() Method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(birth, other.birth) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(hobby, other.hobby)
				&& Objects.equals(pwd, other.pwd) && Objects.equals(uid, other.uid)
				&& Objects.equals(uname, other.uname);
	}

	// Getter, Setter Method
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
