select CONCAT((MONTH(Differentiation_date) - 1) DIV 3 + 1, 'Q') AS Quarter, count(*) as ECOLI_COUNT
from ECOLI_DATA
group by Quarter;