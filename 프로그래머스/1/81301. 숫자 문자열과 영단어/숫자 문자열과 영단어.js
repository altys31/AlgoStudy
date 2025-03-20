function solution(s) {
    var word = ['zero','one','two','three' ,'four','five','six','seven' ,'eight','nine'];
    var number = ['0','1','2','3','4','5','6','7','8','9'];
    var regex = /[a-zA-Z]/;
    
    while(s.search(regex) != -1){
        for(let i = 0; i< 10; i++){
            s =  s.replace(word[i], number[i]);
        }
    }
  
    return parseInt(s);
}