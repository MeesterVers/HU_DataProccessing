-- Hoofstuk 4 
-- Opdracht 4---------------------------------------------------------------------------------------------------------------------------------
SELECT cursist
FROM   inschrijvingen
WHERE  cursus  = 'JAV'
AND    cursist in (SELECT cursist
                   FROM   inschrijvingen
                   WHERE  cursus = 'XML');

-- Opdracht 7---------------------------------------------------------------------------------------------------------------------------------
SELECT mnr
FROM medewerkers
WHERE afd !=( SELECT anr
            FROM afdelingen
            WHERE naam  = 'OPLEIDINGEN');

------------------------------------------------------------------------------------------------------------------------------------------------
-- Opdracht 8
SELECT mnr
FROM medewerkers
WHERE mnr !=( SELECT cursist
FROM inschrijvingen
WHERE cursus = 'JAV' );

--------------------------------------------------------------------------------------------------------------------------------------------------
-- Opdracht 10
SELECT naam,chef
FROM   medewerkers
WHERE  mnr in (SELECT chef
               FROM   medewerkers);

-------------------------------------------------------------------------------------------------------------------------------------------------
-- Opdracht 11
SELECT *
FROM uitvoeringen
WHERE begindatum between date '199-01-01' 
AND date '1999-12-31'
AND cursus in(
SELECT cursus
FROM cursussen
WHERE   type='ALG');

-----------------------------------------------------------------------------------------------------------------------------------------------
-- Hoofdstuk 8
-- Opdracht 4
SELECT inschrijvingen.CURSUS,inschrijvingen.BEGINDATUM, count(cursist) as aantal_inschrijvingen
FROM uitvoeringen inner join inschrijvingen 
on uitvoeringen.cursus=inschrijvingen.cursus 
group by inschrijvingen.CURSUS, inschrijvingen.BEGINDATUM
order by inschrijvingen.BEGINDATUM;

------------------------------------------------------------------------------------------------------------------------------------------------
-- Opdracht 9
SELECT distinct naam,voorl,chef
FROM medewerkers inner join inschrijvingen
on medewerkers.chef = inschrijvingen.CURSIST
inner join cursussen
on inschrijvingen.cursus=cursussen.code
inner join uitvoeringen
on medewerkers.mnr = uitvoeringen.docent
WHERE type='ALG'
;

----------------------------------------------------------------------------------------------------------------------------------------------------
-- Hoofdstuk 9
-- Opdracht 3
SELECT *
FROM medewerkers left outer join
uitvoeringen on medewerkers.mnr = uitvoeringen.docent
WHERE docent is null
;
