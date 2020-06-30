package com.chauncey.study.myspringcloud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName BuildTest
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/5/17 15:44
 * @Version 1.0
 **/
@Entity
@Table(name = "build_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Payment implements Serializable {

    @Id
    @NotNull(message = "id 不能为空")
    private Long id;

    @NotBlank(message = "message 不能为空")
    private String message;

}
