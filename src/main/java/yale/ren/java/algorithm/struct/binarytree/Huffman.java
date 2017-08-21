package yale.ren.java.algorithm.struct.binarytree;

import java.util.List;

/**
 * Created by yale on 2017/8/21.
 * http://blog.csdn.net/leicool_518/article/details/42675333
 */
public class Huffman {



    private Node []  init(){

        String names[] = {"A","B","C","D"};
        int weight [] = {5,7,2,13};

        Node initNode [] = new Node[names.length];

        int i = 0;
        for (String n :names) {
            Node nd = new Node();
            nd.name = n;
            nd.weight= weight[i];
            initNode[i] = nd;
            i++;
        }
        return initNode;
    }


    class Node{

        public String name;
        public int weight;
        public Node left;
        public Node right;

    }

}
