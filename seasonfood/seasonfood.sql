create schema seasonfood;

CREATE TABLE User_info
(
    `User_index`      INT            NOT NULL    AUTO_INCREMENT COMMENT '유저번호', 
    `User_id`         VARCHAR(15)    NOT NULL    COMMENT '아이디', 
    `User_passwd`     VARCHAR(64)    NOT NULL    COMMENT '비밀번호', 
    `User_email`      VARCHAR(30)    NOT NULL    COMMENT '이메일', 
    `User_gender`     VARCHAR(4)        NOT NULL    COMMENT '성별', 
    `User_join_date`  DATE           NOT NULL    COMMENT '가입날짜', 
    PRIMARY KEY (User_index)
);
ALTER TABLE User_info COMMENT '유저 정보';

select * from User_info;