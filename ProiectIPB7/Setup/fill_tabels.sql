INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'jimmy.jimmy','jimmy','jimmy.jimmy@info.uaic.ro','Student',1,'fsdagfsdg','0');
INSERT INTO CONTURI  VALUES(CONTURI_SEQ.NEXTVAL,'grigory.grigory','grigory','grigory.grygory@info.uaic.ro','Student',0,'safasfasf','0');

INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,2,'nr_matricol_jimmy','jimmy','jimmy',1,1);
INSERT INTO STUDENTI VALUES(STUDENTI_SEQ.NEXTVAL,3,'nr_matricol_grigory','grigory','grigory',1,1);

INSERT INTO COMISII VALUES(COMISII_SEQ.NEXTVAL,1,2,3,4,1,'licenta',1,'307');
INSERT INTO COMISII VALUES(COMISII_SEQ.NEXTVAL,1,2,3,4,1,'dizertatie',1,'309');

INSERT INTO SESIUNI VALUES(SESIUNI_SEQ.NEXTVAL,TO_DATE( '01-01-2018','dd-mm-yyyy'),TO_DATE( '01-02-2018','dd-mm-yyyy'));

INSERT INTO MESAJE VALUES(MESAJE_SEQ.NEXTVAL,2,3,'hey Grigory, sunt eu Jimmy');
INSERT INTO MESAJE VALUES(MESAJE_SEQ.NEXTVAL,3,2,'Go home Jimmy');

INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'Licenta lui Jimmy',1,1,'https://www.google.ro/search?q=jimmy',1,'Licenta');
INSERT INTO LICENTE VALUES(LICENTE_SEQ.NEXTVAL,'Licenta lui Grigory',1,2,'https://www.google.ro/search?q=grigory',1,'Dizertatie');

INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,1,5,5,5,5,5,5,5,5,5,5,TO_TIMESTAMP('10-SEP-17 12:00:00','DD-Mon-RR HH24:MI:SS'));
INSERT INTO DETALII_LICENTE VALUES(DETALII_SEQ.NEXTVAL,1,5,5,5,5,5,5,5,5,5,5,TO_TIMESTAMP('01-01-2018 12:30:00','dd-mm-yyyy HH24:MI:SS'));
