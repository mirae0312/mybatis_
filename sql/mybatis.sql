--===========================================================
-- hello-mybatis
--===========================================================
-- student table 생성
CREATE TABLE STUDENT (
	NO NUMBER,
	NAME VARCHAR2(50) NOT NULL,
	TEL CHAR(11) NOT NULL,
	REG_DATE DATE DEFAULT SYSDATE,
	CONSTRAINT PK_STUDENT_NO PRIMARY KEY(NO)
);

CREATE SEQUENCE SEQ_STUDENT_NO;

INSERT INTO
	STUDENT(NO, NAME, TEL)
VALUES (
	SEQ_STUDENT_NO.NEXTVAL,
	'홍길동',
	'01012341234'
);

SELECT * FROM STUDENT;