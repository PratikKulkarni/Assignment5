package neebalgurukul.day5;

public class CompetitionLog {
	private int playerNumber;
	private String completeSets;
	private String incompleteSets;
	private int piecesBuilt;
	public CompetitionLog(int playerNumber, String completeSets,String incompleteSets, int piecesBuilt) {
		this.playerNumber=playerNumber;
		this.completeSets=completeSets;
		this.incompleteSets=incompleteSets;
		this.piecesBuilt=piecesBuilt;
	}
	public int getPlayerNumber() {
		return this.playerNumber;
	}
	public String getCompleteSets() {
		return this.completeSets;
	}
	public String getIncompleteSets() {
		return this.incompleteSets;
	}
	public int getPiecesBuilt() {
		return this.piecesBuilt;
	}
	public void setCompleteSets(String completeSets) {
		this.completeSets=completeSets;
	}
	public void setIncompletesets(String incompleteSets) {
		this.incompleteSets=incompleteSets;
	}
	public void setPiecesBuilt(int piecesBuilt) {
		this.piecesBuilt+=piecesBuilt;
	}
	public String toString() {
		int val;
		String s1="Player "+this.getPlayerNumber()+" completed the following sets: ";
		if(!this.getCompleteSets().equals("")) {
			val=(this.getCompleteSets().charAt(0)-'0');
			for(int i=0;i<val;i++) {
				s1=s1+"Lego Set "+(i+1)+", ";
			}
			s1+="Lego Set "+(val+1)+"\n";
		}
		
		else {
			s1+="None\n";
			
		}
		//System.out.println("hi "+val);
		//String s1="Player "+this.getPlayerNumber()+" completed the following sets: ";
		
		val=this.getIncompleteSets().charAt(0)-'0';
		//System.out.println("hi "+val);
		String s2="Player "+this.getPlayerNumber()+" did not complete the following sets: ";
		int val1;
		if(val==9)
			s2+="None\n";
		else {
			if(val%3==0) {
				if(val==0)
					s2+="Lego Set "+(val+1)+", Lego Set "+(val+2)+", Lego Set "+(val+3)+"\n";
				else {
					s2+="None\n";
				}
			}
			else {
				if(val%3==1)
					s2+="Lego Set "+(val+1)+", Lego Set "+(val+2)+"\n";
				else {
					s2+="Lego Set "+(val+1)+"\n";
				}
			}
		}
		String s3="Player "+this.playerNumber+" built a total of "+this.getPiecesBuilt()+" pieces\n";
		String s=s1+s2+s3;
		return s;
	}
}
