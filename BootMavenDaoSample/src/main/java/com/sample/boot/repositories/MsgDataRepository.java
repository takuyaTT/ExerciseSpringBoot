package com.sample.boot.repositories;
import com.sample.boot.MsgData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgDataRepository extends JpaRepository<MsgData,Long> {
}