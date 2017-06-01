INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'ionescu.mircea','parola','ionescu.mircea@info.uaic.ro','Student',1,'blabla','token1');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'polonescu.mia','parola','polonescu.mia@info.uaic.ro','Student',1,'blabla','token2');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'agapei.ioana','parola','agapei.ioana@info.uaic.ro','Student',1,'blabla','token3');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'stanescu.mihai','parola','stanescu.mihai@info.uaic.ro','Student',1,'blabla','token4');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'mardare.radu','parola','mardare.radu@info.uaic.ro','Student',1,'blabla','token5');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'lupu.irina','parola','lupu.irina@info.uaic.ro','Student',1,'blabla','token6');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'lupascu.mioara','parola','lupascu.mioara@info.uaic.ro','Student',1,'blabla','token7');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'cristea.irina','parola','cristea.irina@info.uaic.ro','Student',1,'blabla','token8');

INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,2,'sv3456781','Ionescu','Mirecea',1,1);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,3,'sv3456782','Polonescu','Mia',1,1);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,4,'sv3456783','Agapei','Ioana',1,2);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,5,'sv3456784','Stanescu','Mihai',1,3);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,6,'sv3456785','Mardare','Radu',1,4);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,7,'sv3456786','Lupu','Irina',1,1);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,8,'sv3456787','Lupascu','Mioara',1,3);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,9,'sv3456788','Cristea','Irina',1,4);


Update PROFESORI SET ID_COMISIE=1,FUNCTIE_COMISIE='Presedinte' where id=1;
Update PROFESORI SET ID_COMISIE=1,FUNCTIE_COMISIE='Evaluator' where id=2;
Update PROFESORI SET ID_COMISIE=1,FUNCTIE_COMISIE='Secretar' where id=3;
Update PROFESORI SET ID_COMISIE=2,FUNCTIE_COMISIE='Presedinte' where id=5;
Update PROFESORI SET ID_COMISIE=2,FUNCTIE_COMISIE='Evaluator' where id=6;
Update PROFESORI SET ID_COMISIE=2,FUNCTIE_COMISIE='Secretar' where id=7;
Update PROFESORI SET ID_COMISIE=3,FUNCTIE_COMISIE='Presedinte' where id=9;
Update PROFESORI SET ID_COMISIE=3,FUNCTIE_COMISIE='Evaluator' where id=10;
Update PROFESORI SET ID_COMISIE=3,FUNCTIE_COMISIE='Secretar' where id=11;
Update PROFESORI SET ID_COMISIE=4,FUNCTIE_COMISIE='Presedinte' where id=13;
Update PROFESORI SET ID_COMISIE=4,FUNCTIE_COMISIE='Evaluator' where id=14;
Update PROFESORI SET ID_COMISIE=4,FUNCTIE_COMISIE='Evaluator' where id=15;
Update PROFESORI SET ID_COMISIE=4,FUNCTIE_COMISIE='Secretar' where id=16;


INSERT INTO COMISII VALUES(COMISII_SEQ.NEXTVAL,1,2,3,null,3,'licenta','307');
INSERT INTO COMISII VALUES(COMISII_SEQ.NEXTVAL,5,6,7,null,7,'licenta','308');
INSERT INTO COMISII VALUES(COMISII_SEQ.NEXTVAL,9,10,11,null,11,'dizertatie','309');
INSERT INTO COMISII VALUES(COMISII_SEQ.NEXTVAL,13,14,15,16,16,'dizertatie','407');


INSERT INTO SESIUNI VALUES(SESIUNI_SEQ.NEXTVAL,TO_DATE( '01-07-2018','dd-mm-yyyy'),TO_DATE( '01-08-2018','dd-mm-yyyy'),1);

INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta1',2,1,'www.google.ro',1,'LICENTA','');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta2',5,2,'www.google.ro',1,'LICENTA','');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta3',3,3,'www.google.ro',1,'LICENTA','');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta4',1,4,'www.google.ro',1,'LICENTA','');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta5',3,5,'www.google.ro',1,'LICENTA','');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta6',6,6,'www.google.ro',1,'LICENTA','');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta7',4,7,'www.google.ro',1,'LICENTA','');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'licenta8',7,8,'www.google.ro',1,'LICENTA','');

INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,1,5,5,5,5,5,5,NULL,NULL,NULL,NULL,TO_TIMESTAMP('1-JUL-17 10:00:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,2,5,5,5,5,5,5,NULL,NULL,5,5,TO_TIMESTAMP('1-JUL-17 12:00:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,2,5,5,5,5,5,5,NULL,NULL,5,5,TO_TIMESTAMP('2-JUL-17 12:30:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,3,5,5,5,5,5,5,NULL,NULL,5,5,TO_TIMESTAMP('4-JUL-17 13:00:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,4,5,5,5,5,5,5,NULL,NULL,5,5,TO_TIMESTAMP('5-JUL-17 12:00:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,1,5,5,5,5,5,5,NULL,NULL,5,5,TO_TIMESTAMP('2-JUL-17 14:00:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,2,5,5,5,5,5,5,NULL,NULL,5,5,TO_TIMESTAMP('6-JUL-17 12:00:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,3,5,5,5,5,5,5,NULL,NULL,5,5,TO_TIMESTAMP('3-JUL-17 12:00:00','DD-Mon-RR HH24:MI:SS'));

set serveroutput on;
DECLARE
  rezultat INTEGER;
BEGIN
  rezultat:=INREGISTRARE_PROF('lenuta.alboaie','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('andreea.arusoaie','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('andrei.arusoaie','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('razvan.benchea','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('catalin.birjoveanu','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('mihaela.breaban','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('oana.captarencu','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('stefan.ciobaca','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('liviu.ciortuz','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('cornelius.croitoru','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('corina.forascu','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('cristian.frasinaru','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  rezultat:=INREGISTRARE_PROF('cristian.gatu','parola');
  DBMS_OUTPUT.PUT_LINE(rezultat);
  
END;







