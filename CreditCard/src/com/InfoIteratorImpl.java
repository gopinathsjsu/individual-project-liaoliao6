package com;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

public class InfoIteratorImpl implements InfoIterator {

    private List<String> csvInfo;
    private NodeList xmlInfo;
    private JSONArray jsonInfo;
    private int position;
    private int max;

    public InfoIteratorImpl(JSONArray i, int size) {
        jsonInfo = i;
        position = 0;
        max = size;
    }

    public JSONObject currentObject() {
        return (JSONObject) jsonInfo.get(position);
    }

    public InfoIteratorImpl(List<String> i){
        csvInfo = i;
        position = 0;
        max = i.size();
    }

    public String currentString() {

        return csvInfo.get(position);
    }

    public Node currentNode(){

        return xmlInfo.item(position);
    }

    public InfoIteratorImpl(NodeList r){
        xmlInfo = r;
        position = 0;
        max = r.getLength();
    }

    public void goNext(){
        position += 1;
    }

    public boolean isDone(){
         return (max==position);
    }
}
