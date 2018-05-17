Hoofdstuk 4:
Opdracht 1:
SELECT CODE, OMSCHRIJVING FROM CURSUSSEN WHERE LENGTE = 4;

1.1
SELECT * FROM MEDEWERKERS ORDER BY FUNCTIE ASC, GBDATUM DESC;

1.2
SELECT CURSUS FROM UITVOERINGEN WHERE LOCATIE = 'UTRECHT' AND LOCATIE = 'MAASTRICHT' OR LOCATIE = 'MAASTRICHT';

1.3
SELECT NAAM,VOORL FROM MEDEWERKERS WHERE NAAM != 'JANSEN' AND VOORL != 'R';

---------------------------------------------------------------------------------------------------------------------
Opdracht 2:
INSERT INTO UITVOERINGEN (CURSUS, BEGINDATUM, DOCENT, LOCATIE) VALUES ('S02','13-MAR-18', 7369, 'LEERDAM');
----------------------------------------------------------------------------------------------------------------------
opdracht 3:
INSERT INTO MEDEWERKERS (MNR, NAAM, VOORL, FUNCTIE, CHEF, GBDATUM, MAANDSAL, AFD) VALUES 
(7981, 'Kevin', 'G', 'stagiair', 7788, '04-APR-94', 4500, 10),
(7980, 'Steve', 'D', 'stagiair', 7788, '10-APR-94', 4500, 10);
-------------------------------------------------------------------------------------------------------------------------
opdract 4:
--UPDATE SCHALEN SET SNR = 6 WHERE SNR = 5;
INSERT INTO SCHALEN (SNR, ONDERGRENS, BOVENGRENS, TOELAGE) VALUES (5, 3001, 4000, 400);
-------------------------------------------------------------------------------------------------------------------------
opdracht 5:
INSERT INTO CURSUSSEN (CODE, OMSCHRIJVING, TYPE, LENGTE) VALUES ('WAC', 'Web Application Construction', 'BLD', 4);
-
INSERT INTO UITVOERINGEN (CURSUS, BEGINDATUM, DOCENT, LOCATIE) VALUES ('WAC', '25-SEP-18', 7566, 'UTRECHT');
INSERT INTO UITVOERINGEN (CURSUS, BEGINDATUM, DOCENT, LOCATIE) VALUES ('WAC', '10-SEP-18', 7566, 'UTRECHT');
------------------------------------------------------------------------------------------------------------------------
Opdracht 6:
UPDATE MEDEWERKERS 
SET MAANDSAL = 1.055 * MAANDSAL 
WHERE FUNCTIE = 'VERKOPER';

UPDATE MEDEWERKERS 
SET MAANDSAL = 1.07 * MAANDSAL 
WHERE FUNCTIE = 'MANAGER';
-------------------------------------------------------------------------------------------------------------------------
Opdracht 7
DELETE MEDEWERKERS
WHERE NAAM = 'MARTENS'
Martens heeft enkele cursusesen uitgevoerd, zijn medeweker nummer staat als forign key in de history table.
Daarom kan het niet verwijderd worden.
------------------------------------------------------------------------------------------------------------------------
Opdracht 8
INSERT INTO MEDEWERKERS (MNR, NAAM, VOORL, FUNCTIE, CHEF, GBDATUM, MAANDSAL, AFD) 
VALUES (7982, 'Vers', 'H', 'FINANCIEN', 7839, '28-MAR-94', 9000, 10);

