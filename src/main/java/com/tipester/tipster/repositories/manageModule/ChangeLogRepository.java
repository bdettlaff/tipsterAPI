package com.tipester.tipster.repositories.manageModule;

import com.tipester.tipster.entities.manageModule.ChangeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeLogRepository extends JpaRepository<ChangeLog,Long> {
}
