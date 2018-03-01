package com.thoughtworks.tw101.exercises.exercise9;

//import sun.rmi.rmic.Names;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private Node left;
    private Node right;



    public Node(String name) {
        this.name = name;
    }

    public void  add(String nameofNewNode){
        if (left == null && nameofNewNode.compareTo(name)<0){
            left = new Node(nameofNewNode);
            return;
        }
        else if (right == null && nameofNewNode.compareTo(name)>0){
            right = new Node(nameofNewNode);
            return;
        }

        else if (nameofNewNode.compareTo(name)<0){
            left.add(nameofNewNode);
        }

        else if (nameofNewNode.compareTo(name)>0){
            right.add(nameofNewNode);
        }

    }

    public List<String> names() {
        return names(new ArrayList<String>());
    }

    private List<String> names(ArrayList<String> res){
        if (left!=null) {
            left.names(res);
        }
        res.add(name);
        if (right!=null) {
            right.names(res);
        }
        return res;
    }
}
