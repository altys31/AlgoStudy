-- 코드를 작성해주세요
select a.DEPT_ID, DEPT_NAME_EN, round(avg(SAL),0) as AVG_SAL
from HR_DEPARTMENT a JOIN HR_EMPLOYEES b ON a.DEPT_ID = B.DEPT_ID
group by DEPT_ID
order by AVG_SAL desc;