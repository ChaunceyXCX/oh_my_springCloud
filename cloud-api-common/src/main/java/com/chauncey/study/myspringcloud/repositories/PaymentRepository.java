package com.chauncey.study.myspringcloud.repositories;

import com.chauncey.study.myspringcloud.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @ClassName BuildTestDao
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/5/17 16:42
 * @Version 1.0
 **/
public interface PaymentRepository extends JpaRepository<Payment,Long>, Serializable {
}
