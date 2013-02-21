package phraser;

public class Main {
    
    public static void main(String[] args) {
        Phraser p = new Phraser();
        
        p.adjective("gratuitous");
        p.noun("ball");
        p.adjective("mauve");
        p.noun("book");
        System.out.println("A: " + p.verb("examine"));
        
        p.noun("fireplace");
        System.out.println("B: " + p.verb("investigate"));
        
        p.adjective("dilapidated");
        System.out.println("C: " + p.verb("probe"));
        
        System.out.println("D: " + p.verb("reconnoiter"));
        
        p.noun("table");
        System.out.println("E: " + p.verb(null));
    }
}
