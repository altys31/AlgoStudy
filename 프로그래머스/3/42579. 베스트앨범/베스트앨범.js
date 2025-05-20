class Song {
    constructor (number, play){
        this.number = number;
        this.play = play;
    }
    
}

function solution(genres, plays) {
    var answer = [];
    var genreDic = {};
    var genreIndividual = {};
    
    for(let i = 0; i<genres.length; i++){
        if (!genreDic[genres[i]]){
            genreDic[genres[i]] = plays[i];
            genreIndividual[genres[i]] = [];
        }
        else
            genreDic[genres[i]] += plays[i];
        genreIndividual[genres[i]].push(new Song(i, plays[i]));
    }
    
    for(var genre of Object.keys(genreIndividual)){
         genreIndividual[genre].sort((a,b)=>{
             if(b.play !== a.play)
                return b.play-a.play
             else 
                 return a.number-b.number
         });
    }
    
    const best = [];
    
    var genreList = Object.keys(genreDic).sort((a,b)=>genreDic[b]-genreDic[a]);
    for(let i = 0; i< Object.keys(genreDic).length; i++){
        answer.push (genreIndividual[genreList[i]][0].number);
        if(genreIndividual[genreList[i]].length > 1)
            answer.push(genreIndividual[genreList[i]][1].number);
    }


    return answer;
}
