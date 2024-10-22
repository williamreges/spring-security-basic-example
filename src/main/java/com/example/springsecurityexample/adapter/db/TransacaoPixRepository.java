package com.example.springsecurityexample.adapter.db;

import com.example.springsecurityexample.adapter.db.entity.TransacaoPix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransacaoPixRepository extends JpaRepository<TransacaoPix, String>, JpaSpecificationExecutor<TransacaoPix> {

}