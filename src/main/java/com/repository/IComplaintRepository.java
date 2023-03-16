package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;

@Repository
public interface IComplaintRepository extends JpaRepository<Complaint, Integer> {

	@Query("Select c from Complaint c where c.clientId=?1")
	List<Complaint> getClientAllComplaints(String clientId);

	@Query("Select c from Complaint c where c.clientId=?1 and c.status=?2")
	List<Complaint> getClientAllOpenComplaints(String clientId, String status);

	@Query("Select c from Complaint c order by c.productModelNumber")
	public List<Complaint> getComplaintsByProducts(String productModelNumber);

	@Query("Select c from Complaint c where c.status=?1 ")
	List<Complaint> getComplaints(String status);
	

//@Query(value = "SELECT * FROM Complaint WHERE status='open'", nativeQuery = true)
//List<Complaint> getAllOpenComplaints2();

	@Query(value = "SELECT * FROM Complaint where status='resolved'", nativeQuery = true)
	List<Complaint> getResolvedComplaints();

	@Query(value = "SELECT * FROM Complaint c WHERE status='open' and engineer_Id=?1", nativeQuery = true)
	List<Complaint> getAllOpenComplaints1(int engineerId);

	@Query(value = "SELECT * FROM Complaint where status='resolved' and engineer_Id=?1", nativeQuery = true)
	List<Complaint> getResolvedComplaints1(int engineerId);

	@Query(value = "SELECT * FROM Complaint where engineer_Id=?1", nativeQuery = true)
	List<Complaint> findAllComplaints(int engineerId);
	@Query(value="SELECT * FROM Complaint where engineer_Id=?1", nativeQuery=true)
	List<Complaint> getComplaints1(int engineerId);
}
