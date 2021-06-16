package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Member;

public class LoginDAO extends DAO {
	public Member search(String member_no, String password)
			throws Exception {
		Member member = null;

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select*from members where member_no=? and password=?");
		st.setString(1, member_no);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			member = new Member();

			member.setMember_id(rs.getString("member_no"));
			member.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return member;
	}

}
