
function solution(fees, records) {
    var answer = [];
    var dic = {};
    
    for(var record of records){
        var split = record.split(" ");
        var time = split[0].split(" ");
        var car = split[1];
        var action = split[2];
        
        if(!dic[car]){
            dic[car] = [];
            dic[car].push(time);
        }
        else
            dic[car].push(time);
    }
    
    for(var number of Object.keys(dic).sort()){
        
        var times = dic[number];
        var hour = -1;
        var minute = -1
        var timeResult = 0;
        
        for(let i = 0; i<times.length; i++){
            var split = times[i][0].split(":");
            
            if(hour === -1 && minute === -1){
                hour = parseInt(split[0]);
                minute = parseInt(split[1]);
            }
            else{
                timeResult += (parseInt(split[0])-hour)*60;
                timeResult += parseInt(split[1])-minute;
                hour = -1;
                minute = -1;
            }
            
            if(i === times.length-1 && hour !== -1 && minute !== -1){
                timeResult += (23-hour)*60;
                timeResult += 59-minute;
            }
        }
        if(timeResult <= fees[0]){
            answer.push(fees[1]);
        }
        
        else{
            var cost = fees[1] + Math.ceil((timeResult-fees[0]) / fees[2])*fees[3]
            answer.push(cost);
        }

    }


    
    return answer;
}