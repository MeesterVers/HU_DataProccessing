-- Opdracht 1:
-- Hoofdstuk 4
-- Opdracht 6
SELECT mnr, functie, GBDATUM 
FROM MEDEWERKERS 
WHERE FUNCTIE = 'TRAINER' OR Functie = 'VERKOPER' AND GBDATUM < '1-JAN-61';
-------------------------------------------------------------------------------------------------------------------------
-- opdracht 9
SELECT * FROM MEDEWERKERS
WHERE VOORL IS NOT NULL;
---------------------------------------------------------------------------------------------------------------------------------
-- opdracht 2
-- hoofdstuk 8
-- opdracht 5
SELECT inschrijvingen.cursus,inschrijvingen.begindatum, count(cursist) 
FROM inschrijvingen
inner join uitvoeringen on inschrijvingen.cursus = uitvoeringen.cursus
GROUP BY inschrijvingen.cursist, inschrijvingen.cursus, inschrijvingen.begindatum
HAVING COUNT(cursist)>3;


SELECT medewerkers.NAAM, count(cursist) 
FROM inschrijvingen
inner join uitvoeringen on inschrijvingen.cursus = uitvoeringen.cursus
inner join medewerkers on inschrijvingen.cursist = medewerkers.mnr 
GROUP BY medewerkers.NAAM
HAVING COUNT(cursist)>1;

-----------------------------------------------------------------------------------------------------------------------------------
-- Opdracht 3
SELECT cursus,count(cursus) AS uitvoeringen
FROM uitvoeringen
GROUP BY cursus;

----------------------------------------------------------------------------------------------------------------------------------
-- opdracht 4 
SELECT (max(gbdatum) - min(gbdatum))/365,242199 
FROM medewerkers;
Of op deze manier
SELECT (TO_DATE(max(gbdatum)) - TO_DATE(min(gbdatum)))/365,242199  AS DateDiff
FROM medewerkers;

SELECT to_date(round(avg(to_number(to_char(gbdatum, 'J')))),'J')
FROM medewerkers;

--------------------------------------------------------------------------------------------------------------------------------------
-- Opdracht 5
SELECT count(naam) AS aantal_medewerkers, avg(COMM)
FROM medewerkers;

