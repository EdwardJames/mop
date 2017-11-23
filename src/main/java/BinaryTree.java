import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

public class BinaryTree {
    protected Node root;    
    
    public BinaryTree(Node root) {    
        this.root = root;    
    }    
    
    public Node getRoot() {    
        return root;    
    }    
    public static Node init() {    
        Node a = new Node('A');    
        Node b = new Node('B', null, a);    
        Node c = new Node('C');    
        Node d = new Node('D', b, c);    
        Node e = new Node('E');    
        Node f = new Node('F', e, null);    
        Node g = new Node('G', null, f);    
        Node h = new Node('H', d, g);    
        return h;// root    
    }   
    public static void print(Node p){
        System.out.println(p.getKey()+"");
    }
    public static void front(Node p){
        if(p!=null){
            print(p);
            front(p.getLeft());
            front(p.getRight());
        }
    }
    public static void center(Node p){
        if(p!=null){
            center(p.getLeft());
            print(p);
            center(p.getRight());
        }
    }
    public static void behind(Node p){
        if(p!=null){
            behind(p.getLeft());
            behind(p.getRight());
            print(p);
        }
    }
    public static void main(String[] args){
      //  String str = "jklsd爱迪生我";
        //System.out.println(str.hashCode());
       // Map<String,Object> map = Collections.synchronizedMap(null);
       // System.out.println(map);
        LocalDate today = LocalDate.now();
        System.out.println(today.getMonthValue());
    }
}
