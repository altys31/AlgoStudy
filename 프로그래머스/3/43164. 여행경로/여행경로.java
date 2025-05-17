import java.util.*;

class Ticket {
        String to;
        boolean available;
    
    Ticket(String to){
        this.to = to;
        this.available = true; 
    }
    
}

class Solution {
    

    static ArrayList<String> answer;
    static int ticketNum;
    static boolean done;
    
    public String[] solution(String[][] tickets) {
        
        answer = new ArrayList<String> ();
        HashMap<String, ArrayList<Ticket>> dic = new HashMap<>();
        ticketNum = tickets.length;
        done = false; 
        
        for(String[] ticket : tickets){
            if(dic.get(ticket[0]) == null){
                dic.put(ticket[0], new ArrayList<Ticket> ());
            }
            dic.get(ticket[0]).add(new Ticket(ticket[1]));
        }
        
        for(String airport : dic.keySet()){
            dic.get(airport).sort((a,b)-> a.to.compareTo(b.to));
        }
        
        answer.add("ICN");
        for(Ticket ticket : dic.get("ICN")){
            ticket.available = false;
            answer.add(ticket.to);
            bt(ticket.to, 1,dic);
            if(done)
                break;
            answer.remove(answer.size()-1);
            ticket.available = true;
        }
        
        return answer.toArray(new String[0]);
 
            
    }

    
    static void bt(String to, int number, HashMap<String, ArrayList<Ticket>> dic){
      if(number == ticketNum){
          done =true;
          return;
      }
        if (!dic.containsKey(to)) return;
        for(Ticket nextTicket : dic.get(to)){
            if(nextTicket.available){
                nextTicket.available = false;
                answer.add(nextTicket.to);
                bt(nextTicket.to, number+1, dic);
                if(done)
                    return;
                answer.remove(answer.size()-1);
                nextTicket.available = true;
            }

            
        }
        
        
    }
}