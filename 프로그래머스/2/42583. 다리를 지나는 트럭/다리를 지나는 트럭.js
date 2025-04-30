function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    var lastTruck = truck_weights[truck_weights.length-1];
    var bridge = new Array(bridge_length).fill(0);
    
   // console.log(bridge.reduce((a,num)=> a+num,0));
    
    var currentWeights = bridge.reduce((a,num)=> a+num,0);
    
    while(true){
        var currentTruck = truck_weights[0];
        
        if(currentWeights-bridge[0] + currentTruck <= weight){
            bridge.push(truck_weights.shift());
            bridge.shift();
        }
        else{
            bridge.push(0);
            bridge.shift();
        }
        
        answer++;
        
        currentWeights = bridge.reduce((a,num)=> a+num,0);
        if(currentWeights === 0 )
            break;
    }
    
    return answer;
}