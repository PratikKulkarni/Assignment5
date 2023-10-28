package neebalgurukul.day5;
import java.util.*;
public class LegoSetCompetition {
	
	int binSearch(int start,int end,int[] prefix,int x) {
		int mid,ind=-1;
		//System.out.println("hello5 "+start+" " + end);
		while(start<=end) {
			mid=(start+end)/2;
			if(prefix[mid]==x) {
				ind=mid;
				return ind;
			}else if(prefix[mid]<x) {
				ind=mid;
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		return ind;
	}

	/*
	 * Limited the no. of Lego Sets to 9 and entered their
	 * values before the game starts.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		Scanner sc=new Scanner(System.in);
        int max=1000,min=100,count=0,n1,n2,curr_set1=0,curr_set2=0,ind,x,y1=0,y2=0;
        CompetitionLog cl1=new CompetitionLog(1,"","0",0);
        CompetitionLog cl2=new CompetitionLog(2,"","0",0);
        String[] lego_sets= {"Lego Set 1","Lego Set 2","Lego Set 3","Lego Set 4","Lego Set 5","Lego Set 6","Lego Set 7","Lego Set 8","Lego Set 9"};
        int[] pieces= {2000,500,1000,1800,1500,1000,2000,1500,3000};
        int[] prefix=new int[9];
        prefix[0]=pieces[0];
        int flag=0,flag1=0;
        for(int i=1;i<9;i++) {
        	prefix[i]=prefix[i-1]+pieces[i];
        }

        LegoSetCompetition lsc = new LegoSetCompetition();
        do {
        	count++;
        	flag=0;
        	y1=0;
        	y2=0;
        	
        	
        	System.out.println("Enter the no. of pieces player 1 used for building on day "+count);
        	n1=sc.nextInt();
        	System.out.println("Enter the no. of pieces player 2 used for building on day "+count);
        	n2=sc.nextInt();
        	
        	cl1.setPiecesBuilt(n1);
        	cl2.setPiecesBuilt(n2);
        	
        	if(cl1.getCompleteSets().equals("")) {
        		ind=lsc.binSearch(0,2,prefix,cl1.getPiecesBuilt());
        		if(ind!=-1) {
        			cl1.setCompleteSets(""+ind);
        			cl1.setIncompletesets(""+(ind+1));
        		}
        		
    			
        	}
        	else {
        		if(flag1==0)
        		ind=lsc.binSearch((cl1.getCompleteSets().charAt(0)-'0'),2,prefix,cl1.getPiecesBuilt());
        		else if(flag1==1) {
        			ind=lsc.binSearch((cl1.getCompleteSets().charAt(0)-'0'),5,prefix,cl1.getPiecesBuilt());
        		}
        		else {
        			
        			ind=lsc.binSearch((cl1.getCompleteSets().charAt(0)-'0'),8,prefix,cl1.getPiecesBuilt());
        		}
        		
        		if(ind!=-1) {
        			x=(cl1.getCompleteSets().charAt(0)-'0');
        			if((x!=ind) && ((ind==2) || (ind==5) || (ind==8))) {
        				y1=1;
        				cl1.setCompleteSets(""+ind);
                		cl1.setIncompletesets(""+(ind+1));
        			}else if(x!=ind) {
        				cl1.setCompleteSets(""+ind);
                		cl1.setIncompletesets(""+(ind+1));
        			}
        			
        		}
        		
        		
        		
        	}
        	
        	if(cl2.getCompleteSets().equals("")) {
        		ind=lsc.binSearch(0,2,prefix,cl2.getPiecesBuilt());
        		if(ind!=-1) {
        			
        			cl2.setCompleteSets(""+ind);
        			cl2.setIncompletesets(""+(ind+1));
        		}
        		
        		
        	}
        	else {
        		if(flag1==0)
            		ind=lsc.binSearch((cl2.getCompleteSets().charAt(0)-'0'),2,prefix,cl2.getPiecesBuilt());
            		else if(flag1==1) {
            			ind=lsc.binSearch((cl2.getCompleteSets().charAt(0)-'0'),5,prefix,cl2.getPiecesBuilt());
            		}
            		else {
            			ind=lsc.binSearch((cl2.getCompleteSets().charAt(0)-'0'),8,prefix,cl2.getPiecesBuilt());
            		}
        		
        		if(ind!=-1) {
        			x=(cl2.getCompleteSets().charAt(0)-'0');
        			if((x!=ind) && ((ind==2) || (ind==5) || (ind==8))) {
        				y2=1;
        				cl2.setCompleteSets(""+ind);
                		cl2.setIncompletesets(""+(ind+1));
                		
        			}else if(x!=ind){
        				cl2.setCompleteSets(""+ind);
                		cl2.setIncompletesets(""+(ind+1));
        			}
        			
        		}
        		
        	}
        	
        	
        	if((!(cl1.getCompleteSets().equals(""))) && (cl1.getCompleteSets().charAt(0)=='2') && (y1==1))  {
        		flag=1;
        		if((!(cl2.getCompleteSets().equals(""))) && (cl2.getCompleteSets().charAt(0)=='2') && (y2==1)) {
        			flag=3;
        		}
        	}
        	else {
        		if((!(cl2.getCompleteSets().equals(""))) && (cl2.getCompleteSets().charAt(0)=='2') && (y2==1)) {
        			flag=2;
        		}
        	}
        	if((!(cl1.getCompleteSets().equals(""))) && (cl1.getCompleteSets().charAt(0)=='5') && (y1==1)) {
        		flag=1;
        		if((!(cl2.getCompleteSets().equals(""))) && (cl2.getCompleteSets().charAt(0)=='5') && (y2==1))
        			flag=3;
        	}
        	else {
        		if((!(cl2.getCompleteSets().equals(""))) && (cl2.getCompleteSets().charAt(0)=='5') && (y2==1)) {
        			flag=2;
        		}
        	}
        	if((!(cl1.getCompleteSets().equals(""))) && (cl1.getCompleteSets().charAt(0)=='8') && (y1==1)) {
        		flag=1;
        		if((!(cl2.getCompleteSets().equals(""))) && (cl2.getCompleteSets().charAt(0)=='8') && (y2==1))
        			flag=13;
        	}
        	else {
        		if((!(cl2.getCompleteSets().equals(""))) && (cl2.getCompleteSets().charAt(0)=='8') && (y2==1)) {
        			flag=2;
        		}
        	}
        	
        	if(flag==3 ) {
        		System.out.println("The competition ended in a tie! There will be a tiebreaker round");
        		if(flag1==0)
        		flag1=1;
        		else if(flag1==1)
        			flag1=2;
        		
        	}
        	if(flag==13) {
        		System.out.println("The competition ended in a tie!");
        		break;
        	}
        }while((flag==0) || (flag==3));
        if(flag==1) {
        	System.out.println("Congratulations to player 1 for winning the Lego Set competition!");
        }else if(flag==2) {
        	System.out.println("Congratulations to player 2 for winning the Lego Set competition!");
        }
        else {
        	
        	System.out.println("The competition ended in a tie!");
        	
        }
        System.out.println("Additional information about the competition results is below");
        if(flag==1) {
        	System.out.println(cl1.toString());
        	System.out.println(cl2.toString());
        }
        else if(flag==2) {
        	System.out.println(cl1.toString());
        	System.out.println(cl2.toString());
        }
        else {
        	System.out.println(cl1.toString());
        	System.out.println(cl2.toString());
        }
        System.out.println("The competition lasted "+count+" days.");
	}
	
	

}
