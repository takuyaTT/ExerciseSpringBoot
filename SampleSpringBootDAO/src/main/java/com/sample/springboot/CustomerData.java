package com.sample.springboot;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
public class CustomerData {

    //顧客ID
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //顧客名
    @Column(length = 50, nullable = false)
    @Setter
    private String name;

    //年齢
    @Column(nullable = true)
    @Setter
    private Integer age;

    //メールアドレス
    @Column(length = 200, nullable = true)
    @Setter
    private String email;

    //性別
    @Column(nullable = true)
    @Setter
    private String gender;

    //コメント
    @Column(nullable = true)
    @Setter
    private String comment;
}
