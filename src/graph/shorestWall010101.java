package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class shorestWall010101 {

    Queue<Node> q0;
    Queue<Node> q1;
    Set<String> visited;

    public int findShorestNumwall(){
        q0 = new LinkedList<>();
        q1 = new LinkedList<>();
        visited = new HashSet<>();



        return 0;
    }


    private void helper(){

    }



    public int findsUsingBFS2(){

        return 0;
    }




    class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return x+","+y;
        }
    }
}
