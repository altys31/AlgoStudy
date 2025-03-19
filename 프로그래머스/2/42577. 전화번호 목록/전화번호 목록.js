class Node{
    constructor(value =''){
        this.value = value;
        this.end = false;
        this.child = {}
    }
}

class Trie {
    constructor(){
        this.root = new Node();
    }
    
    insert(string){
        let currentNode = this.root;
        
        for(let i = 0; i<string.length; i++){
            const currentChar = string[i];
            
            if(currentNode.child[currentChar] === undefined){
                currentNode.child[currentChar] = new Node(currentNode.value + currentChar)
            }
             currentNode = currentNode.child[currentChar]
        }
        currentNode.end = true;
    }
    
    search(string) {
        let currentNode = this.root;
        
        for(let i = 0; i < string.length; i++){
            const currentChar = string[i];
            if(currentNode.child[currentChar]){
                currentNode = currentNode.child[currentChar]
                if(currentNode.end && i != string.length-1)
                    return true; 
            }else {
                return false;
            }
        }
        
    }
}

function solution(phone_book) {
    var answer = true;
    const phoneTrie = new Trie();
    
    phone_book.sort((a,b)=> a.length-b.length);

    for(const a of phone_book){
        if(phoneTrie.search(a))
            return false;
        phoneTrie.insert(a);
    }
    
    return answer;
}