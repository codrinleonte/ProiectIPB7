INSERT INTO CONTURI  VALUES(1,'Admin','Root','Admin','Admin',1);
INSERT INTO CONTURI  VALUES(2,'jimmy.jimmy','jimmy','jimmy.jimmy@info.uaic.ro','Student',1);
INSERT INTO CONTURI  VALUES(3,'grigory.grigory','grigory','grigory.grygory@info.uaic.ro','Student',0);

INSERT INTO STUDENTI VALUES(1,2,'nr_matricol_jimmy','jimmy','jimmy','2018');
INSERT INTO STUDENTI VALUES(2,3,'nr_matricol_grigory','grigory','grigory','2018');

INSERT INTO COMISII VALUES(1,1,2,3,4,1,'licenta',1);
INSERT INTO COMISII VALUES(2,1,2,3,4,1,'dizertatie',1);

INSERT INTO SESIUNI VALUES(1,TO_DATE( '01-01-2018','dd-mm-yyyy'),TO_DATE( '01-02-2018','dd-mm-yyyy'));

INSERT INTO INTERVAL_EVALUARE VALUES(1,1,1,TO_DATE( '01-01-2018','dd-mm-yyyy'),TO_DATE( '03-01-2018','dd-mm-yyyy'));
INSERT INTO INTERVAL_EVALUARE VALUES(2,1,2,TO_DATE( '01-01-2018','dd-mm-yyyy'),TO_DATE( '03-01-2018','dd-mm-yyyy'));

INSERT INTO MESAJE VALUES(1,2,3,'hey Grigory, sunt eu Jimmy');
INSERT INTO MESAJE VALUES(2,3,2,'Go home Jimmy');

INSERT INTO LICENTE VALUES(1,1,1,1);
INSERT INTO LICENTE VALUES(2,1,2,1);

INSERT INTO DETALII_LICENTE VALUES(1,'Licenta lui Jimmy','https://www.google.ro/search?q=jimmy',1,5,5,5,5,5,5,5,5,5,5,5,TO_DATE( '01-01-2018','dd-mm-yyyy'),'12:00-12:20');
INSERT INTO DETALII_LICENTE VALUES(2,'Licenta lui Grigory','https://www.google.ro/search?q=grigory',1,5,5,5,5,5,5,5,5,5,5,5,TO_DATE( '01-01-2018','dd-mm-yyyy'),'12:30-12:50');
