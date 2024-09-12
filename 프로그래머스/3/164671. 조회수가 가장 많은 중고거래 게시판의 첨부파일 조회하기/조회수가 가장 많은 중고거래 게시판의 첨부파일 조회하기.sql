-- 코드를 입력하세요
SELECT concat('/home/grep/src/',a.Board_ID,"/",FILE_ID,FILE_NAME,FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD as a
inner join USED_GOODS_FILE as b
on a.BOARD_ID = b.BOARD_ID
where a.VIEWS = (select views from USED_GOODs_BOARD order by Views desc limit 1)
order by FILE_ID desc;

