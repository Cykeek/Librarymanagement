SET PAGESIZE 50
SET LINESIZE 200
SET HEADING ON
SET FEEDBACK OFF

CREATE TABLE books (
    book_id int PRIMARY KEY NOT NULL, 
    name varchar2(20),
    instock varchar2(20),
    total varchar2(20)
);

CREATE TABLE issuedbooks (
    id int PRIMARY KEY NOT NULL, 
    studentname varchar2(20),
    sid varchar2(20),
    booktags varchar2(20),
    issueddate date default sysdate,
    returndate varchar2(20),
    returnedon varchar2(20)
);

CREATE SEQUENCE book_id_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE issue_id_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;


CREATE OR REPLACE TRIGGER before_insert_books
BEFORE INSERT ON books
FOR EACH ROW
BEGIN:NEW.book_id := book_id_seq.NEXTVAL;
END;
/

CREATE OR REPLACE TRIGGER before_insert_issuedbooks
BEFORE INSERT ON issuedbooks
FOR EACH ROW
BEGIN:NEW.id := issue_id_seq.NEXTVAL;
END;
/

CREATE TABLE admin (
    id int PRIMARY KEY NOT NULL, 
    username varchar2(20),
    email varchar2(20),
    password varchar2(20)
);

EXIT;