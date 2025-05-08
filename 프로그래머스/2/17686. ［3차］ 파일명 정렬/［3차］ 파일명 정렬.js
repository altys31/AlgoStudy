function solution(files) {
    var answer = [];
    var fileList = [];
    
    const rg = /a-z/;
    
    
    for(var file of files){
        
        var fileName = [];
        
        const head = file.match(/^[^\d]+/)[0];
        const num = file.slice(head.length).match(/^\d+/)[0];
        
        const tail = file.slice(head.length + num.length);
        if(tail){
            fileName.push(tail)
        }
        fileName.unshift(num);
        fileName.unshift(head);

        
        fileList.push(fileName);
    }
    
    fileList.sort((a,b)=>{
        const headA = a[0].toLowerCase();
        const headB = b[0].toLowerCase();
        
        if(headA < headB) return -1;
        if(headA > headB) return 1;
        
        return parseInt(a[1]) - parseInt(b[1]);
    })
    
    console.log(fileList);
    
    for(var file of fileList){
        
        var str = "";
        
        file.forEach((word)=>{
            str += word;
        })
        
        answer.push(str);
       
    }
    return answer;
}