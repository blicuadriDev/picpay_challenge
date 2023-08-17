package com.godknows.picpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godknows.picpay.entities.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
