-- 코드를 입력하세요
SELECT a.flavor
from FIRST_HALF a Join ICECREAM_Info b on a.Flavor = b.flavor
where a.TOTAL_ORDER > 3000 and b.INGREDIENT_TYPE = 'fruit_based'
order by a.TOTAL_ORDER desc;