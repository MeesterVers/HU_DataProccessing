------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Opdracht 1
opdracht 8.1
SELECT CURSUSSEN.CODE, UITVOERINGEN.BEGINDATUM, CURSUSSEN.LENGTE, MEDEWERKERS.NAAM FROM UITVOERINGEN
INNER JOIN CURSUSSEN
ON UITVOERINGEN.CURSUS = CURSUSSEN.CODE
INNER JOIN MEDEWERKERS
ON MEDEWERKERS.MNR = UITVOERINGEN.DOCENT;

opdracht 8.2
select cursist, docent from

(select distinct m.naam cursist, i.CURSUS opleiding from MEDEWERKERS m 
inner join INSCHRIJVINGEN i 
on m.MNR = i.CURSIST 
where i.cursus = 'S02')

inner join

(select distinct d.naam docent, u.CURSUS cursus from Medewerkers d 
inner join uitvoeringen u 
on d.mnr = u.docent where u.cursus = 'S02')

on opleiding = cursus;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Opdracht 2
SELECT MEDEWERKERS.NAAM FROM AFDELINGEN
INNER JOIN MEDEWERKERS
ON AFDELINGEN.HOOFD = MEDEWERKERS.MNR;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Opdracht 3
SELECT AFDELINGEN.NAAM, AFDELINGEN.LOCATIE 
FROM MEDEWERKERS
INNER JOIN AFDELINGEN
ON MEDEWERKERS.AFD = AFDELINGEN.ANR;

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
opdracht 4
SELECT MEDEWERKERS.NAAM FROM INSCHRIJVINGEN
INNER JOIN MEDEWERKERS
ON INSCHRIJVINGEN.CURSIST = MEDEWERKERS.MNR
WHERE INSCHRIJVINGEN.CURSUS = 'S02' AND INSCHRIJVINGEN.BEGINDATUM = '12-APR-99';
----------------------------------------------------
SELECT m.naam, s.toelage FROM MEDEWERKERS m, SCHALEN s
where m.MAANDSAL > s.ONDERGRENS and m.MAANDSAL < s.BOVENGRENS



