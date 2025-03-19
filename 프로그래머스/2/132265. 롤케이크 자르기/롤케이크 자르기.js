function solution(topping) {
    var answer = 0;
    var list = [1,2,3];
    var leftTopping = [];
    var rightTopping = [];
    
    const ceolsuSlice = new Set();
    const brotherSlice = new Set();
    
    for(let i = 0; i < topping.length; i++){
        ceolsuSlice.add(topping[i]);
        brotherSlice.add(topping[topping.length-i-1]);
        leftTopping.push(ceolsuSlice.size);
        rightTopping.push(brotherSlice.size);
    }

    for(let i = 0; i< topping.length; i++){
        if(leftTopping[i] === rightTopping[topping.length-i-2])
            answer++;
    }
    

    return answer;
}