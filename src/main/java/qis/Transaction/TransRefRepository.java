package qis.Transaction;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TransRefRepository extends JpaRepository<TransRef, Integer> {
	@Query(value = "Select * from qpd_transref", nativeQuery = true)
	List<TransRef> viewtransref();
	
	@Transactional
	@Modifying
	@Query(value = " Insert into qpd_transref(TransactionID, PatientID, XRay, BLood, Urine,"
			+ " Stool, PhysicalExam, Specimen, Ultrasound, ECG, Others)"
			+ " VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11)", nativeQuery = true)
	int addtransref(int trans, int pid, int xray, int blood, int urine, int stool, int pe,
			int speci, int usound, int ecg, int others);
	
	@Transactional
	@Modifying
	@Query(value = " UPDATE qpd_transref SET Xray = ?1, Blood = ?2, Urine = ?3, Stool = ?4,"
			+ " PhysicalExam = ?5, Specimen = ?6, Ultrasound = ?7, ECG = ?8, Others = ?9"
			+ " WHERE TransactionID = 2 ", nativeQuery = true)
	int updatetransref(int xray, int blood, int urine, int stool, int pe,
			int speci, int usound, int ecg, int others);
	
	
}