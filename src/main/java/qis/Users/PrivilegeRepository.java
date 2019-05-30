package qis.Users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>{
	
	@Query(value = " SELECT * from user_privilege", nativeQuery = true)
	List<Privilege> privilege();
	
	@Transactional
	@Modifying
	@Query(value = " INSERT into user_privilege(UserID, Doctor, CashierAccount, "
				 + " CashierCash, Medical, Laboratory, Imaging, QualityControl, Admin)"
				 + " VALUES(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)", nativeQuery = true)
	int addPrivilege(int uid, int doc, int ca, int cc, int med,
					 int lab, int ima, int qc, int ad);
	
	@Transactional
	@Modifying
	@Query(value = " UPDATE user_privilege SET UserID = ?1, Doctor = ?2, CashierAccount = ?3,"
				 + " CashierCash = ?4, Medical = ?5, Laboratory = ?6, Imaging = ?7,"
				 + " QualityControl = ?8, Admin = ?9 where privID = 13", nativeQuery = true)
	int updatePrivilege(int uid, int doc, int ca, int cc, int med,
			 int lab, int ima, int qc, int ad);
}