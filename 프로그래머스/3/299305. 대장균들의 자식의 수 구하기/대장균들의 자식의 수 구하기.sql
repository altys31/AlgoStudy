select ID , (select count(*) from ECOLI_DATA b WHERE b.PARENT_ID = a.ID) as CHILD_COUNT
from ECOLI_DATA a
order by ID asc;
