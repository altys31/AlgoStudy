
/*from online_sale o
join online_sale oo
on(o.user_id = oo.user_id and o.product_id = oo.product_id)
group by product_id
having count(*) >= 2
order by user_id, product_id desc*/

select user_id, product_id
from online_sale
group by user_id, product_id
having count(*) >= 2
order by user_id, product_id desc