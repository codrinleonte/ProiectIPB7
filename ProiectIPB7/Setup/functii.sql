CREATE OR REPLACE FUNCTION login(  name VARCHAR2 , hashparola VARCHAR2 ) return INTEGER AS

  aparitii_username Integer :=0;
  aparitii_username_hashparola Integer:=0;
  activat Integer := 0;
  
BEGIN
  
  SELECT COUNT(ID) into aparitii_username FROM  CONTURI WHERE CONTURI.username = name;
  IF aparitii_username = 0 THEN return -1;
  ELSE
    SELECT COUNT(ID) into aparitii_username_hashparola FROM  CONTURI WHERE CONTURI.username = name AND CONTURI.parola = hashparola;
    IF aparitii_username_hashparola = 0 THEN return -2;
    ELSE
        SELECT CONTURI.status into activat FROM  CONTURI WHERE CONTURI.username = name AND CONTURI.parola = hashparola;
        IF activat = 0 THEN return -3;
        ELSE
            return 0;
        END IF;
    END IF;
  END IF;
  
END;

CREATE OR REPLACE FUNCTION verificare ( hashcod VARCHAR2 ) return INTEGER AS
  aparitii Integer := 0;
BEGIN
  
  SELECT COUNT(ID) into aparitii FROM CONTURI WHERE CONTURI.COD_ACTIVARE = hashcod;
  IF aparitii = 0 then return -1;
  ELSE
    UPDATE CONTURI SET STATUS = 1 WHERE CONTURI.COD_ACTIVARE = hashcod;
    return 0;
  END IF;
 
END; 

CREATE OR REPLACE FUNCTION inregistrare_stud( user VARCHAR2 , hashparola VARCHAR2 , hashcod VARCHAR2 ) return INTEGER AS
  aparitii INTEGER := 0;
  sesiune_curenta INTEGER :=1 ;
  prenume VARCHAR2(50);
  nume VARCHAR2(50);
BEGIN
  SELECT COUNT(ID) INTO aparitii FROM CONTURI WHERE CONTURI.username = user;
  SELECT SUBSTR( user, 1, INSTR( user , '.' ) -1)  into prenume from dual;
  SELECT SUBSTR( user, INSTR(user,'.')+1,50) into nume from dual;
  IF aparitii > 0 THEN return -2;
  ELSE 
    SELECT MAX(ID) into sesiune_curenta FROM SESIUNI;
    INSERT ALL
    INTO CONTURI( ID,USERNAME,PAROLA,EMAIL,TIP_UTILIZATOR,STATUS,COD_ACTIVARE )
      VALUES ( CONTURI_SEQ.NEXTVAL, user, hashparola, user||'@info.uaic.ro', 'Student', 0, hashcod)
    INTO STUDENTI( ID ,ID_CONT, NUME, PRENUME, ID_SESIUNE ) 
      VALUES( STUDENTI_SEQ.NEXTVAL,CONTURI_SEQ.CURRVAL, prenume, nume, sesiune_curenta ) SELECT DUMMY  FROM DUAL;
  END IF;
  return 0;
END;

CREATE OR REPLACE FUNCTION inregistrare_profe( user VARCHAR2 , hashparola VARCHAR2 ) return INTEGER AS
  aparitii INTEGER := 0;
BEGIN

END;