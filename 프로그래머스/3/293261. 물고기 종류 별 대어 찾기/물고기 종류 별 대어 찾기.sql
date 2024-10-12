-- 코드를 작성해주세요
select a.id, b.FISH_NAME, a.LENGTH
from FISH_INFO a join FISH_NAME_INFO b on a.FISH_TYPE = b.FISH_TYPE
WHERE a.LENGTH = (select Max(length) from FISH_INFO c WHERE a.FISH_TYPE = c.FISH_TYPE AND length is not null) 
order by id asc;