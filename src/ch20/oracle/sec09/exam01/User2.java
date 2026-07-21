package ch20.oracle.sec09.exam01;

import java.util.Objects;

import lombok.Builder;
import lombok.Data;
	
@Data //Constructor, Getter, Setter, hashCode(), equals(), toString() 자동 생성

@Builder
public class User2 {
	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User2 other = (User2) obj;
		return Objects.equals(userId, other.userId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}
	
	
}