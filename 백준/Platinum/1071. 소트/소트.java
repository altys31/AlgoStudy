import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		

		list.sort(null);
		
		while (true) {
			boolean check = true;
			for (int i = 0; i < list.size(); i++) {
				if (i != list.size() - 1) {
					if (check_serial(list, i)) {
						if ((i != list.size() - 2) && !(list.get(i+2).equals(list.get(i+1)))) {
							int buf = list.get(i + 2);
							list.set(i + 2, list.get(i + 1));
							list.set(i + 1, buf);
							if(check_serial(list,i+1)) {
								buf = list.get(i + 2);
								list.set(i + 2, list.get(i + 1));
								list.set(i + 1, buf);
								buf = list.get(i + 1);
								list.set(i + 1, list.get(i));
								list.set(i, buf);
							}
							
						} else {
							int buf = list.get(i + 1);
							list.set(i + 1, list.get(i));
							list.set(i, buf);
						}
						
					}
				}
			}
			for (int i = 0; i < list.size() - 1; i++) {
				if (check_serial(list, i))
					check = false;
			}

			if (check) {
				break;
			}

		}
		
//		for(int i =0; i< list.size(); i++)
//			System.out.print(list.get(i) + " ");
//		System.out.println();
//		
		//사전 순으로 증가하는 경우 실행
		
		//내가 빠졌을때 연속이 되는지 체크
		//내가 들어갔을때 연속이 되는지 체크
		//모든 경우를 확인했는데 바뀌는게 없다면 종료
		
		
		
		while(true) {
			boolean change = false;
			
			
			for(int i = 0; i<list.size(); i++) {
				//사전순으로 증가하는지 체크 
				boolean isok = false;
				
				if(i !=0 && i != list.size()-1) 
					if(list.get(i-1)-list.get(i+1) == -1)
						continue;
					
				for(int j = i+1; j<list.size(); j++) {

					if(list.get(i) > list.get(j)) {
						isok = true;
						if(j != list.size()-1) {
							if(list.get(j) -list.get(i) != -1&&list.get(i) - list.get(j+1) != -1) {
								list.add(j+1, list.get(i));
								change = true;
								list.remove(i);
//								for(int k =0; k< list.size(); k++)
//									System.out.print("a"+list.get(k) + " ");
//								System.out.println();
								break;
							}
						}
						else {
							if(list.get(j)-list.get(i) != -1) {
								change = true;
								list.add(j+1, list.get(i));
								list.remove(i);
//								for(int k =0; k< list.size(); k++)
//									System.out.print("b"+list.get(k) + " ");
//								System.out.println();
								break;
							}
						}
					}
					
					if(list.get(i) <= list.get(j) && isok) {
						if(list.get(i) - list.get(j) != -1 && list.get(j-1) - list.get(i) != -1) {
							
						}
						else {
							if(j != list.size()-1) {
								if(list.get(i)-list.get(j+1) != -1) {
									change = true;
									list.add(j+1,list.get(i));
									list.remove(i);
//									for(int k =0; k< list.size(); k++)
//										System.out.print("c"+list.get(k) + " ");
//									System.out.println();
									break;
								}
								
							}
							else {
								change = true;
								list.add(j+1,list.get(i));
								list.remove(i);
//								for(int k =0; k< list.size(); k++)
//									System.out.print("d"+list.get(k) + " ");
//								System.out.println();
								break;
								
							}

						}
						
					}
				}
				
			}

			if(!change)
				break;
		}
		
		if(N>2) {
		int num = list.get(list.size()-1);
		if(list.get(list.size()-2)-num  == -1) {
		for(int i = 0; i <list.size(); i++) {
			if(i != list.size()-1 && list.get(i).equals(num)) {
				list.add(i,num);
				list.remove(list.size()-1);
				break;
			}

		}
		}
		}
		
		
		for(int k =0; k< list.size(); k++)
			bw.append(Integer.toString(list.get(k))).append(" ");
		
		bw.close();

	}

	public static boolean check_serial(ArrayList<Integer> list, int i) {
		if ((list.get(i) - list.get(i + 1)) == -1)
			return true;
		else
			return false;
	}

}