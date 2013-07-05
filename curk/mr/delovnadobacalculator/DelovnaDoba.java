package curk.mr.delovnadobacalculator;

public class DelovnaDoba {
	private int let;
	private int mesecev;
	private int dni;

public DelovnaDoba(int l,int m, int d){
	let = l;
	mesecev = m;
	dni = d;
}

public DelovnaDoba() {
	let = 0;
	mesecev = 0;
	dni = 0;
}

public void addDD(int l,int m, int d){
	mesecev += ((d + dni) / 30);
	dni = (d + dni) % 30;
	
	let += ((m + mesecev) / 12);
	mesecev = (m + mesecev) % 12;
	
	let += l;
}

public void toPrintDD(){
	System.out.println("Delovna doba je: " + let +  " let, " + mesecev + " mesecev, " + dni + " dni!" );
}

public String toString() {
	return " " + let +  " let, " + mesecev + " mesecev, " + dni + " dni!";
	
}

public void resetDD() {
	let = 0;
	mesecev = 0;
	dni = 0;	
}

}
