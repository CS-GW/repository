public class sll {
    node head;

    public sll(String initialData){
        head = new node(initialData);
    }

    public void append(String data){
        node localNode = this.head;
        while (localNode.next != null){
            localNode = localNode.next;
        }
        localNode.next = new node(data);
    }

    public void insert(String data, int index){
        int counter = 0;
        node localNode = this.head;
        while(counter < index){
            if(localNode.next == null){
                System.out.println("Index out of bounds");
                break;
            } else {
                localNode = localNode.next;
                counter++;
            }
        }
        node newNode = new node(data);
        newNode.next = localNode.next;
        localNode.next = newNode;

    }

    public boolean exists(String data){
        return true;
    }

    public boolean remove(String data){
        return true;
    }

    public String get(int index){
        return "Fluff";
    }

    public String toString(){
        String builder = "";
        node localnode = this.head;
        while(localnode.next != null){
            builder = builder + localnode.data + ", ";
            localnode = localnode.next;
        }
        builder = builder + localnode.data;
        return builder;
    }

    class node {
        String data;
        node next;

        public node(String initialData){
            data = initialData;
        }
    }


}



