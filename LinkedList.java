package second_Semester;
import java.util.Scanner;

class Node {
    protected int regd_no;
    protected float mark;
    protected Node next;

    public Node(int regd_no, float mark) {
        this.regd_no = regd_no;
        this.mark = mark;
        this.next = null;
    }
}

public class assignment_4 {
    static Node start;

    //Creation
    public static Node create(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter registration number: ");
        int r=sc.nextInt();
        System.out.println("Enter marks: ");
        int m=sc.nextInt();
        Node newNode=new Node(r,m);
        return newNode;
    }

    //display
    public static void display(Node start){
        if (start==null){
            System.out.println("The list is empty");
        }
        Node temp=start;
        while (temp!=null){
            System.out.print("Registration no.: "+ temp.regd_no+" Mark: "+temp.mark+"--> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    //insertion
    public static Node insBeg(Node start){
        Node newNode = create();
        if (start==null){
            start=newNode;
            return start;
        }
        newNode.next=start;
        start=newNode;
        return start;
    }

    public static Node insEnd(Node start){
        Node newNode = create();
        if (start==null){
            start=newNode;
            return start;
        }
        Node temp=start;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return start;
    }

    public static Node insAny(Node start){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position: ");
        int p= sc.nextInt();
        Node newNode=create();
        if (p==1){
            return insBeg(newNode);
        }
        else{
            Node temp= start;
            int i=1;
            while (i<p-1){
                temp=temp.next;
                i++;
            }
            if(temp==null){
                System.out.println("Position out of bounds");
            }
            Node y=temp.next;
            temp.next=newNode;
            newNode.next=y;
        }
        return start;
    }

    //deletion
    public static Node delBeg(Node start){
        if (start==null){
            return null;
        }
        else{
            start=start.next;
        }
        return start;
    }

    public static Node delEnd(Node start){
        if (start==null || start.next==null){
            return null;
        }
        else{
            Node temp=start;
            while (temp.next.next != null) {
                temp=temp.next;
            }
            temp.next=null;
        }
        return start;
    }

    public static Node delAny(Node start){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position: ");
        int p= sc.nextInt();
        Node temp=start;
        int i=1;
        while (i<=p-1){
            temp=temp.next;
            i++;
        }
        Node y=temp.next.next;
        temp.next=y;
        return start;
    }

    public static Node DelByRegd(Node start) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student regd_no to delete:");
        int regd_no = sc.nextInt();
        if (start==null){
            System.out.println("List is empty");
            return null;
        }
        else if (start.regd_no == regd_no) {
            start = start.next;
        }
        else {
            Node temp = start;
            while (temp.next != null && temp.next.regd_no != regd_no) {
                temp = temp.next;
            }
            if (temp.next == null) {
                System.out.println("Node not found.");
            } else {
                temp.next = temp.next.next;
            }
        }
        return start;
    }

    //searching
    public static void search(Node start){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student regd_no to search:");
        int regd_no = sc.nextInt();
        Node temp=start;
        while (temp!=null && temp.regd_no!= regd_no){
            temp=temp.next;
        }
        if (temp==null){
            System.out.println("Node not found");
        }
        else {
            System.out.println("Enter new mark: ");
            temp.mark= sc.nextFloat();
            System.out.println("Marks updated.");
        }
    }

    //sorting
//    public static void sort (Node start){
//
//    }

    //counting
    public static int count(Node start){
        int count=0;
        Node temp=start;
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    //reverse
    public static Node reverse(Node start){
        if (start==null || start.next==null){
            return start;
        }
        Node prevNode=start;
        Node currNode=prevNode.next;
        while (currNode!=null){
            Node nextNode=currNode.next;
            currNode.next=prevNode;

            prevNode=currNode;
            currNode=nextNode;
        }
        start.next=null;
        start=prevNode;
        return start;
    }


    //main
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node start=null;

        while (true){
            System.out.println();
            System.out.println("Menu");
            System.out.println("0:Exit");
            System.out.println("1:Creation");
            System.out.println("2:Display");
            System.out.println("3:Insertion at beginning");
            System.out.println("4:Insertion at end");
            System.out.println("5:Insertion at any place");
            System.out.println("6:Deletion at beginning");
            System.out.println("7:Deletion at end");
            System.out.println("8:Deletion at any place");
            System.out.println("9: Delete by Regd_no");
            System.out.println("10:Searching");
            System.out.println("11:Sorting");
            System.out.println("12:Counting");
            System.out.println("13:Reverse");
            System.out.println("Enter the choice: ");
            int choice= sc.nextInt();
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    start = create();
                    break;
                case 2:
                    display(start);
                    break;
                case 3:
                    start = insBeg(start);
                    break;
                case 4:
                    start = insEnd(start);
                    break;
                case 5:
                    start = insAny(start);
                    break;
                case 6:
                    start = delBeg(start);
                    break;
                case 7:
                    start = delEnd(start);
                    break;
                case 8:
                    start = delAny(start);
                    break;
                case 9:
                    start = DelByRegd(start);
                    break;
                case 10:
                    search(start);
                    break;
                case 11:
                   // sort(start);
                    break;
                case 12:
                    System.out.println("Number of nodes: " + count(start));
                    break;
                case 13:
                    start = reverse(start);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}
