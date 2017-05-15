CREATE OR REPLACE FUNCTION get_type ( usernameV VARCHAR2 ) return INTEGER AS
  aparitii INTEGER := 0;
  tip VARCHAR2(30);
  functie VARCHAR2(30);
BEGIN

  SELECT TIP_UTILIZATOR INTO tip FROM CONTURI WHERE CONTURI.USERNAME = usernameV;
  
  IF tip = 'Admin'  THEN return 0;
  ELSIF tip = 'Student' THEN return 1;
  ELSE
    BEGIN
    SELECT functie_comisie into functie FROM PROFESORI p join CONTURI c on p.id_cont = c.id where c.username=usernameV;
    EXCEPTION WHEN OTHERS THEN
      return 2;
    END;
    IF functie = 'Secretar' THEN return 3;
    ELSE return 2;
    END IF;
  END IF;
END;

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
  
  SELECT SUBSTR( user, INSTR(user,'.')+1,50) into nume from dual;
  SELECT REPLACE( user , '.'||nume , '' ) into prenume from dual;
  
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

CREATE OR REPLACE FUNCTION inregistrare_prof( user VARCHAR2 , hashparola VARCHAR2 ) return INTEGER AS
  aparitii_conturi INTEGER := 0;
  aparitii_profesori INTEGER :=0;
  prenumeV VARCHAR(50);
  numeV VARCHAR(50);
BEGIN
  
  SELECT COUNT (ID) into aparitii_conturi FROM CONTURI WHERE CONTURI.username = user;
  IF aparitii_conturi > 0 THEN return -2; END IF;

  SELECT SUBSTR( user, INSTR(user,'.')+1,50) into numeV from dual;
  SELECT REPLACE ( user, '.'||numeV, '') into prenumeV from dual;
 
  SELECT COUNT (ID) into aparitii_profesori FROM PROFESORI WHERE PROFESORI.prenume = UPPER(prenumeV) and PROFESORI.nume = UPPER(numeV);
  IF aparitii_profesori <1 THEN return -1; END IF;
  
  INSERT INTO CONTURI( ID , USERNAME , PAROLA , EMAIL, TIP_UTILIZATOR, STATUS, COD_ACTIVARE ) 
    VALUES( CONTURI_SEQ.NEXTVAL, user, hashparola, user||'@info.uaic.ro', 'Profesor', 1 ,'0');
  
  return 0;
END;