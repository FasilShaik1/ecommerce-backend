package com.onlinebuysell.OnlinebuyProject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebuysell.OnlinebuyProject.Entity.Admins;

@Repository
public interface AdminRepository extends JpaRepository<Admins, Long> {
   
}
