function solution(triangle) {
    var answer = 0;
    var maxValues = []
    
    for(let i =0; i< triangle.length; i++){
        var maxValue = [];
        for(let j = 0; j <= i; j++)
            maxValue.push(0)
        maxValues.push(maxValue);
    }
    
    // console.log(maxValues);
    maxValues[0][0] = triangle[0][0];
    
    for(let i = 1; i< triangle.length; i++){
        for(let j =0; j< triangle[i-1].length; j++){
            maxValues[i][j] = Math.max(maxValues[i-1][j] +  triangle[i][j], maxValues[i][j]);
            maxValues[i][j+1] = Math.max(maxValues[i-1][j]+ triangle[i][j+1], maxValues[i][j+1]);
        }
    }
    
    return Math.max.apply(null, maxValues[triangle.length-1]);
}