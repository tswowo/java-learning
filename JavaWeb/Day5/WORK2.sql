CREATE TABLE clazz
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(30) NOT NULL UNIQUE,
    room          VARCHAR(20),
    begin_date    DATE,
    end_date      DATE,
    class_teacher INT COMMENT '班主任ID',
    subject       INT COMMENT '课程ID',
    status        TINYINT COMMENT '状态, 1:正常, 2:停用',
    update_time   DATETIME COMMENT '更新时间'
);

CREATE TABLE dept
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(10) NOT NULL,
    update_time DATETIME
);